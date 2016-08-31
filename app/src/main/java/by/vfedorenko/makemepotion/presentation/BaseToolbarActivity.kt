package by.vfedorenko.makemepotion.presentation

import android.R
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem

/**
 * Created by Vlad Fedorenko <vfedo92@gmail.com>
 * 08.31.2016
 */
abstract class BaseToolbarActivity : AppCompatActivity() {
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.home -> {
            finish()
            true
        }
        else -> onOptionsItemSelected(item)
    }

    protected fun setupToolbar(toolbar: Toolbar?, displaySystemTitle: Boolean = true, displayUp: Boolean = true) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(displayUp)
        supportActionBar?.setDisplayShowTitleEnabled(displaySystemTitle)
    }
}
