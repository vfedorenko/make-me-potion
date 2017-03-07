package by.vfedorenko.makemepotion.businesslogic

import by.vfedorenko.makemepotion.entities.plain.Effect
import by.vfedorenko.makemepotion.entities.plain.Ingredient
import by.vfedorenko.makemepotion.entities.plain.Potion
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test


class AlchemistTest {
    private val sameEffect = Effect(name = "same effect", isKnown = false)

    private val successData: List<Ingredient>
    private val expectedPotion: Potion

    private val alchemist = Alchemist()

    init {
        val eff1 = Effect(name = "eff1", isKnown = false)
        val eff2 = Effect(name = "eff2", isKnown = false)
        val eff3 = Effect(name = "eff3", isKnown = false)
        val eff4 = Effect(name = "eff4", isKnown = false)
        val eff5 = Effect(name = "eff5", isKnown = false)
        val eff6 = Effect(name = "eff6", isKnown = false)
        val eff7 = Effect(name = "eff7", isKnown = false)

        val effects1 = listOf(eff1, sameEffect, eff2)
        val effects2 = listOf(eff3, sameEffect, eff4)
        val effects3 = listOf(eff5, eff6, eff7)

        val ingr1 = Ingredient(name = "ingr1", effects = effects1)
        val ingr2 = Ingredient(name = "ingr2", effects = effects2)
        val ingr3 = Ingredient(name = "ingr3", effects = effects3)

        successData = listOf(ingr1, ingr2, ingr3)

        expectedPotion = Potion()
        expectedPotion.effects.add(eff2)
        expectedPotion.ingredients.add(ingr1)
        expectedPotion.ingredients.add(ingr2)
    }

    @Test
    fun getEqual_isCorrect() {
        val testPotion = alchemist.beginExperiment(successData)

        assertNotNull(testPotion)

        if (testPotion != null) {
            assertTrue(testPotion.effects.size == 2)
            assertTrue(testPotion.effects.get(0) == sameEffect)
            assertTrue(testPotion.ingredients.size == 2)
        }
    }
}
