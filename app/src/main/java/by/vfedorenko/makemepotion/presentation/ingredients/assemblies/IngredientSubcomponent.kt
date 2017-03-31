package by.vfedorenko.makemepotion.presentation.ingredients.assemblies

import by.vfedorenko.makemepotion.presentation.ingredients.activities.IngredientActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.31.2016
 */
@Subcomponent
interface IngredientSubcomponent : AndroidInjector<IngredientActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<IngredientActivity>()
}
