fun helpingTheRobot(purchases: Map<String, Int>, addition: Map<String, Int>): MutableMap<String, Int> {
    val final = purchases.toMutableMap()
    addition.forEach { (k, v) ->
        final.putIfAbsent(k, v)?.also { final[k] = v + it }
    }
    return final
}
