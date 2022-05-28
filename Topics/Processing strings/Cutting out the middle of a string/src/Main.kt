fun main() {
    val string = readLine()!!

    if (string.length % 2 == 0) {
        val s = string.length / 2
        println(string.removeRange(s - 1, s + 1))
    } else {
        val s = string.length / 2
        println(string.removeRange(s, s + 1))
    }
}