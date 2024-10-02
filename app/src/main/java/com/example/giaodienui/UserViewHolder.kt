package com.example.giaodienui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textViewName: TextView = itemView.findViewById(R.id.textViewName)
    private val textViewEmail: TextView = itemView.findViewById(R.id.textViewEmail)
    private val textViewPhone: TextView = itemView.findViewById(R.id.textViewPhone)
    private val textViewGender: TextView = itemView.findViewById(R.id.textViewGender)

    fun bind(user: User) {
        textViewName.text = user.name
        textViewEmail.text = user.email
        textViewPhone.text = user.phone
        textViewGender.text = user.gender
    }
}
