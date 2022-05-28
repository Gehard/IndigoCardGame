fun main() {
    val input = readln()
    val word = input.split(" ")[0]
    val n = input.split(" ")[1].toInt()

    if (n > word.length){
        println(word)
    } else {
        println(word.drop(n)+word.substring(0, n))
    }
}