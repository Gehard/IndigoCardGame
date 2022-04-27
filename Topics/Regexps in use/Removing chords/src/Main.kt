fun main() {
    val text = readLine()!!
    val cleanText = text.replace(Regex("[AEDGC] |[AED]m "), "")
    println(cleanText)
}