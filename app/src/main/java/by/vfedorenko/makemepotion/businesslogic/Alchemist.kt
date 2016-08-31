package by.vfedorenko.makemepotion.businesslogic

import by.vfedorenko.makemepotion.entities.Ingredient
import by.vfedorenko.makemepotion.entities.Potion

/**
 * Created by Vlad Fedorenko on 31.08.16.
 */
class Alchemist {

    fun makePotion(ingredients: List<Ingredient>): Potion {


        return Potion()
    }

    private fun tryToUseUnknownOnly(ingredients: List<Ingredient>): Potion {
        var unknownEffects = ingredients
                .flatMap { it.effects }
                .filter { !it.isKnown }

        // TODO

        return Potion()
    }
}
