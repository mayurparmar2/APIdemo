package com.demo.example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.example.R
import com.demo.example.model.UserResponse

class DataAdapter(private val context: Context, private val mUsers:  MutableList<UserResponse>, listener: OnUsersItemClick) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    val onUsersItemClick: OnUsersItemClick = listener

    fun interface OnUsersItemClick {
        fun onClick()
    }
    var mUsersFiltered: MutableList<UserResponse> = mUsers
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.data_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = mUsersFiltered.size
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(mUsersFiltered[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mUsers: UserResponse) {
//            itemView.tv_foldername.text = mUsers.mTitle


            itemView.setOnClickListener {
                onUsersItemClick.onClick()
            }

        }
    }

    fun addItem(list: List<UserResponse>) {
        mUsersFiltered.clear()
        mUsersFiltered.addAll(list)
        notifyItemInserted(mUsersFiltered.size - 1)

    }

}