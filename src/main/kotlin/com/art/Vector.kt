package com.art

fun vector(count: Int, fill: Int = 0) = IntVector(arrayOfAndFill(count, fill))

fun vector(count: Int, fill: Double) = DoubleVector(arrayOfAndFill(count, fill))

fun vector(elementsRange: IntRange) = IntVector(elementsRange.toList())

abstract class BaseVector<T : Number>(protected val elements: List<T>) {

    abstract operator fun get(elementsRange: IntRange): BaseVector<T>

    val size = elements.size

    fun map(expression: (T) -> T) = elements.map { expression(it) }

    protected fun checkAndMap(other: BaseVector<T>, expression: (T, T) -> T) =
            when {
                this.size == other.size -> elements.mapIndexed { index, item -> expression(item, other.elements[index]) }
                else -> throw IllegalArgumentException("vectors size are not same")
            }

    protected fun getSubElementsOrThrow(elementsRange: IntRange) =
            when {
                elements.containsSub(elementsRange) -> elements.subList(elementsRange.first - 1, elementsRange.last)
                else -> throw IllegalArgumentException("Vector doesn't contains given range")
            }

    operator fun get(index: Int) =
            when {
                elements.containsIndex(index) -> elements[index]
                else -> throw IllegalArgumentException("index that you set is greater than Vector size")
            }

    override fun hashCode() = size.hashCode() + elements.hashCode()

    override fun equals(other: Any?) = elements == (other as? BaseVector<*>)?.elements

    override fun toString() = elements.toString()
}

class IntVector(elements: List<Int>) : BaseVector<Int>(elements) {
    operator fun unaryMinus() = IntVector(map { it * -1 })
    operator fun unaryPlus() = IntVector(elements)

    operator fun plus(other: IntVector) = IntVector(checkAndMap(other) { first, second -> first + second })
    operator fun minus(other: IntVector) = IntVector(checkAndMap(other) { first, second -> first - second })
    operator fun times(other: IntVector) = IntVector(checkAndMap(other) { first, second -> first * second })
    operator fun div(other: IntVector) = IntVector(checkAndMap(other) { first, second -> first / second })
    operator fun rem(other: IntVector) = IntVector(checkAndMap(other) { first, second -> first % second })

    operator fun plus(number: Int) = IntVector(map { it + number })
    operator fun minus(number: Int) = IntVector(map { it - number })
    operator fun times(number: Int) = IntVector(map { it * number })
    operator fun div(number: Int) = IntVector(map { it / number })
    operator fun rem(number: Int) = IntVector(map { it % number })

    override fun get(elementsRange: IntRange) = IntVector(getSubElementsOrThrow(elementsRange))

    fun asDouble() = DoubleVector(elements.map { it.toDouble() })
}

class DoubleVector(elements: List<Double>) : BaseVector<Double>(elements) {
    operator fun unaryMinus() = DoubleVector(map { it * -1 })
    operator fun unaryPlus() = DoubleVector(elements)

    operator fun plus(other: DoubleVector) = DoubleVector(checkAndMap(other) { first, second -> first + second })
    operator fun minus(other: DoubleVector) = DoubleVector(checkAndMap(other) { first, second -> first - second })
    operator fun times(other: DoubleVector) = DoubleVector(checkAndMap(other) { first, second -> first * second })
    operator fun div(other: DoubleVector) = DoubleVector(checkAndMap(other) { first, second -> first / second })
    operator fun rem(other: DoubleVector) = DoubleVector(checkAndMap(other) { first, second -> first % second })

    operator fun plus(number: Double) = DoubleVector(map { it + number })
    operator fun minus(number: Double) = DoubleVector(map { it - number })
    operator fun times(number: Double) = DoubleVector(map { it * number })
    operator fun div(number: Double) = DoubleVector(map { it / number })
    operator fun rem(number: Double) = DoubleVector(map { it % number })

    operator fun plus(number: Int) = DoubleVector(map { it + number })
    operator fun minus(number: Int) = DoubleVector(map { it - number })
    operator fun times(number: Int) = DoubleVector(map { it * number })
    operator fun div(number: Int) = DoubleVector(map { it / number })
    operator fun rem(number: Int) = DoubleVector(map { it % number })

    override fun get(elementsRange: IntRange) = DoubleVector(getSubElementsOrThrow(elementsRange))
}

operator fun Int.div(vector: IntVector) = IntVector(vector.map { this / it })
operator fun Int.times(vector: IntVector) = IntVector(vector.map { this * it })
operator fun Int.plus(vector: IntVector) = IntVector(vector.map { this + it })
operator fun Int.minus(vector: IntVector) = IntVector(vector.map { this - it })
operator fun Int.rem(vector: IntVector) = IntVector(vector.map { this % it })

operator fun Double.div(vector: BaseVector<Double>) = DoubleVector(vector.map { this / it })
operator fun Double.times(vector: BaseVector<Double>) = DoubleVector(vector.map { this * it })
operator fun Double.plus(vector: BaseVector<Double>) = DoubleVector(vector.map { this + it })
operator fun Double.minus(vector: BaseVector<Double>) = DoubleVector(vector.map { this - it })
operator fun Double.rem(vector: BaseVector<Double>) = DoubleVector(vector.map { this % it })

private fun <E> List<E>.containsSub(elementsRange: IntRange) = elementsRange.first > 0 && elementsRange.last < this.size
private fun <E> List<E>.containsIndex(index: Int) = index >= 0 && index < this.size

private fun <T> arrayOfAndFill(count: Int, fill: T): List<T> {
    val elements = mutableListOf<T>()
    for (index in 0 until count) {
        elements.add(fill)
    }
    return elements
}
