const val FIVE = 5

class Car(val make: String, val year: Int) {
    var speed: Int = 0
    fun accelerate() {
        speed += FIVE
    }
    fun decelerate() {
        speed -= FIVE
        if (speed < 0) speed = 0
    }
}
