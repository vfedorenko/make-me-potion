package by.vfedorenko.makemepotion.entities.realm

import by.vfedorenko.makemepotion.businesslogic.data.Plainable
import by.vfedorenko.makemepotion.entities.plain.Ingredient
import by.vfedorenko.makemepotion.presentation.App
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
open class RealmIngredient(
        @PrimaryKey
        open var name: String = App.EMPTY_STRING,
        open var effects: RealmList<RealmIngredientEffect> = RealmList()
) : RealmObject(), Plainable<Ingredient> {

    override fun toPlainObject() = Ingredient(name, effects.map { it.toPlainObject() })

    override fun equals(other: Any?): Boolean {
        if (other is RealmIngredient) {
            return name == other.name
        }
        return false
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
