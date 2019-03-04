package com.example.junemon.binarchallengecode.model

data class AndroidType(var codeName: String?, var version: String?, var apiLevel:String?) {
    constructor() : this(null, null,null)
}