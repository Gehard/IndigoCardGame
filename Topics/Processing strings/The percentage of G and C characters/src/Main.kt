const val PERCENTAGE = 100

fun main() {
    val string = readLine()!!.lowercase()

    val i = string.count { it in "cg" }.toDouble() / string.length * PERCENTAGE 
    println(i)
}
