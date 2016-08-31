package by.vfedorenko.makemepotion.presentation.ingredients.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.vfedorenko.makemepotion.BR
import by.vfedorenko.makemepotion.R
import by.vfedorenko.makemepotion.databinding.ItemIngredientBinding
import by.vfedorenko.makemepotion.entities.Ingredient
import by.vfedorenko.makemepotion.presentation.ingredients.viewmodels.IngredientViewModel

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
class IngredientsAdapter  : RecyclerView.Adapter<IngredientsAdapter.BindingHolder>() {
    class BindingHolder : RecyclerView.ViewHolder {
        var binding: ItemIngredientBinding
            private set

        constructor(item: View) : super(item) {
            binding = DataBindingUtil.bind(item)
        }
    }

    val benefits: MutableList<Ingredient> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BindingHolder =
            BindingHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_ingredient, parent, false))

    override fun getItemCount(): Int = benefits.size

    override fun onBindViewHolder(holder: BindingHolder?, position: Int) {
        val viewModel = IngredientViewModel()
        viewModel.ingredient = benefits[position]

        holder?.binding?.setVariable(BR.viewModel, viewModel)
        holder?.binding?.executePendingBindings()
    }

    fun refreshItems(items: List<Ingredient>) {
        benefits.clear()
        benefits.addAll(items)
        notifyDataSetChanged()
    }
}
