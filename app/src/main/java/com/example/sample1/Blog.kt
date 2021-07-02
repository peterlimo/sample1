package com.example.sample1


data class Blog (
    val title:String

) {
    override fun toString(): String {
        return "$title"
    }
}