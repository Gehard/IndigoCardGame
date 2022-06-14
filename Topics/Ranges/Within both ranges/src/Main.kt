fun main() {
    val a: Int = readLine()!!.toInt()
    val b: Int = readLine()!!.toInt()
    val c: Int = readLine()!!.toInt()
    val d: Int = readLine()!!.toInt()
    val e: Int = readLine()!!.toInt()

    val range1 = a..b
    val range2 = c..d

    println(e in range1 && e in range2)
}