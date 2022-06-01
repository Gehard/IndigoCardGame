fun main() {
    val studentsMarks: MutableMap<String, Int> = mutableMapOf()
    while (true) {
        val name = readLine()!!
        if (name == "stop") break

        val score = readLine()!!.toInt()
        if (studentsMarks.contains(name)) continue

        studentsMarks[name] = score
    }
    println(studentsMarks)
}
