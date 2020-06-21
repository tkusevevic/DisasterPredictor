package hr.ferit.matijavrabelj.corona.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import hr.ferit.matijavrabelj.corona.R
import hr.ferit.matijavrabelj.corona.common.*
import kotlinx.android.synthetic.main.fragment_global.*
import java.text.NumberFormat

class GlobalDialog : DialogFragment() {

    companion object {
        fun newInstance(n1: String, n2: String, n3: String, n4: String, n5: String): GlobalDialog {
            val bundle = Bundle().apply {
                putString(EXTRA_NEW_CONFIRMED, n1)
                putString(EXTRA_TOTAL_CONFIRMED, n2)
                putString(EXTRA_NEW_DEATHS, n3)
                putString(EXTRA_NEW_RECOVERED, n4)
                putString(EXTRA_TOTAL_RECOVERED, n5)
            }
            return GlobalDialog().apply { arguments = bundle }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.FragmentDialogTheme)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_global, container)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        arguments?.getString(EXTRA_NEW_CONFIRMED)?.let {
            newConfirmedField.text = NumberFormat.getInstance().format(it.toInt());
        }
        arguments?.getString(EXTRA_TOTAL_CONFIRMED)?.let {
            totalConfirmedField.text = NumberFormat.getInstance().format(it.toInt());
        }
        arguments?.getString(EXTRA_NEW_DEATHS)?.let {
            newDeathsField.text = NumberFormat.getInstance().format(it.toInt());
        }
        arguments?.getString(EXTRA_NEW_RECOVERED)?.let {
            newRecoveredField.text = NumberFormat.getInstance().format(it.toInt());
        }
        arguments?.getString(EXTRA_TOTAL_RECOVERED)?.let {
            totalRecoveredField.text = NumberFormat.getInstance().format(it.toInt());
        }

    }

    private fun initListeners() = closeDialog.setOnClickListener { closeDialog() }

    private fun closeDialog() {
        dismiss()
    }
}