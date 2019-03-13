package com.art

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VectorTest {
    private val aiCount = 5
    private val ai = vector(aiCount, fill = 1)
    private val bi = vector(1..5)

    @Test
    fun `test elements size`() {
        Assertions.assertEquals(aiCount, ai.size)
    }

    @Test
    fun `test negative vector test`() {
        val output = vector(5, -1)
        Assertions.assertEquals(output, -ai)
    }

    @Test
    fun `test positive vector test`() {
        val output = vector(1..5)
        Assertions.assertEquals(output, +bi)
    }

    @Test
    fun `test vector add size fail`() {
        val vector = vector(1..6)
        Assertions.assertThrows(IllegalArgumentException::class.java) { ai + vector }
    }

    @Test
    fun `test vector add`() {
        val output = vector(2..6)
        Assertions.assertEquals(output, (ai + bi))
    }

    @Test
    fun `test vector subtract`() {
        val output = vector(0..4)
        Assertions.assertEquals(output, (bi - ai))
    }

    @Test
    fun `test vector multiply`() {
        val output = vector(1..5)
        Assertions.assertEquals(output, (bi * ai))
    }

    @Test
    fun `test vector divide`() {
        val output = vector(1..5)
        Assertions.assertEquals(output, (bi / ai))
    }

    @Test
    fun `test vector module`() {
        val output = vector(count = 5)
        Assertions.assertEquals(output, (bi % ai))
    }

    @Test
    fun `test vector add int`() {
        val output = vector(5, 2)
        Assertions.assertEquals(output, (ai + 1))
    }

    @Test
    fun `test vector subtract int`() {
        val output = vector(5, 1)
        Assertions.assertEquals(output, (ai + 0))
    }

    @Test
    fun `test vector multiply int`() {
        val output = vector(5, 1)
        Assertions.assertEquals(output, (ai * 1))
    }

    @Test
    fun `test vector divide int`() {
        val output = vector(5, 1)
        Assertions.assertEquals(output, (ai / 1))
    }

    @Test
    fun `test vector module int`() {
        val output = vector(count = 5)
        Assertions.assertEquals(output, (ai % 1))
    }

    @Test
    fun `test int divide vector`() {
        val output = vector(5, 2)
        Assertions.assertEquals(output, (2 / ai))
    }

    @Test
    fun `test int multiply vector`() {
        val output = vector(5, 2)
        Assertions.assertEquals(output, (2 * ai))
    }

    @Test
    fun `test int add vector`() {
        val output = vector(5, 3)
        Assertions.assertEquals(output, (2 + ai))
    }


    @Test
    fun `test int subtract vector`() {
        val output = vector(5, 1)
        Assertions.assertEquals(output, (2 - ai))
    }

    @Test
    fun `test int module vector`() {
        val output = vector(5, 0)
        Assertions.assertEquals(output, (2 % ai))
    }

    @Test
    fun `test vector get`() {
        val output = 3
        Assertions.assertEquals(output, bi[2])
    }

    @Test
    fun `test vector get exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) { bi[20] }
    }

    @Test
    fun `test vector get range`() {
        val output = vector(2..4)
        Assertions.assertEquals(output, bi[2..4])
    }

    @Test
    fun `test vector get range exception`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) { bi[0..3] }
    }

    @Test
    fun `test vector get range exception 2`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) { bi[1..22] }
    }

    @Test
    fun `test vector double`() {
        val output = vector(2..6).asDouble()
        val af = vector(5, fill = 1.0)
        val bf = bi.asDouble()
        Assertions.assertEquals(output, bf + af)
    }

    @Test
    fun `test vector double vector plus int`() {
        val output = vector(2..6).asDouble()
        val bf = bi.asDouble()
        Assertions.assertEquals(output, bf + 1)
    }
}
