package com.template.supplier.presentation.component

import android.content.Context

actual class StringProvider(private val context: Context) {

    actual val connectionError: String
        get() = context.getString(R.string.connection_error)
    actual val generalError: String
        get() = context.getString(R.string.general_error)
}
