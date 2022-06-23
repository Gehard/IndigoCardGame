enum class Rainbow(val color: String) {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    INDIGO("Indigo"),
    VIOLET("Violet");

    companion object {
        fun isRainbow(name: String): Boolean {
            values().forEach { if (name.uppercase() == it.name) return true }
            return false
        }
    }
}

fun main() {
    println(Rainbow.isRainbow(readln()))
}