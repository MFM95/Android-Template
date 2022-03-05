package com.template.supplier.core.component.exception

sealed class ApiException(override val message: String?): RuntimeException(message) {
    open class Client(message: String?) : ApiException(message)
    open class Server(message: String?) : ApiException(message)
    open class General(message: String?) : ApiException(message)
    object Connection : ApiException(message = null)
}
