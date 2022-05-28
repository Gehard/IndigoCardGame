fun main() {
    fun sumOfDigits(s: String) = s.map { it.code }.sum()

    val input = readLine()!!
    val (a, b) = input.chunked(input.length / 2)
    println(if (sumOfDigits(a) == sumOfDigits(b)) "Lucky" else "Regular")
}