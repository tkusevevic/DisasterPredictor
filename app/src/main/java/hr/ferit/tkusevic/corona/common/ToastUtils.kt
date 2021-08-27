package hr.ferit.tkusevic.corona.common

import android.content.Context
import android.widget.Toast

fun Context.displayToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()