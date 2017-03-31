package by.vfedorenko.makemepotion.presentation

import android.app.Activity
import android.app.Application
import by.vfedorenko.makemepotion.R
import by.vfedorenko.makemepotion.businesslogic.data.IngredientsRepository
import by.vfedorenko.makemepotion.presentation.assemblies.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasDispatchingActivityInjector
import io.realm.Realm
import io.realm.RealmConfiguration
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
class App : Application(), HasDispatchingActivityInjector {
    companion object {
        const val EMPTY_STRING = ""
    }

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var repo: IngredientsRepository

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        val realmConfig = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfig)

        DaggerAppComponent.create()
                .inject(this)

        fillRealmIfNeeded()
    }

    override fun activityInjector() = dispatchingActivityInjector


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
