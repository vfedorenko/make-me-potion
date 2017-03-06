package by.vfedorenko.makemepotion.presentation.ingredients.activities

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.vfedorenko.makemepotion.R
import by.vfedorenko.makemepotion.databinding.ActivityIngredientBinding
import by.vfedorenko.makemepotion.presentation.App
import by.vfedorenko.makemepotion.presentation.BaseToolbarActivity
import by.vfedorenko.makemepotion.presentation.ingredients.viewmodels.IngredientDetailsViewModel
import by.vfedorenko.makemepotion.presentation.ingredients.viewmodels.IngredientViewModel
import javax.inject.Inject
import javax.inject.Named

class IngredientActivity : BaseToolbarActivity() {
    companion object {
        const val EXTRA_INGREDIENT_NAME = "EXTRA_INGREDIENT_NAME"

        fun createIntent(context: Context, ingredientName: String): Intent {
            val intent = Intent(context, IngredientActivity::class.java)
            intent.putExtra(EXTRA_INGREDIENT_NAME, ingredientName)

            return intent
        }
    }

    @Inject
    lateinit var viewModel: IngredientDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).injectMe(this)

        viewModel.setIngredientByName(intent.getStringExtra(EXTRA_INGREDIENT_NAME))

        val binding = DataBindingUtil.setContentView<ActivityIngredientBinding>(this, R.layout.activity_ingredient)
        binding.viewModel = viewModel

        setupToolbar(binding.toolbar, displaySystemTitle = false)
    }
}
