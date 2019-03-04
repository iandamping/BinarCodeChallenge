package com.example.junemon.binarchallengecode.model

data class User(var name: String?, var email: String?, var organization: String?, var password: String?) {
    constructor() : this(null, null, null, null)
}