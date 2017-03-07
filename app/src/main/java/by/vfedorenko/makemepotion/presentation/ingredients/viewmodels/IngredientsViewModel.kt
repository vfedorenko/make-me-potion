package by.vfedorenko.makemepotion.presentation.ingredients.viewmodels

import android.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Toast
import by.vfedorenko.makemepotion.businesslogic.Alchemist
import by.vfedorenko.makemepotion.businesslogic.data.IngredientsRepository
import by.vfedorenko.makemepotion.presentation.ingredients.activities.IngredientsActivity
import by.vfedorenko.makemepotion.presentation.ingredients.adapters.IngredientsAdapter
import javax.inject.Inject

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.30.2016
 */
class IngredientsViewModel
@Inject constructor(val repository: IngredientsRepository) {
    var isMakePotion: Boolean = false

    val adapter: IngredientsAdapter by lazy {
        IngredientsAdapter(isMakePotion)
    }

    fun refreshData() {
        adapter.refreshItems(repository.getIngredients())
    }

    fun onFabClick(v: View) {
        v.context.startActivity(IngredientsActivity.createIntent(v.context, isMakePotion = true))
    }

    fun onMakeClick(v: View) {
        val potion = Alchemist().beginExperiment(adapter.getCheckedItems())
        Log.d("111", "--------------------------------------- potion points = ${potion.points}")

        if (potion.points > 0) {
            var msg = "Combine: "

            potion.ingredients.forEach { msg += "${it.name}\n" }

            msg += "\nTo learn:"

            potion.effects.forEach { msg += "\n${it.name} " }

            val builder = AlertDialog.Builder(v.context)

            builder.setTitle("Best choice for you:")
                    .setMessage(msg)
                    .setPositiveButton("Done", { _, _ ->
                        potion.ingredients.forEach { ingr ->
                            potion.effects.forEach { effect ->
                                Log.d("111", "ingr: ${ingr.name} eff: ${effect.name}")
                                repository.setIngredientEffectKnown(ingr, effect, true)
                            }
                        }

                        refreshData()
                    })
                    .setNegativeButton("Cancel", null)

            builder.create().show()
        } else {
            Toast.makeText(v.context, "No potions available", Toast.LENGTH_SHORT).show()
        }
    }
}
