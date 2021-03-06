package by.vfedorenko.makemepotion.presentation.ingredients.viewmodels

import android.databinding.ObservableBoolean
import android.view.View
import by.vfedorenko.makemepotion.businesslogic.data.IngredientsRepository
import by.vfedorenko.makemepotion.entities.plain.Ingredient
import by.vfedorenko.makemepotion.presentation.ingredients.activities.IngredientActivity
import javax.inject.Inject

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
class IngredientViewModel
@Inject constructor(val repository: IngredientsRepository) {
    var ingredient = Ingredient()
        set(value) {
            field = value
            isChecked.set(value.isChecked)
        }

    var isCheckBoxVisible: Boolean = false
    val isChecked = ObservableBoolean(false)

    fun getName() = ingredient.name

    fun onItemClick(v: View) {
        if (isCheckBoxVisible) {
            ingredient.isChecked = !ingredient.isChecked
            isChecked.set(ingredient.isChecked)
            repository.setIngredientChecked(ingredient, ingredient.isChecked)
        } else {
            v.context.startActivity(IngredientActivity.createIntent(v.context, getName()))
        }
    }
}
