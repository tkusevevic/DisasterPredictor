package hr.ferit.matijavrabelj.corona.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.matijavrabelj.corona.model.CountryDetails
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_country_details.view.*

class CountryDetailsHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindData(country: CountryDetails) {
        containerView.dateInput.text = country.date.substring(0, 10)
        containerView.confirmedInput.text = country.confirmed.toString()
        containerView.deathInput.text = country.deaths.toString()
        containerView.recoveredInput.text = country.recovered.toString()
        containerView.activeInput.text = country.active.toString()
    }
}