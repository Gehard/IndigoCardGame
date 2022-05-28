fun main() {
    val text = readLine()!!
    println(if ("the" in text.lowercase()) text.lowercase().indexOf("the") else -1)
}