package by.vfedorenko.makemepotion.presentation.ingredients.viewmodels

import android.app.AlertDialog
import android.view.View
import android.widget.Toast
import by.vfedorenko.makemepotion.R
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

        if (potion.points > 0) {
            var msg = v.context.getString(R.string.combine)

            potion.ingredients.forEach { msg += "${it.name}\n" }

            msg += v.context.getString(R.string.to_learn)

            potion.effects.forEach { msg += "\n${it.name} " }

            val builder = AlertDialog.Builder(v.context)

            builder.setTitle(R.string.potion_dialog_title)
                    .setMessage(msg)
                    .setPositiveButton(R.string.done, { _, _ ->
                        potion.ingredients.forEach { ingr ->
                            potion.effects.forEach { effect ->
                                repository.setIngredientEffectKnown(ingr, effect, true)
                            }
                        }

                        refreshData()
                    })
                    .setNegativeButton(R.string.cancel, null)

            builder.create().show()
        } else {
            Toast.makeText(v.context, R.string.no_potion_available, Toast.LENGTH_SHORT).show()
        }
    }
}
