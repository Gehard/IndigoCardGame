fun main() {
    val n = readLine()!!.toInt()
    var a = 0
    repeat(n) {
        val x = readLine()!!.toInt()

        if (x > 0) {
            a += 1
        }
    }

    println(a)
}