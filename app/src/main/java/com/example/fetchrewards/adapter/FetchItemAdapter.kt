package com.example.fetchrewards.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchrewards.R
import com.example.fetchrewards.remote.ItemModel
import kotlinx.android.synthetic.main.card_view_list_item.view.*

class FetchItemAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TAG = "FetchItemAdapter"

    private var items = ArrayList<ItemModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FetchItemAdapter.ItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_view_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FetchItemAdapter.ItemsViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(fetchItems: ArrayList<ItemModel>) {
        items = fetchItems
        notifyDataSetChanged()
    }

    class ItemsViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val TAG = "ItemsViewHolder"

        val itemIdTV = itemView.item_id_text_view
        val listIdTV = itemView.item_list_id_text_view
        val itemNameTV = itemView.item_name_text_view

        fun bind(itemModel: ItemModel) {
            Log.d(TAG, "Bind function")
            itemNameTV.text = itemModel.getItemName()
            itemIdTV.text = itemModel.getItemId().toString()
            listIdTV.text = itemModel.getItemListId().toString()
        }
    }
}