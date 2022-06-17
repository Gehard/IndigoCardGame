class Latte(val milk: String, cost: Int, volume: Int) : Coffee(cost, volume) {
    override fun toString() = "${super.toString()}; milk=$milk"
}
