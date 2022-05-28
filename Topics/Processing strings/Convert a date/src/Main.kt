fun main() {
    val date = readLine()!!

    val list = date.split("-")
    println("${list[1]}/${list[2]}/${list[0]}")
}