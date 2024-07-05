
fun main() {
    val oldUrl = "play.kotlin.org/?id={id}/program={program}/device={device}"
    println("Here's the old url: $oldUrl")
    val id = 9
    val program = "android_dev"
    val device = "ios"
    val currentUrl = buildUrl(oldUrl, id, program, device)
    println("\nHere's the Current url: $currentUrl")
}

fun buildUrl(oldUrl: String, id: Int, program: String, device: String): String {
    val replacements = mapOf("id" to id.toString(), "program" to program, "device" to device)
    return oldUrl.replace(Regex("""\{(\w+)\}""")) { matchResult ->
        val key = matchResult.groupValues[1]
        replacements[key] ?: ""
    }
}