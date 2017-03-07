package by.vfedorenko.makemepotion.businesslogic

import by.vfedorenko.makemepotion.entities.plain.Effect
import by.vfedorenko.makemepotion.entities.plain.Ingredient
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Test
import kotlin.test.assertEquals


class AlchemistTest {
    private val sameEffect = Effect(name = "same effect", isKnown = false)
    private val sameEffect2 = Effect(name = "same effect 2", isKnown = false)

    private val successData: List<Ingredient>

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

        val effects1 = listOf(eff1, sameEffect, eff2)
        val effects2 = listOf(eff3, sameEffect, sameEffect2)
        val effects3 = listOf(eff5, eff6, eff7)
        val effects4 = listOf(eff4, sameEffect, sameEffect2)
        val effects5 = listOf(sameEffect2, eff8, eff9)

        val ingr1 = Ingredient(name = "ingr1", effects = effects1)
        val ingr2 = Ingredient(name = "ingr2", effects = effects2)
        val ingr3 = Ingredient(name = "ingr3", effects = effects3)
        val ingr4 = Ingredient(name = "ingr4", effects = effects4)
        val ingr5 = Ingredient(name = "ingr5", effects = effects5)

        successData = listOf(ingr1, ingr2, ingr3, ingr4, ingr5)
    }

    @Test
    fun successPotion() {
        val testPotion = alchemist.beginExperiment(successData)

        assertNotNull(testPotion)

        if (testPotion != null) {
            assertEquals(testPotion.points, 12)

            assertEquals(testPotion.effects.size, 2)
            assertEquals(testPotion.ingredients.size, 2)

            Assert.assertTrue(testPotion.effects.contains(sameEffect))
            Assert.assertTrue(testPotion.effects.contains(sameEffect2))
        }
    }
}
