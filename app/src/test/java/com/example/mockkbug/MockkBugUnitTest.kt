package com.example.mockkbug

import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.coVerifySequence
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MockkBugUnitTest {

    @RelaxedMockK
    lateinit var strategy: ConfigurableCancellationStrategy

    @Before
    fun setup() { MockKAnnotations.init(this) }

    @Test
    fun `test should trigger mockk bug`() {
        MockkBug().trigger(strategy)
        coVerifySequence {
            repeat(103) {
                strategy.shouldCancel()
                strategy.onContinuation()
            }
        }
    }
}