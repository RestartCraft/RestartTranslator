import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.bukkit.Material

object RestartTranslator{

    private val translations = Json.decodeFromString<Map<String,String>>(this::class.java.getResource("ru_ru").readText())

    @JvmName("getRu")
    fun Material.getRu(): String {
        val name = this.name.lowercase()

        return if(this.isBlock) translations["block.minecraft.${name}"] ?: name
        else if(this.isItem) translations["item.minecraft.${name}"] ?: name
        else name
    }

    @JvmName("getRu1")
    fun getRu(material: Material): String = material.getRu()

}