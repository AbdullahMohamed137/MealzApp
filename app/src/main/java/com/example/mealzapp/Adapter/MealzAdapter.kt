package com.example.mealzapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealzapp.R
import com.example.mealzapp.domain.model.Category

class MealzAdapter(private val mealsList : List<Category>) : RecyclerView.Adapter<MealzAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealzAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealzAdapter.ViewHolder, position: Int) {
        holder.categoryName.text = mealsList[position].strCategory.toString()
        holder.categoryDes.text = mealsList[position].strCategoryDescription.toString()
        Glide.with(holder.itemView.context).load(mealsList[position].strCategoryThumb).into(holder.categoryImage)
    }

    override fun getItemCount(): Int {
       return mealsList.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val categoryImage : ImageView
        val categoryName : TextView
        val categoryDes : TextView

        init {
            categoryImage = itemView.findViewById(R.id.category_img)
            categoryName  = itemView.findViewById(R.id.category_name_tv)
            categoryDes  = itemView.findViewById(R.id.category_des_tv)
        }
    }
}