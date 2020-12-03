package com.example.fetchrewards.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fetchrewards.remote.FetchService
import com.example.fetchrewards.remote.ItemModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ItemViewModel(application: Application): ViewModel() {

    private val TAG = "ItemViewModel"

    private val fetchService = FetchService.create()
    private var remoteItems = MutableLiveData<List<ItemModel>>()
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getFetchItems() {
        fetchService.getItems()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (!it.isNullOrEmpty()) {
                    remoteItems.postValue(it)
                } else {
                    remoteItems.postValue(listOf())
                }
            },{
                Log.d(TAG, it.message.toString())
            }).let {
                compositeDisposable.add(it)
            }
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        compositeDisposable.clear()
        super.onCleared()
    }

    fun getItemList(): MutableLiveData<List<ItemModel>> {
        return remoteItems
    }
}