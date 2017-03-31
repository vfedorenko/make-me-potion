package by.vfedorenko.makemepotion.presentation.ingredients.activities

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import by.vfedorenko.makemepotion.R
import by.vfedorenko.makemepotion.databinding.ActivityIngredientsBinding
import by.vfedorenko.makemepotion.presentation.App
import by.vfedorenko.makemepotion.presentation.BaseToolbarActivity
import by.vfedorenko.makemepotion.presentation.ingredients.viewmodels.IngredientsViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class IngredientsActivity : BaseToolbarActivity() {
    companion object {
        private const val EXTRA_EFFECT_NAME = "EXTRA_EFFECT_NAME"
        private const val EXTRA_IS_MAKE_POTION = "EXTRA_IS_MAKE_POTION"

        fun createIntent(context: Context, effectName: String = App.EMPTY_STRING, isMakePotion: Boolean = false): Intent {
            val intent = Intent(context, IngredientsActivity::class.java)
            intent.putExtra(EXTRA_EFFECT_NAME, effectName)
            intent.putExtra(EXTRA_IS_MAKE_POTION, isMakePotion)

            return intent
        }
    }

    @Inject
    lateinit var viewModel: IngredientsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        viewModel.isMakePotion = intent.getBooleanExtra(EXTRA_IS_MAKE_POTION, false)

        val binding = DataBindingUtil.setContentView<ActivityIngredientsBinding>(this, R.layout.activity_ingredients)
        binding.viewModel = viewModel

        setupToolbar(binding.toolbar, displayUp = true)
    }

    override fun onResume() {
        super.onResume()

        viewModel.refreshData()
    }
}
