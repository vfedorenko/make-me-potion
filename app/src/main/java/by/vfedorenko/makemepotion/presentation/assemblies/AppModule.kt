package by.vfedorenko.makemepotion.presentation.assemblies

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.31.2016
 */
@Module
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideContext() = context
}