package by.vfedorenko.makemepotion.entities

/**
 * Created by Vlad Fedorenko on 31.08.16.
 */
data class Potion(
        var points: Int = 0,
        val ingredients: MutableList<Ingredient> = mutableListOf(),
        val effects: MutableList<IngredientEffect> = mutableListOf()) {

    fun canAddIngredient(): Boolean {
        return ingredients.size < 3
    }

    fun addEffect(effect: IngredientEffect) {
        if (!effect.isKnown) {
            points += 2
        }

        effects.add(effect)
    }
}
