package by.vfedorenko.makemepotion.presentation.assemblies

import android.app.Activity
import by.vfedorenko.makemepotion.presentation.ingredients.activities.IngredientActivity
import by.vfedorenko.makemepotion.presentation.ingredients.activities.IngredientsActivity
import by.vfedorenko.makemepotion.presentation.ingredients.assemblies.IngredientSubcomponent
import by.vfedorenko.makemepotion.presentation.ingredients.assemblies.IngredientsSubcomponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 30.03.17.
 */
@Module(subcomponents = arrayOf(
        IngredientsSubcomponent::class,
        IngredientSubcomponent::class
))
abstract class ActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(IngredientsActivity::class)
    abstract fun bindIngredientsActivityInjectorFactory(builder: IngredientsSubcomponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(IngredientActivity::class)
    abstract fun bindIngredientActivityInjectorFactory(builder: IngredientSubcomponent.Builder): AndroidInjector.Factory<out Activity>
}
