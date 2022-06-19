data class Client(val name: String, val age: Int, val balance: Int)

fun main() {
    val one = Client(readln(), readln().toInt(), readln().toInt())
    val two = Client(readln(), readln().toInt(), readln().toInt())

    println(one.name == two.name && one.age == two.age)
}
