fun main() {
    val n = readLine()!!.toInt()
    var a = 0
    var b = 0
    var c = 0
    var d = 0
    repeat(n) {
        val grade = readLine()!!.toInt()
        if (grade == 2) {
            d += 1
        } else if (grade == 3) {
            c += 1
        } else if (grade == 4) {
            b += 1
        } else if (grade == 5) {
            a += 1
        }    
    }
    println("$d $c $b $a")
}
