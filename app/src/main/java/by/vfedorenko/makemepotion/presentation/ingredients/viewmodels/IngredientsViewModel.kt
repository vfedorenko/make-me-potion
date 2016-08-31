package by.vfedorenko.makemepotion.presentation.ingredients.viewmodels

import android.view.View
import by.vfedorenko.makemepotion.businesslogic.IngredientsRepository
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
}