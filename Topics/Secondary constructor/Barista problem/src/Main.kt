data class EspressoMachine(val costPerServing: Float) {
    companion object {
        private const val WEIGHT_PER_UNIT = 10
    }

    constructor(coffeeCapsulesCount: Int, totalCost: Float) : this(totalCost / coffeeCapsulesCount)

    constructor(coffeeBeansWeight: Float, totalCost: Float) : this(totalCost / coffeeBeansWeight * WEIGHT_PER_UNIT)
}