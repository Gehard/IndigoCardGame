fun main() {
    val rooms = readLine()!!.toInt()
    val price = readLine()!!.toInt()
    val house = House.build(rooms, price)
    println(house.totalPrice)

}

abstract class House protected constructor(private val rooms: Int, price: Int) {
    private val price: Int = price.coerceIn(PRICE_LOWER_BOUND, PRICE_UPPER_BOUND)

    abstract val coefficient: Double

    companion object {
        private const val PRICE_LOWER_BOUND = 0
        private const val PRICE_UPPER_BOUND = 1_000_000

        @SuppressWarnings("All")
        fun build(rooms: Int, price: Int) = when {
            rooms <= 1 -> Cabin(rooms, price)
            rooms in 2..3 -> Bungalow(rooms, price)
            rooms == 4 -> Cottage(rooms, price)
            rooms in 5..7 -> Mansion(rooms, price)
            else -> Palace(rooms, price)
        }
    }

    val totalPrice
        get() = (price * coefficient).toInt()
}

class Bungalow(rooms: Int, price: Int) : House(rooms, price) {
    override val coefficient: Double
        get() = BUNGALOW_COEFFICIENT

    companion object {
        private const val BUNGALOW_COEFFICIENT = 1.2
    }
}

class Cabin(rooms: Int, price: Int) : House(rooms, price) {
    override val coefficient: Double
        get() = CABIN_COEFFICIENT

    companion object {
        private const val CABIN_COEFFICIENT = 1.0
    }
}

class Cottage(rooms: Int, price: Int) : House(rooms, price) {
    override val coefficient: Double
        get() = COTTAGE_COEFFICIENT

    companion object {
        private const val COTTAGE_COEFFICIENT = 1.25
    }
}

class Mansion(rooms: Int, price: Int) : House(rooms, price) {
    override val coefficient: Double
        get() = MANSION_COEFFICIENT

    companion object {
        private const val MANSION_COEFFICIENT = 1.4
    }
}

class Palace(rooms: Int, price: Int) : House(rooms, price) {
    override val coefficient: Double
        get() = PALACE_COEFFICIENT

    companion object {
        private const val PALACE_COEFFICIENT = 1.6
    }
}