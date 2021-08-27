package hr.ferit.tkusevic.corona.ui.activities

import hr.ferit.tkusevic.corona.R
import hr.ferit.tkusevic.corona.common.EXTRA_SCREEN_TYPE
import hr.ferit.tkusevic.corona.ui.activities.base.BaseActivity


class ContainerActivity : BaseActivity() {

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun setUpUi() {
        //val screenType = intent.getStringExtra(EXTRA_SCREEN_TYPE)
    }

    companion object {}
}

