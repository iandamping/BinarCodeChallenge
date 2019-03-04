package com.example.junemon.binarchallengecode.model

/**
 * Created by ian on 04/March/19.
 */
data class AndroidType(var codeName: String?, var version: String?, var apiLevel: String?) {
    constructor() : this(null, null, null)
}