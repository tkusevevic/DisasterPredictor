package hr.ferit.matijavrabelj.corona.model.response

import hr.ferit.matijavrabelj.corona.model.Country
import hr.ferit.matijavrabelj.corona.model.Global

data class GetSummaryResponse(val Countries: MutableList<Country>, val Global: Global)