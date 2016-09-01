package by.vfedorenko.makemepotion.businesslogic

import by.vfedorenko.makemepotion.entities.Ingredient
import by.vfedorenko.makemepotion.entities.IngredientEffect
import by.vfedorenko.makemepotion.entities.Potion

/**
 * Created by Vlad Fedorenko on 31.08.16.
 */
class Alchemist {

//    fun makePotion(ingredients: List<Ingredient>): Potion {
//
//
//        return Potion()
//    }
//
//    private fun tryToUseUnknownOnly(ingredients: List<Ingredient>): Potion {
//        var unknownEffects = ingredients
//                .flatMap { it.effects }
//                .filter { !it.isKnown }
//
//        return Potion()
//    }

    fun beginExperiment(ingredients: List<Ingredient>): Potion? {
        var isSuccessful = false
        val results: MutableList<Potion> = mutableListOf()

        ingredients.forEach { item ->
            val itemEffects = item.effects

            val result = Potion()
            result.ingredients.add(item)

            var shouldAddResult = false
            ingredients.forEach inner@ { testItem ->
                if (item != testItem) {
                    if (!result.canAddIngredient()) {
                        return@inner
                    }

                    testItem.effects.forEach { effect ->
                        val itemEffect = getEqual(itemEffects, effect)
                        if (itemEffect != null) {
                            shouldAddResult = true
                            result.addEffect(itemEffect)
                            result.addEffect(effect)
                        }
                    }

                    if (shouldAddResult) {
                        result.ingredients.add(testItem)
                    }
                }
            }

            if (shouldAddResult) {
                results.add(result)
                isSuccessful = true
            }
        }

        var potion: Potion? = null
        if (isSuccessful) {
            potion = findBestResult(results)
        }

        return potion
    }

    private fun getEqual(list: List<IngredientEffect>, item: IngredientEffect): IngredientEffect? {
        val effects = list.toMutableList()

        effects.filter { it.effect.name == item.effect.name }
                .filter { !it.isKnown }

        if (effects.size > 0) {
            return effects[0]
        }

        return null
    }

    private fun findBestResult(results: List<Potion>): Potion? {
        return results.maxBy { it.points }
    }
}
