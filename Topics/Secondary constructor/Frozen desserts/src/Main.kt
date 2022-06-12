private const val TWO = 2

private const val FIVE = 5

private const val SEVEN = 7

@SuppressWarnings("all")
class IceCreamOrder {
    val price: Int

    constructor(popsicles: Int) {
        price = SEVEN * popsicles
    }

    constructor(scoops: Int, toppings: Int) {
        price = FIVE * scoops + TWO * toppings
    }
}