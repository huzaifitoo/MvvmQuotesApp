package com.example.quoteappmvvm

class GenericResponse<T> (
    val data: T?, val success : Boolean, val message : String?
        )


