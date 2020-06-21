package hr.ferit.matijavrabelj.corona.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import hr.ferit.matijavrabelj.corona.R
import hr.ferit.matijavrabelj.corona.model.Country

class CountryAdapter(private val onItemSelected: (Country) -> Unit) : Adapter<CountryHolder>() {

    private val data: MutableList<Country> = mutableListOf()
    private val allData: MutableList<Country> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryHolder(v)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.bindData(data[position], onItemSelected)
    }

    fun setData(data: MutableList<Country>, isFirstTime: Boolean = false) {
        this.data.addAll(data)
        if (isFirstTime) {
            allData.addAll(data)
        }
        notifyDataSetChanged()
    }

    private fun clearData() {
        this.data.clear()
    }

    fun searchCountry(search: String) {
        this.clearData()
        this.setData((allData.filter { it.country.toLowerCase().contains(search.toLowerCase()) }).toMutableList())
    }

    fun setAllCountries() {
        this.clearData()
        this.setData(allData)
    }
}





