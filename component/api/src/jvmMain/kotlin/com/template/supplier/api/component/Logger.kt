package com.template.supplier.api.component

import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.SIMPLE

internal actual val Logger: Logger
  get() = Logger.SIMPLE
