package by.vfedorenko.makemepotion.presentation.ingredients.assemblies

import by.vfedorenko.makemepotion.presentation.ingredients.activities.IngredientActivity
import by.vfedorenko.makemepotion.presentation.ingredients.activities.IngredientsActivity
import dagger.Subcomponent

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.31.2016
 */
@Subcomponent()
interface IngredientsComponent {
    fun inject(activity: IngredientsActivity)
    fun inject(activity: IngredientActivity)
}