package com.admissiontest.domain.model

data class User(
    val id: Long = 0,
    val name: String = "",
    val username: String = "",
    val email: String = "",
    val address: Address = Address(),
    val phone: String = "",
    val website: String = "",
    val company: Company = Company()
)
