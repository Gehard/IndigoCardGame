fun addUser(userMap: Map<String, String>, login: String, password: String): MutableMap<String, String> {
    return if (login in userMap) {
        println("User with this login is already registered!")
        userMap.toMutableMap()
    } else {
        userMap.toMutableMap().apply { put(login, password) }
    }
}