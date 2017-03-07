package by.vfedorenko.makemepotion.businesslogic

import by.vfedorenko.makemepotion.entities.plain.Effect
import by.vfedorenko.makemepotion.entities.plain.Ingredient
import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals


class AlchemistTest {
    private companion object {
        const val EFFECT_1 = "effect1"
        const val EFFECT_2 = "effect2"

        const val INGREDIENT_1 = "ingredient1"
        const val INGREDIENT_2 = "ingredient2"
        const val INGREDIENT_3 = "ingredient3"
        const val INGREDIENT_4 = "ingredient4"
        const val INGREDIENT_5 = "ingredient5"
        const val INGREDIENT_6 = "ingredient6"
    }

    private val effect1 = Effect(name = EFFECT_1, isKnown = false)
    private val knownEffect1 = Effect(name = EFFECT_1, isKnown = true)
    private val effect2 = Effect(name = EFFECT_2, isKnown = false)

    private val bestChoise: List<Ingredient>
    private val minChoise: List<Ingredient>
    private val noPotion: List<Ingredient>

    private val alchemist = Alchemist()

    init {
        val eff1 = Effect(name = "eff1", isKnown = false)
        val eff2 = Effect(name = "eff2", isKnown = false)
        val eff3 = Effect(name = "eff3", isKnown = false)
        val eff4 = Effect(name = "eff4", isKnown = false)
        val eff5 = Effect(name = "eff5", isKnown = false)
        val eff6 = Effect(name = "eff6", isKnown = false)
        val eff7 = Effect(name = "eff7", isKnown = false)
        val eff8 = Effect(name = "eff8", isKnown = false)
        val eff9 = Effect(name = "eff9", isKnown = false)
        val eff10 = Effect(name = "eff10", isKnown = false)

        val effects1 = listOf(eff1, effect1, eff2)
        val effects2 = listOf(eff3, effect1, effect2)
        val effects3 = listOf(eff5, eff6, knownEffect1)
        val effects4 = listOf(eff4, effect1, effect2)
        val effects5 = listOf(effect2, eff8, eff9)
        val effects6 = listOf(knownEffect1, eff7, eff10)

        val ingr1 = Ingredient(name = INGREDIENT_1, effects = effects1)
        val ingr2 = Ingredient(name = INGREDIENT_2, effects = effects2)
        val ingr3 = Ingredient(name = INGREDIENT_3, effects = effects3)
        val ingr4 = Ingredient(name = INGREDIENT_4, effects = effects4)
        val ingr5 = Ingredient(name = INGREDIENT_5, effects = effects5)
        val ingr6 = Ingredient(name = INGREDIENT_6, effects = effects6)

        bestChoise = listOf(ingr1, ingr2, ingr3, ingr4, ingr5)
        minChoise = listOf(ingr1, ingr3, ingr5)
        noPotion = listOf(ingr3, ingr5, ingr6)
    }

    @Test
    fun bestPotion() {
        val testPotion = alchemist.beginExperiment(bestChoise)

        assertEquals(testPotion.points, 20)

        assertEquals(testPotion.effects.size, 2)
        assertEquals(testPotion.ingredients.size, 2)

        assertEquals(INGREDIENT_2, testPotion.ingredients.toList()[0].name)
        assertEquals(INGREDIENT_4, testPotion.ingredients.toList()[1].name)

        Assert.assertTrue(testPotion.effects.contains(effect1))
        Assert.assertTrue(testPotion.effects.contains(effect2))
    }

    @Test
    fun minPotion() {
        val testPotion = alchemist.beginExperiment(minChoise)

        assertEquals(testPotion.points, 6)

        assertEquals(testPotion.effects.size, 1)
        assertEquals(testPotion.ingredients.size, 2)

        Assert.assertTrue(testPotion.effects.contains(effect1))
    }

    @Test
    fun noPotion() {
        val testPotion = alchemist.beginExperiment(noPotion)

        assertEquals(testPotion.points, 0)

        assertEquals(testPotion.effects.size, 0)
        assertEquals(testPotion.ingredients.size, 0)
    }
}
