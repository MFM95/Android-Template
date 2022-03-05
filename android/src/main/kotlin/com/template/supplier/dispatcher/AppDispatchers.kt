package com.template.supplier.dispatcher


import com.template.supplier.core.component.dispatcher.DomainDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object AppDomainDispatcher : DomainDispatcher, CoroutineContext by Dispatchers.Default
object AppDataDispatcher : DataDispatcher, CoroutineContext by Dispatchers.IO
