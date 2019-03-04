package com.example.junemon.binarchallengecode.model

/**
 * Created by ian on 04/March/19.
 */
data class User(var name: String?, var email: String?, var organization: String?, var password: String?) {
    constructor() : this(null, null, null, null)
}