fun main() {
    val n = readLine()!!.toInt()
    var a = 0
    var b = 0
    var c = 0

    repeat(n) {
        val x = readLine()!!.toInt()

        when {
            x > 0 -> {
                a += 1
            }
            x < 0 -> {
                b += 1
            }
            x == 0 -> {
                c += 1
            }
        }
    }

    println("$c $a $b")
}