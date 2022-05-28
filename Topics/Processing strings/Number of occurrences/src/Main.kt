fun main() {
    val string = readLine()!!
    val subString = readLine()!!

    val s = string.split(subString)

    println(s.lastIndexOf(s.last()))
}