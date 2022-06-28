const val LOWER_BORDER = 0
const val UPPER_BORDER = 50_000_000
data class City(val name: String) {
    var population: Int = LOWER_BORDER
        set(value) {
            field = value.coerceIn(LOWER_BORDER, UPPER_BORDER)
        }
}