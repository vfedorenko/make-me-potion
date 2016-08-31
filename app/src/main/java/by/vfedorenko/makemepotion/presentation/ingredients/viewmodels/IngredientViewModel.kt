package by.vfedorenko.makemepotion.presentation.ingredients.viewmodels

import android.view.View
import by.vfedorenko.makemepotion.entities.Ingredient
import by.vfedorenko.makemepotion.presentation.ingredients.activities.IngredientActivity

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
class IngredientViewModel {
    var ingredient = Ingredient()

    fun getName() = ingredient.name

    fun onItemClick(v: View) {
        v.context.startActivity(IngredientActivity.createIntent(v.context, getName()))
    }
}