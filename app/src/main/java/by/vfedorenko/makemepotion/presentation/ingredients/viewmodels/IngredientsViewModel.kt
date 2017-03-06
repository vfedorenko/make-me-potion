package by.vfedorenko.makemepotion.presentation.ingredients.viewmodels

import android.util.Log
import android.view.View
import by.vfedorenko.makemepotion.businesslogic.Alchemist
import by.vfedorenko.makemepotion.businesslogic.data.IngredientsRepository
import by.vfedorenko.makemepotion.presentation.ingredients.activities.IngredientsActivity
import by.vfedorenko.makemepotion.presentation.ingredients.adapters.IngredientsAdapter
import javax.inject.Inject

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
class IngredientsViewModel
@Inject constructor(val repository: IngredientsRepository) {
    var isMakePotion: Boolean = false

    val adapter: IngredientsAdapter by lazy {
        IngredientsAdapter(isMakePotion)
    }

    fun refreshData() {
        adapter.refreshItems(repository.getIngredients())
    }

    fun onFabClick(v: View) {
        v.context.startActivity(IngredientsActivity.createIntent(v.context, isMakePotion = true))
    }

    fun onMakeClick(v: View) {
        val potion = Alchemist().beginExperiment(adapter.getCheckedItems())
        Log.d("111", "--------------------------------------- potion points = ${potion?.points}")
        potion?.ingredients?.forEach {
            Log.d("111", "ingr: ${it.name}")
        }
        potion?.effects?.forEach {
            Log.d("111", "eff: ${it.name}")
        }
    }
}
