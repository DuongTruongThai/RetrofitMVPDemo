import com.google.gson.annotations.SerializedName



data class Translations (

	@SerializedName("br") val br : String,
	@SerializedName("pt") val pt : String,
	@SerializedName("nl") val nl : String,
	@SerializedName("hr") val hr : String,
	@SerializedName("fa") val fa : String,
	@SerializedName("de") val de : String,
	@SerializedName("es") val es : String,
	@SerializedName("fr") val fr : String,
	@SerializedName("ja") val ja : String,
	@SerializedName("it") val it : String,
	@SerializedName("hu") val hu : String
)