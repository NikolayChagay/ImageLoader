package com.example.testgridlayout.model

sealed class ApplicationState {
    object loading: ApplicationState()
    object error_retry: ApplicationState()
    object success: ApplicationState()
}