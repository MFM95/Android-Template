package com.template.supplier.api.component

import io.ktor.client.features.logging.Logger
import platform.Foundation.NSLog

internal actual val Logger: Logger
  get() = object : Logger {
    override fun log(message: String) {
      NSLog(message)
    }
  }
