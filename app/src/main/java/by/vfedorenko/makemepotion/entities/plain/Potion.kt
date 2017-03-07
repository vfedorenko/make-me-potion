package by.vfedorenko.makemepotion.entities.plain

/**
* @author Vlad Fedorenko <vfedo92@gmail.com> on 31.08.16.
*/
data class Potion(
        var points: Int = 0,
        val ingredients: MutableSet<Ingredient> = mutableSetOf(),
        val effects: MutableList<Effect> = mutableListOf())
