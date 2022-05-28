object Math {
    fun abs(a: Int): Int = if (a < 0) -a else a
    fun abs(a: Double): Double = if (a < 0.0) 0.0 - a else a
}