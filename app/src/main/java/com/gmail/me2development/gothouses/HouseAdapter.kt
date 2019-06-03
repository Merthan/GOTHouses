package com.gmail.me2development.gothouses

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gmail.me2development.gothouses.databinding.LayoutHouseItemCardviewBinding

class HouseAdapter(private val houses: List<HouseJsonModel>) : RecyclerView.Adapter<HouseAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutHouseItemCardviewBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int = houses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(houses[position])

    inner class ViewHolder(private val binding: LayoutHouseItemCardviewBinding) : RecyclerView.ViewHolder(binding.root) , View.OnClickListener {

        override fun onClick(v: View?) {
            if(v==null)
                return

            with(Intent(v.context,HouseDetailActivity::class.java)){
                //Put values required by Detail Activity
                putExtra(EXTRA_HOUSE_NAME,houses[adapterPosition].name)
                putExtra(EXTRA_HOUSE_REGION,houses[adapterPosition].region)
                putExtra(EXTRA_HOUSE_COAT_OF_ARMS,houses[adapterPosition].coatOfArms)
                v.context.startActivity(this)
            }

        }
        //Very efficient/short way of databinding recyclerview items!
        fun bind(item: HouseJsonModel) {
            binding.house= item
            //Set onlick to view of binding
            binding.root.setOnClickListener(this)
            binding.executePendingBindings()
        }
    }
}