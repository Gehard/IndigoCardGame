fun main() {
    val x = readLine()!!.toInt()
    val y = readLine()!!.toInt()
    val z = readLine()!!.toInt()

    println(x in y..z)
}