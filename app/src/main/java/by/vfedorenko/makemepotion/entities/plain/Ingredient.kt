package by.vfedorenko.makemepotion.entities.plain

import by.vfedorenko.makemepotion.presentation.App

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 06.03.17.
 */
class Ingredient(val name: String = App.EMPTY_STRING,
                 val effects: List<Effect> = listOf(),
                 var isChecked: Boolean = false) {

    override fun equals(other: Any?): Boolean {
        if (other is Ingredient) {
            return name == other.name
        }

        return false
    }
}
