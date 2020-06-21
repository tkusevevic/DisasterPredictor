package hr.ferit.matijavrabelj.corona.ui.activities

import hr.ferit.matijavrabelj.corona.R
import hr.ferit.matijavrabelj.corona.ui.activities.base.BaseActivity
import hr.ferit.matijavrabelj.corona.ui.fragments.CoronaFragment

class MainActivity : BaseActivity() {

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun setUpUi() {
        showFragment(CoronaFragment.newInstance())
    }

}