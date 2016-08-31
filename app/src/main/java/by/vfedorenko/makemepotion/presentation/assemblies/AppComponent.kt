package by.vfedorenko.makemepotion.presentation.assemblies

import by.vfedorenko.makemepotion.businesslogic.DataModule
import by.vfedorenko.makemepotion.presentation.ingredients.assemblies.IngredientsComponent
import by.vfedorenko.makemepotion.presentation.ingredients.assemblies.IngredientsModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.31.2016
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class))
interface AppComponent {
    fun plus(module: IngredientsModule): IngredientsComponent
}