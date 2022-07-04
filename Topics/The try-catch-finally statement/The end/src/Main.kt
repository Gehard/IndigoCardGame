fun solution() {
    val a = readln().toInt()
    val b = readln().toInt()
    try {
        println(a / b)
    }
    catch (e: Exception) {
        println(e.message)
    }
    finally {
        // code is always executed
        println("This is the end, my friend.")
    }
}