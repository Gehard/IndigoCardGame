const val ONE = 1
const val FIVE = 5
const val ZERO = 0
fun main() {
    val a = readln().split(" ")
    val b = readln().split(" ")
    val c = readln().split(" ")
        
    for (j in ZERO..ONE) {
        val d = mutableListOf<Int>()
        for (i in ONE..FIVE) {
            if (i == a[j].toInt()) continue
            if (i == b[j].toInt()) continue
            if (i == c[j].toInt()) continue
            d.add(i)
        }
        println(d.joinToString(" "))    
    }  
    
}
