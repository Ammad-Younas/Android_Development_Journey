package com.madirwx.shoppinglist

data class ShoppingItem (
    var  id: Int,
    var name: String,
    var quantity: Int,
    var isEditing : Boolean = false
)
