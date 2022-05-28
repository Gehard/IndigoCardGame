fun main() {
    println(readLine()!!.replace(Regex("(.)\\1*")) { String.format("%s%d", it.groupValues[1], it.value.length) })
}