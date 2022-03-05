package com.template.supplier.testing.component

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
private val testDispatcher = StandardTestDispatcher()
@ExperimentalCoroutinesApi
val DomainDispatcher.test: TestDispatcher get() = testDispatcher
@ExperimentalCoroutinesApi
val DataDispatcher.test: TestDispatcher get() = testDispatcher

@ExperimentalCoroutinesApi
object AppTestDispatcher : DomainDispatcher, DataDispatcher, CoroutineContext by testDispatcher
