package com.example.testgridlayout.domain.repository.network

sealed class NetworkState {
    object loading: NetworkState()
    object error_retry: NetworkState()
    object success: NetworkState()
}