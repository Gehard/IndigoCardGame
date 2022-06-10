enum class DangerLevel(val levels: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel(): Int {
        return this.levels
    }
}