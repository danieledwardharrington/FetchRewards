package com.example.fetchrewards.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchrewards.R
import com.example.fetchrewards.adapter.FetchItemAdapter
import com.example.fetchrewards.remote.ItemModel
import com.example.fetchrewards.viewmodel.ItemViewModel
import com.example.fetchrewards.viewmodel.ItemViewModelFactory
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment: Fragment() {
    private val TAG = "ListFragment"

    private lateinit var itemViewModel: ItemViewModel
    private lateinit var fetchItemAdapter: FetchItemAdapter
    private var fetchItems = ArrayList<ItemModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        Log.d(TAG, "init")
        itemViewModel = ViewModelProvider(this, ItemViewModelFactory(requireActivity().application)).get(ItemViewModel::class.java)
        initRV()
        itemViewModel.getFetchItems()
        filterList()
    }

    private fun initRV() {
        Log.d(TAG, "initRV")
        items_recycler_view.layoutManager = LinearLayoutManager(context)
        items_recycler_view.setHasFixedSize(true)
        fetchItemAdapter = FetchItemAdapter()
        items_recycler_view.adapter = fetchItemAdapter
    }

    private fun filterList() {
        Log.d(TAG, "filterList function")
        itemViewModel.getItemList().observe(viewLifecycleOwner, Observer {
            var itemArrayList = ArrayList<ItemModel>()
            it.forEach {
                if (!it.getItemName().isNullOrEmpty()) {
                    itemArrayList.add(it)
                }
            }

            itemArrayList = sortList(itemArrayList)
            itemArrayList.forEach {
                Log.d(TAG, it.getItemName())
            }
            fetchItemAdapter.submitList(itemArrayList)
        })
    }

    private fun sortList(itemList: ArrayList<ItemModel>): ArrayList<ItemModel> {
        val sortedList = itemList.sortedWith(compareBy({it.getItemListId()}, {it.getItemId()}))
        return ArrayList(sortedList)
    }
}