package com.gmail.me2development.gothouses
import com.google.gson.annotations.SerializedName


const val EXTRA_HOUSE_NAME="name"
const val EXTRA_HOUSE_REGION="region"
const val EXTRA_HOUSE_COAT_OF_ARMS="coatOfArms"

data class HouseJsonModel(
    @SerializedName("ancestralWeapons")
    val ancestralWeapons: List<String>,
    @SerializedName("cadetBranches")
    val cadetBranches: List<Any>,
    @SerializedName("coatOfArms")
    val coatOfArms: String,
    @SerializedName("currentLord")
    val currentLord: String,
    @SerializedName("diedOut")
    val diedOut: String,
    @SerializedName("founded")
    val founded: String,
    @SerializedName("founder")
    val founder: String,
    @SerializedName("heir")
    val heir: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("overlord")
    val overlord: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("seats")
    val seats: List<String>,
    @SerializedName("swornMembers")
    val swornMembers: List<String>,
    @SerializedName("titles")
    val titles: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("words")
    val words: String
)