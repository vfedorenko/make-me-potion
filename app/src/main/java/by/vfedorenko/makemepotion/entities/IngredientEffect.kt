package by.vfedorenko.makemepotion.entities

import io.realm.RealmObject

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
open class IngredientEffect(
        open var effect: Effect = Effect(),
        open var isKnown: Boolean = false
) : RealmObject()
