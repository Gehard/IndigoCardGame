fun main() {
    val productType = readln()
    val price = readln().toInt()
    val product = when (productType) {
        "headphones" -> Headphones(price)
        "smartphone" -> Smartphone(price)
        "tv" -> TV(price)
        "laptop" -> Laptop(price)
        else -> Product(price)
    }

    println(totalPrice(product))
}

fun totalPrice(product: Product): Int {
    return (product.price + product.price * product.productTax).toInt()
}

open class Product(val price: Int, val productTax: Double = 0.0)

class Headphones(price: Int, productTax: Double = 0.11) : Product(price, productTax)

class Smartphone(price: Int, productTax: Double = 0.15) : Product(price, productTax)

class TV(price: Int, productTax: Double = 0.17) : Product(price, productTax)

class Laptop(price: Int, productTax: Double = 0.19) : Product(price, productTax)