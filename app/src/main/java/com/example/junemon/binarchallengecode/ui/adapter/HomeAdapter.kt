package com.example.junemon.binarchallengecode.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.junemon.binarchallengecode.R
import com.example.junemon.binarchallengecode.model.AndroidType
import com.example.junemon.binarchallengecode.utils.inflates
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_home.*

class HomeAdapter(var allData: List<AndroidType>, var listener: (AndroidType) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(parent.inflates(R.layout.item_home))
    }

    override fun getItemCount(): Int = allData.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindView(allData.get(position), listener)
    }

    class HomeViewHolder(override var containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindView(data: AndroidType, listener: (AndroidType) -> Unit) {
            tvAndroidName.text = data.codeName
            tvAndroidVersion.text = data.version
            tvAndroidLevel.text = data.apiLevel
            itemView.setOnClickListener { listener(data) }
        }
    }
}