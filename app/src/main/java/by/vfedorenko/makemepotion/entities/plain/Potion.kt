package by.vfedorenko.makemepotion.entities.plain

/**
* @author Vlad Fedorenko <vfedo92@gmail.com> on 31.08.16.
*/
data class Potion(
        var points: Int = 0,
        val ingredients: MutableList<Ingredient> = mutableListOf(),
        val effects: MutableList<Effect> = mutableListOf()) {

    fun canAddIngredient(): Boolean {
        return ingredients.size < 3
    }

    fun addEffect(effect: Effect) {
        if (!effect.isKnown) {
            points += 2
        }

        effects.add(effect)
    }
}
