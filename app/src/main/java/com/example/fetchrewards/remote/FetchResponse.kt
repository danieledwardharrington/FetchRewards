package com.example.fetchrewards.remote

import com.google.gson.annotations.Expose
import org.json.JSONArray

data class FetchResponse(@Expose
                         val result: List<ItemModel>)