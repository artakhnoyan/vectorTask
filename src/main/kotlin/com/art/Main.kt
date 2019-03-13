package com.art

fun main(args: Array<String>) {
    val ai = vector(5, fill = 1)
    val bi = vector(1..5)

    println(ai.size) // 5
    println(bi) // [1, 2, 3, 4, 5]
    println(+bi) // [1, 2, 3, 4, 5]
    println(-bi) // [-1, -2, -3, -4, -5]

    println(bi + ai) // [2, 3, 4, 5, 6]
    println(bi - ai) // [0, 1, 2, 3, 4]
    println(bi * ai) // [1, 2, 3, 4, 5]
    println(bi / ai) // [1, 2, 3, 4, 5]
    println(bi % ai) // [0, 0, 0, 0, 0]

    println(ai + 1) // [2, 2, 2, 2, 2]
    println(ai - 0) // [1, 1, 1, 1, 1]
    println(ai / 1) // [1, 1, 1, 1, 1]
    println(ai * 1) // [1, 1, 1, 1, 1]

    println(2 / ai) // [1, 1, 1, 1, 1]
    println(1 * ai) // [1, 1, 1, 1, 1]
    println(0 + ai) // [1, 1, 1, 1, 1]
    println(2 - ai) // [1, 1, 1, 1, 1]

    println(bi[2]) // 3

    println(bi[1..3] + bi[2..4]) // [5, 7, 9]

    println(bi % ai == vector(6)[1..5]) // true

    val af = vector(5, fill = 1.0)
    val bf = bi.asDouble()
    println(bf + af) // [2.0, 3.0, 4.0, 5.0, 6.0]
    println(bf - af) // [0.0, 1.0, 2.0, 3.0, 4.0]
    println(bf * af) // [1.0, 2.0, 3.0, 4.0, 5.0]
    println(bf / af) // [1.0, 2.0, 3.0, 4.0, 5.0]

    println(af * 1) // [1.0, 1.0, 1.0, 1.0, 1.0]
}