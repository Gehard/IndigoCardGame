fun main() {
    val n = readLine()!!.toInt()
    var max = 0
    repeat(n) {
        val x = readLine()!!.toInt()
        if (x % 4 == 0 && x > max) {
            max = x
        }
    }
    println(max)  
}
