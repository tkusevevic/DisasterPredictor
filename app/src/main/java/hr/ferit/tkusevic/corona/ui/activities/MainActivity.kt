package hr.ferit.tkusevic.corona.ui.activities

import hr.ferit.tkusevic.corona.R
import hr.ferit.tkusevic.corona.ui.activities.base.BaseActivity
import hr.ferit.tkusevic.corona.ui.fragments.DisasterFragment

class MainActivity : BaseActivity() {

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun setUpUi() {
        showFragment(DisasterFragment.newInstance())
    }

}