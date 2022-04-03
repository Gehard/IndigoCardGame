class Application(private val name: String) {

    fun run(arg1: String, arg2: String, arg3: String) {
        for (str in listOf(name, arg1, arg2, arg3)) {
            println(str)
        }
    }
}