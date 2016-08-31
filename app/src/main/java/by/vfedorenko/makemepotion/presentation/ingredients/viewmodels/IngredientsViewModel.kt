package by.vfedorenko.makemepotion.presentation.ingredients.viewmodels

import by.vfedorenko.makemepotion.businesslogic.IngredientsRepository
import by.vfedorenko.makemepotion.presentation.ingredients.adapters.IngredientsAdapter
import javax.inject.Inject

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
class IngredientsViewModel
@Inject constructor(val repository: IngredientsRepository) {
    val adapter: IngredientsAdapter by lazy {
        IngredientsAdapter()
    }

    fun refreshData() {
        adapter.refreshItems(repository.getIngredients())
    }
}