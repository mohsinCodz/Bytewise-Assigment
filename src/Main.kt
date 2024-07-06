fun main() {
    val oldUrl = "play.kotlin.org/?id={id}/program={program}/device={device}"
    println("Here's the old url: $oldUrl")
    val id = 9
    val program = "android_dev"
    val device = "ios"
    val currentUrl = oldUrl.buildUrl(id.toString(), program, device)
    println("\nHere's the Current url: $currentUrl")
}

fun String.buildUrl(vararg placeholders: String): String {
    var formattedUrl = this
    placeholders.forEachIndexed { index, value ->
        formattedUrl = formattedUrl.replace("{${placeholders[index]}}", value)
    }
    return formattedUrl
}