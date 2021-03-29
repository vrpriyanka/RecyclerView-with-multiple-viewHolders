package com.ragini.myapplication.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ragini.myapplication.R
import com.ragini.myapplication.model.Component
import com.ragini.myapplication.model.FeedItem

class ComponentAdapter(private val context: Context, var list: List<FeedItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private inner class BigTopViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var message: TextView = itemView.findViewById(R.id.bigtop_component_textView)
        fun bind(position: Int) {
            message.text = list[position].headline
        }
    }

    private inner class AdViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var message: TextView = itemView.findViewById(R.id.ad_component_textView)
        fun bind(position: Int) {
            message.text = list[position].headline
        }
    }

    private inner class HouseAdViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var message: TextView = itemView.findViewById(R.id.house_ad_component_textView)
        fun bind(position: Int) {
            message.text = list[position].headline
        }
    }

    private inner class RiverViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var message: TextView = itemView.findViewById(R.id.river_component_textView)
        fun bind(position: Int) {
            message.text = list[position].headline
        }
    }

    private inner class SlideShowViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var message: TextView = itemView.findViewById(R.id.slide_show_component_textView)
        fun bind(position: Int) {
            message.text = list[position].headline
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            Component.BIG_TOP.ordinal -> {
                return BigTopViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.bigtop_component, parent, false)
                )
            }
            Component.AD.ordinal -> {
                return AdViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.ad_component, parent, false)
                )
            }
            Component.HOUSE_AD.ordinal -> {
                return HouseAdViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.house_ad_component, parent, false)
                )
            }
            Component.RIVER.ordinal -> {
                return RiverViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.river_component, parent, false)
                )
            }
            else -> return SlideShowViewHolder(
                LayoutInflater.from(context).inflate(R.layout.slide_show_component, parent, false)
            )
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when {
            list[position].component === Component.BIG_TOP -> {
                (holder as BigTopViewHolder).bind(position)
            }
            list[position].component === Component.AD -> {
                (holder as AdViewHolder).bind(position)
            }
            list[position].component === Component.HOUSE_AD -> {
                (holder as HouseAdViewHolder).bind(position)
            }
            list[position].component === Component.RIVER -> {
                (holder as RiverViewHolder).bind(position)
            }
            else -> {
                (holder as SlideShowViewHolder).bind(position)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].component.ordinal
    }
}