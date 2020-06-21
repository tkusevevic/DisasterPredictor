package hr.ferit.matijavrabelj.corona.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import hr.ferit.matijavrabelj.corona.R
import hr.ferit.matijavrabelj.corona.model.CountryDetails

class CountryDetailsAdapter : Adapter<CountryDetailsHolder>() {

    private val data: MutableList<CountryDetails> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryDetailsHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_country_details, parent, false)
        return CountryDetailsHolder(v)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CountryDetailsHolder, position: Int) {
        holder.bindData(data[position])
    }

    fun setData(data: MutableList<CountryDetails>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }
}





