package by.vfedorenko.makemepotion.presentation

import android.app.Application
import android.support.v7.app.AppCompatActivity
import by.vfedorenko.makemepotion.R
import by.vfedorenko.makemepotion.businesslogic.data.DataModule
import by.vfedorenko.makemepotion.businesslogic.data.RealmIngredientsRepository
import by.vfedorenko.makemepotion.presentation.assemblies.AppModule
import by.vfedorenko.makemepotion.presentation.assemblies.DaggerAppComponent
import by.vfedorenko.makemepotion.presentation.ingredients.activities.IngredientActivity
import by.vfedorenko.makemepotion.presentation.ingredients.activities.IngredientsActivity
import io.realm.Realm
import io.realm.RealmConfiguration
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
class App : Application() {
    companion object {
        const val EMPTY_STRING = ""
    }

    private val appComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .dataModule(DataModule())
                .build()
    }

    private val ingredientsComponent by lazy {
        appComponent.plus()
    }

    var repo: RealmIngredientsRepository = RealmIngredientsRepository()

    override fun onCreate() {
        super.onCreate()

        val realmConfig = RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfig)

        fillRealmIfNeeded()
    }

    fun injectMe(activity: AppCompatActivity) = when(activity) {
        is IngredientsActivity -> ingredientsComponent.inject(activity)
        is IngredientActivity -> ingredientsComponent.inject(activity)
        else -> { /* Do nothing */}
    }

    private fun fillRealmIfNeeded() {
        val realm = Realm.getDefaultInstance()
        if (realm.isEmpty) {
            val inputStream = getResources().openRawResource(R.raw.ingredients)
            val inputReader = InputStreamReader(inputStream)
            val bufferedReader = BufferedReader(inputReader)

            val rawData: MutableList<String> = mutableListOf()
            var line: String? = bufferedReader.readLine()
            while (line != null) {
                rawData.add(line)
                line = bufferedReader.readLine()
            }

            repo.parseRawData(rawData)
        }
    }
}
