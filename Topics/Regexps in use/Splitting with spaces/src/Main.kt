fun main() {
    val string = readln()
    val n = readln().toInt()

    val result = string.split("\\s+".toRegex(), limit = n)
    for (i in result) println(i)
}