package by.vfedorenko.makemepotion.businesslogic.data

import by.vfedorenko.makemepotion.entities.plain.Effect
import by.vfedorenko.makemepotion.entities.plain.Ingredient

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 06.03.17.
 */
interface IngredientsRepository {
    fun parseRawData(rawList: List<String>)

    fun getIngredients(): List<Ingredient>
    fun getIngredient(name: String): Ingredient
    fun setIngredientChecked(ingredient: Ingredient, isChecked: Boolean)
    fun setIngredientEffectKnown(ingredient: Ingredient, effect: Effect, isKnown: Boolean)
}
