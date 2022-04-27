fun main() {
    val report = readLine()!!
    val compare = Regex("[0-9] wrong answers?")

    println(compare.matches(report))
}