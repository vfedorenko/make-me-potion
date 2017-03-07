package by.vfedorenko.makemepotion.businesslogic

import by.vfedorenko.makemepotion.entities.plain.Effect
import by.vfedorenko.makemepotion.entities.plain.Ingredient
import by.vfedorenko.makemepotion.entities.plain.Potion

/**
* @author Vlad Fedorenko <vfedo92@gmail.com> on 31.08.16.
*/
class Alchemist {
    private companion object {
        const val UNKNOWN_EFFECT_POINTS = 5
        const val KNOWN_EFFECT_POINTS = 1
    }

    fun beginExperiment(ingredients: List<Ingredient>): Potion {
        val results: MutableList<Potion> = mutableListOf()

        var tempList = ingredients
        while (tempList.size > 1) {
            val firstIngredient = tempList.get(0)
            tempList = tempList.drop(1)

            tempList.forEach {
                val potion = createPotion(firstIngredient, it)

                if (potion.points > 0) {
                    results.add(potion)
                }
            }
        }

        return findBestResult(results)
    }

    private fun createPotion(ingr1: Ingredient, ingr2: Ingredient): Potion {
        val result = Potion()

        ingr1.effects.forEach { effect1 ->
            val index = ingr2.effects.indexOf(effect1)
            if (index != -1) {
                val effect2 = ingr2.effects[index]

                if (!effect1.isKnown || !effect2.isKnown) {
                    result.effects.add(effect1)
                    result.ingredients.add(ingr1)
                    result.ingredients.add(ingr2)

                    result.points += getPoints(effect1)
                    result.points += getPoints(effect2)
                }
            }
        }

        return result
    }

    private fun findBestResult(results: List<Potion>): Potion {
        return results.maxBy { it.points } ?: Potion()
    }

    private fun getPoints(effect: Effect): Int {
        return if (effect.isKnown) KNOWN_EFFECT_POINTS else UNKNOWN_EFFECT_POINTS
    }
}
