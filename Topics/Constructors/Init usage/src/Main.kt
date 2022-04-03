fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer(timerValue)
    println(timer.time)
}

data class ByteTimer(var time: Int) {
    init {
        time = time.coerceIn(Byte.MIN_VALUE.toInt(), Byte.MAX_VALUE.toInt())
    }
}
