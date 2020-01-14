package com.dmi.mykotlinlib.exceptionhandle

import androidx.annotation.Keep

@Keep
class WexerSdkException(message: String?) : Exception(message)