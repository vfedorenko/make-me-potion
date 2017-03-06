package by.vfedorenko.makemepotion.entities.realm

import by.vfedorenko.makemepotion.presentation.App
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
open class RealmEffect(
        @PrimaryKey
        open var name: String = App.EMPTY_STRING
) : RealmObject()
