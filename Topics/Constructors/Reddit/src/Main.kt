data class Site(val address: String, val foundationYear: Int)
fun makeReddit(a: String = "reddit.com", b: Int = 2005) = Site(a, b)
