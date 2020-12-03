package com.example.fetchrewards.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.fetchrewards.remote.FetchService
import com.example.fetchrewards.remote.ItemModel
import io.reactivex.rxjava3.schedulers.Schedulers

class ItemViewModel(application: Application): ViewModel() {

    private val TAG = "ItemViewModel"

    private val fetchService = FetchService.create()
    private var remoteItems: ArrayList<ItemModel> = ArrayList()

    fun getFetchItems(): ArrayList<ItemModel> {
        fetchService.getItems()
            .subscribeOn(Schedulers.io())
            .subscribe({
                it.forEach {
                    remoteItems.add(it)
                }
                Log.d(TAG, it.toString())
                //remoteItems = ArrayList(it)
            },{
                Log.d(TAG, "Error")
                Log.d(TAG, it.message.toString())
            })

        Log.d(TAG, remoteItems.size.toString())
        return remoteItems
    }

}