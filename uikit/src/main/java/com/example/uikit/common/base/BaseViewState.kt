package com.example.uikit.common.base

abstract class BaseViewState(
    open var isLoading: Boolean,
    open var error: Throwable?
)