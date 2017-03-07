package by.vfedorenko.makemepotion.entities.realm

import by.vfedorenko.makemepotion.businesslogic.data.Plainable
import by.vfedorenko.makemepotion.entities.plain.Effect
import io.realm.RealmObject

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
open class RealmIngredientEffect(
        open var effect: RealmEffect = RealmEffect(),
        open var isKnown: Boolean = false
) : RealmObject(), Plainable<Effect> {
    override fun toPlainObject() = Effect(name = effect.name, isKnown = isKnown)
}
