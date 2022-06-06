enum class Country(val currency: String) {
    Germany("Euro"),
    Mali("CFA franc"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern Caribbean dollar"),
    Kiribati("Australian dollar"),
}

fun main() {
    try {
        val (first, second) = readln().split(' ')
        val firstCountry = Country.valueOf(first)
        val secondCountry = Country.valueOf(second)
        println(if (firstCountry.currency == secondCountry.currency) "true" else "false")
    } catch (e: Throwable) {
        println("false")
    }
}
