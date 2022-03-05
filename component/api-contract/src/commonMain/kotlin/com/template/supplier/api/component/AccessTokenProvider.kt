package com.template.supplier.api.component

interface AccessTokenProvider {
    fun provide(): AccessToken?
}
