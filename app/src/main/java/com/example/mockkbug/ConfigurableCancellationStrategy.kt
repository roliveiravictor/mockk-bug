package com.example.mockkbug

import kotlin.system.exitProcess

@Suppress("TooGenericExceptionCaught")
interface ConfigurableCancellationStrategy {

    /**
     * Whether configurable strategy should be cancelled or not.
     *
     * @return True whenever needs to be cancelled
     */
    suspend fun shouldCancel(): Boolean

    /**
     * Whatever needs to be executed when cancellation is not requested.
     *
     * @return Instruction to be invoked
     */
    fun onContinuation() = Unit

    /**
     * Kills the Application if cancellation is requested.
     */
    fun onCancel() = try {
        exitProcess(0)
    } catch (e: RuntimeException) {
        // Do nothing
    }
}
