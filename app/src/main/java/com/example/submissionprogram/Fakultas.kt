package com.example.submissionprogram

import java.io.Serializable

data class Fakultas(
    var name: String = "",
    var alamat: String = "",
    var website: String = "",
    var phone: String = "",
    var detail: String = "",
    var photo: Int = 0
): Serializable