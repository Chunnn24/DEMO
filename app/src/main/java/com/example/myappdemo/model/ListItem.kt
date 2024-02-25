package com.example.myappdemo.model

sealed class ListItem {
    data class Title(val tvTitle: String) : ListItem()
    data class DetailsContentGold (
        val tvContent: String,
        val tvValueGold: String
    ): ListItem()
    data class DetailsContent (
        val tvContent: String,
        val tvValue: String
    ): ListItem()
}