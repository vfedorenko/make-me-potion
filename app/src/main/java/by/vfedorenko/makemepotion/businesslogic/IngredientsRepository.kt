package by.vfedorenko.makemepotion.businesslogic

import by.vfedorenko.makemepotion.entities.Effect
import by.vfedorenko.makemepotion.entities.Ingredient
import by.vfedorenko.makemepotion.entities.IngredientEffect
import io.realm.Realm

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
class IngredientsRepository {
    private val realm by lazy {
        Realm.getDefaultInstance()
    }

    fun parseRawData(rawList: List<String>) {
        realm.executeTransaction {
            rawList.forEach {
                val raw = it.split(";")

                val ingredient = realm.createObject(Ingredient::class.java)
                ingredient.name = raw[0]

                for (i in 1..raw.size - 1) {
                    val effect = Effect()
                    effect.name = (raw[i])

                    val ingredientEffect = realm.createObject(IngredientEffect::class.java)
                    ingredientEffect.effect = realm.copyToRealmOrUpdate(effect)
                    ingredientEffect.isKnown = false

                    ingredient.effects.add(ingredientEffect)
                }
            }
        }
    }

    fun getIngredients(): List<Ingredient> = realm.where(Ingredient::class.java).findAll()

    fun getIngredient(name: String): Ingredient = realm.where(Ingredient::class.java).equalTo("name", name).findFirst()

    fun toggleIngredientChecked(ingredient: Ingredient): Boolean {
        realm.executeTransaction {
            ingredient.isChecked = !ingredient.isChecked
        }

        return ingredient.isChecked
    }
}
