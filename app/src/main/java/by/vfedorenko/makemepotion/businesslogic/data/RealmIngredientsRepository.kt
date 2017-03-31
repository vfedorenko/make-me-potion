package by.vfedorenko.makemepotion.businesslogic.data

import by.vfedorenko.makemepotion.entities.plain.Effect
import by.vfedorenko.makemepotion.entities.plain.Ingredient
import by.vfedorenko.makemepotion.entities.realm.RealmEffect
import by.vfedorenko.makemepotion.entities.realm.RealmIngredient
import by.vfedorenko.makemepotion.entities.realm.RealmIngredientEffect
import io.realm.Realm

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
class RealmIngredientsRepository : IngredientsRepository {

    private val realm by lazy {
        Realm.getDefaultInstance()
    }

    override fun parseRawData(rawList: List<String>) {
        realm.executeTransaction {
            rawList.forEach {
                val raw = it.split(";")

                val ingredient = realm.createObject(RealmIngredient::class.java, raw[0])

                for (i in 1..raw.size - 1) {
                    var effect: RealmEffect? = realm.where(RealmEffect::class.java).equalTo("name", raw[i]).findFirst()
                    if (effect == null) {
                        effect = realm.createObject(RealmEffect::class.java, raw[i])
                    }

                    val ingredientEffect = RealmIngredientEffect()
                    ingredientEffect.effect = effect!!
                    ingredientEffect.isKnown = false

                    ingredient.effects.add(realm.copyToRealm(ingredientEffect))
                }
            }
        }
    }

    override fun getIngredients(): List<Ingredient> = realm.where(RealmIngredient::class.java).findAll().map { it.toPlainObject() }

    override fun getIngredient(name: String): Ingredient = realm.where(RealmIngredient::class.java).equalTo("name", name).findFirst().toPlainObject()

    override fun setIngredientChecked(ingredient: Ingredient, isChecked: Boolean) {
        val realmIngredient = realm.where(RealmIngredient::class.java).equalTo("name", ingredient.name).findFirst()

        realm.executeTransaction { realmIngredient.isChecked = isChecked }
    }

    override fun setIngredientEffectKnown(ingredient: Ingredient, effect: Effect, isKnown: Boolean) {
        val realmIngredient = realm.where(RealmIngredient::class.java).equalTo("name", ingredient.name).findFirst()

        realm.executeTransaction {
            realmIngredient.effects
                    .filter { it.effect.name == effect.name }
                    .first()
                    .isKnown = isKnown
        }
    }
}
