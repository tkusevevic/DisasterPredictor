package hr.ferit.matijavrabelj.corona.common

import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import hr.ferit.matijavrabelj.corona.ui.custom_helpers.SimpleTextWatcher

fun FragmentActivity.showFragment(containerId: Int, fragment: Fragment, shouldAddToBackStack: Boolean = false, tag: String = ""){
    supportFragmentManager.beginTransaction().apply {
        if(shouldAddToBackStack){
            addToBackStack(tag)
        }
    }.replace(containerId, fragment).commitAllowingStateLoss()
}

fun EditText.onTextChange(onTextChange: (String) -> Unit) {
    addTextChangedListener(SimpleTextWatcher{ onTextChange(it) })
}
