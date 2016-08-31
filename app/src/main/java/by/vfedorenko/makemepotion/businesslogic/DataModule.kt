package by.vfedorenko.makemepotion.businesslogic

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.31.2016
 */
@Module
class DataModule {
    @Singleton
    @Provides
    fun provideRepository() = IngredientsRepository()
}