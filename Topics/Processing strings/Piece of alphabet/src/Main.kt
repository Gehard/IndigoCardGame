fun main() {
    val alphabet = readLine()!!

    if (alphabet.isEmpty()) {
        println(alphabet.isEmpty())
    } else if (alphabet.length == 1) {
        println(alphabet.length == 1)
    } else {
        val m = alphabet.toCharArray()
        val n = m.indexOf(m.last())
        println(m.first() + n == m.last())
    }

}