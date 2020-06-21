package hr.ferit.matijavrabelj.corona.ui.activities

import hr.ferit.matijavrabelj.corona.R
import hr.ferit.matijavrabelj.corona.common.EXTRA_SCREEN_TYPE
import hr.ferit.matijavrabelj.corona.common.EXTRA_SELECTED_SLUG
import hr.ferit.matijavrabelj.corona.ui.activities.base.BaseActivity
import hr.ferit.matijavrabelj.corona.ui.fragments.CountryDetailsFragment


class ContainerActivity : BaseActivity() {

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun setUpUi() {
        val screenType = intent.getStringExtra(EXTRA_SCREEN_TYPE)
        val id = intent.getStringExtra(EXTRA_SELECTED_SLUG)
        if (screenType.isNotEmpty()) {
            when (screenType) {
                SCREEN_COUNTRY_DETAILS -> showFragment(CountryDetailsFragment.newInstance(id))
            }
        } else {
            finish()
        }
    }

    companion object {
        const val SCREEN_COUNTRY_DETAILS = "country_details"
    }
}

