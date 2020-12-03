package com.example.fetchrewards.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        fetchItems = itemViewModel.getFetchItems()
        Log.d(TAG, fetchItems.size.toString())
        initRV()
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
        val filteredList = ArrayList<ItemModel>()

        fetchItems.forEach {
            if (it.getItemName().trim().isNotEmpty()) {
                filteredList.add(it)
            }
        }

        fetchItemAdapter.submitList(filteredList)
    }
}