fun main() {
    val string = readLine()!!

    val stringList = string.split(" ").toMutableList()

    val length = mutableListOf<Int>()

    for (i in stringList) {
        length.add(i.length)
    }

    val x = length.indexOf(length.maxOrNull())

    println(stringList[x])
}