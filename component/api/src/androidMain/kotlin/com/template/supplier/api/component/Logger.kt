package com.template.supplier.api.component

import android.util.Log
import io.ktor.client.features.logging.Logger

internal actual val Logger: Logger
  get() = object : Logger {
    override fun log(message: String) {
      Log.d("HttpClient", message)
    }
  }
