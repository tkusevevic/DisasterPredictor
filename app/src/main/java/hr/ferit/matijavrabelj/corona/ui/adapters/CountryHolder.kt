package hr.ferit.matijavrabelj.corona.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.matijavrabelj.corona.model.Country
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_country.view.*

class CountryHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindData(country: Country, onItemSelected: (Country) -> Unit) {
        containerView.setOnClickListener { onItemSelected(country) }

        containerView.country_name.text = country.country

    }
}