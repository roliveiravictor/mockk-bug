package com.example.mockkbug

import kotlinx.coroutines.runBlocking

class MockkBug {

    @JvmName("triggerFun")
    fun trigger(strategy: ConfigurableCancellationStrategy) {
        runBlocking {
            repeat(100) {
                strategy.shouldCancel()
                strategy.onContinuation()
            }
        }
    }
}