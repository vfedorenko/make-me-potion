package by.vfedorenko.makemepotion.presentation.ingredients.assemblies

import by.vfedorenko.makemepotion.businesslogic.IngredientsRepository
import by.vfedorenko.makemepotion.presentation.ingredients.viewmodels.IngredientDetailsViewModel
import by.vfedorenko.makemepotion.presentation.ingredients.viewmodels.IngredientsViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.31.2016
 */
@Module
class IngredientsModule {
    companion object {
        const val INGREDIENTS_VIEW_MODEL = "INGREDIENTS_VIEW_MODEL"
        const val INGREDIENT_DETAILS_VIEW_MODEL = "INGREDIENT_DETAILS_VIEW_MODEL"
    }

    @Provides
    @Named(INGREDIENTS_VIEW_MODEL)
    fun provideIngredientsViewModel(repo: IngredientsRepository) = IngredientsViewModel(repo)

    @Provides
    @Named(INGREDIENT_DETAILS_VIEW_MODEL)
    fun provideIngredientViewModel(repo: IngredientsRepository) = IngredientDetailsViewModel(repo)
}