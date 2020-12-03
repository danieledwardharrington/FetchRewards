package com.example.fetchrewards.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemModel {

    @SerializedName("id")
    @Expose
    private var itemId: Int = 0

    @SerializedName("listId")
    @Expose
    private var itemListId: Int = 0

    @SerializedName("name")
    @Expose
    private var itemName: String = ""

    fun getItemId(): Int {
        return itemId
    }

    fun setItemId(newId: Int) {
        itemId = newId
    }

    fun getItemListId(): Int {
        return itemListId
    }

    fun setItemListId(newListId: Int) {
        itemListId = newListId
    }

    fun getItemName(): String {
        return itemName
    }

    fun setItemName(newName: String) {
        itemName = newName
    }
}