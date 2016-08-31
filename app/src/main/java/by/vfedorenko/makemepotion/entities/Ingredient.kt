package by.vfedorenko.makemepotion.entities

import by.vfedorenko.makemepotion.presentation.App
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
open class Ingredient(
        @PrimaryKey
        open var name: String = App.EMPTY_STRING,
        open var effects: RealmList<IngredientEffect> = RealmList()
) : RealmObject()
