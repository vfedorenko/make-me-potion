package by.vfedorenko.makemepotion.entities

import by.vfedorenko.makemepotion.presentation.App
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
open class Effect(
        @PrimaryKey
        open var name: String = App.EMPTY_STRING
) : RealmObject()
