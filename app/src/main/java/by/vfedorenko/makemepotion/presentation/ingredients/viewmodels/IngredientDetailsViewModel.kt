package by.vfedorenko.makemepotion.presentation.ingredients.viewmodels

import android.graphics.Color
import android.view.View
import by.vfedorenko.makemepotion.R
import by.vfedorenko.makemepotion.businesslogic.IngredientsRepository
import by.vfedorenko.makemepotion.entities.Ingredient
import by.vfedorenko.makemepotion.presentation.App
import javax.inject.Inject

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
class IngredientDetailsViewModel
@Inject constructor(val repository: IngredientsRepository){
    var ingredient = Ingredient()

    fun setIngredientByName(name: String) {
        ingredient = repository.getIngredient(name)
    }

    fun getName() = ingredient.name

    fun getEffectName(id: Int): String = when(id) {
        R.id.effect1 -> ingredient.effects[0].effect.name
        R.id.effect2 -> ingredient.effects[1].effect.name
        R.id.effect3 -> ingredient.effects[2].effect.name
        R.id.effect4 -> ingredient.effects[3].effect.name
        else -> App.EMPTY_STRING
    }

    fun isEffect1Known(): Boolean = ingredient.effects[0].isKnown

    fun isEffectKnown(id: Int): Boolean = when(id) {
        R.id.effect1 -> ingredient.effects[0].isKnown
        R.id.effect2 -> ingredient.effects[1].isKnown
        R.id.effect3 -> ingredient.effects[2].isKnown
        R.id.effect4 -> ingredient.effects[3].isKnown
        else -> false
    }

    fun onEffectClick(v: View) {
        v.id
    }

    private fun matchColor(isKnown: Boolean): Int {
        if (isKnown) {
            return Color.GREEN
        } else {
            return Color.LTGRAY
        }
    }
}