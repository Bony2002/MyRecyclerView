package com.example.myrecyclerview.adapters

import android.content.Context
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.R
import com.example.myrecyclerview.entities.Routine
import kotlinx.android.synthetic.main.row.view.*
import org.w3c.dom.Text

class RoutinesListAdapter (private var routinesList: MutableList<Routine>,val adapterOnClick : () -> Unit) : RecyclerView.Adapter<RoutinesListAdapter.RoutineHolder>() {

    companion object {

        private val TAG = "MascotaListAdapter"
    }

    class RoutineHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View

        init {
            this.view = v
        }

        fun bindItems(model: Routine) {
            val txt: TextView = view.findViewById(R.id.txt_name_item)
            txt.text = model.name
            // itemView.imageIv.setImageResource(model.image)
        }

        fun getCardLayout(): CardView {
            return view.findViewById(R.id.card_package_item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return (RoutineHolder(view))
    }

    override fun getItemCount(): Int {
        return routinesList.size
    }

    fun setData(newData: ArrayList<Routine>) {
        this.routinesList = newData
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RoutineHolder, position: Int) {
        holder.bindItems(routinesList[position])
        holder.getCardLayout().setOnClickListener {
            adapterOnClick()
        }


    }
}



