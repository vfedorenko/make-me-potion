package by.vfedorenko.makemepotion.businesslogic

import by.vfedorenko.makemepotion.entities.plain.EffectIngredient
import by.vfedorenko.makemepotion.entities.plain.Ingredient
import by.vfedorenko.makemepotion.entities.plain.Potion

/**
* @author Vlad Fedorenko <vfedo92@gmail.com> on 31.08.16.
*/
class Alchemist {

//    fun makePotion(ingredients: List<RealmIngredient>): Potion {
//
//
//        return Potion()
//    }
//
//    private fun tryToUseUnknownOnly(ingredients: List<RealmIngredient>): Potion {
//        var unknownEffects = ingredients
//                .flatMap { it.effects }
//                .filter { !it.isKnown }
//
//        return Potion()
//    }

    fun beginExperiment(ingredients: List<Ingredient>): Potion? {
        var result = Potion()

        val effectsIngredients: MutableList<EffectIngredient> = mutableListOf()
        ingredients.forEach { ingr ->
            ingr.effects.forEach { effectsIngredients.add(EffectIngredient(it, ingr)) }
        }

        val unknownEffects: List<EffectIngredient> = effectsIngredients
                .filter { !it.effect.isKnown }

        var sameEffects: List<EffectIngredient> = listOf()
        unknownEffects.forEach { other ->
            val partitionResult = unknownEffects.partition { it.effect.name == other.effect.name }

            if (partitionResult.first.size > 1) {
                sameEffects = partitionResult.first
                return@forEach
            }
        }


        if (sameEffects.isNotEmpty()) {
            var lastEffectIndex = 2
            if (sameEffects.size > 2) {
                lastEffectIndex = 3
            }

            sameEffects.subList(0, lastEffectIndex).forEach {
                result.effects.add(it.effect)
                result.ingredients.add(it.ingredient)
            }
        }

//        val results: MutableList<Potion> = mutableListOf()
//
//        ingredients.forEach { item ->
//            val itemEffects = item.effects
//
//            val result = Potion()
//            result.ingredients.add(item)
//
//            var shouldAddResult = false
//            ingredients.forEach inner@ { testItem ->
//                if (item != testItem) {
//                    if (!result.canAddIngredient()) {
//                        return@inner
//                    }
//
//                    testItem.effects.forEach { effect ->
//                        val itemEffect = getEqual(itemEffects, effect)
//                        if (itemEffect != null) {
//                            shouldAddResult = true
//                            result.addEffect(itemEffect)
//                            result.addEffect(effect)
//                        }
//                    }
//
//                    if (shouldAddResult) {
//                        result.ingredients.add(testItem)
//                    }
//                }
//            }
//
//            if (shouldAddResult) {
//                results.add(result)
//                isSuccessful = true
//            }
//        }
//
//        var potion: Potion? = null
//        if (isSuccessful) {
//            potion = findBestResult(results)
//        }

        return result
    }

//    private fun getEqual(list: List<Effect>, item: Effect): Effect? {
//        val effects = list.toMutableList()
//
//        effects.filter { it.name == item.name }
//                .filter { !it.isKnown }
//
//        if (effects.size > 0) {
//            return effects[0]
//        }
//
//        return null
//    }
//
//    private fun findBestResult(results: List<Potion>): Potion? {
//        return results.maxBy { it.points }
//    }
}
