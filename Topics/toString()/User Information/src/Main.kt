data class CustomerInfo(
        val uid: String,
        val operationSystem: String,
        val ram: Int,
        val coreSpeed: Double,
        val timeStamp: Long
) {
        override fun toString(): String {
                val longString1 = "Id: $uid; Operation System: $operationSystem; "
                val longString2 = "RAM: $ram; Core Speed: $coreSpeed; Timestamp: $timeStamp"
                return longString1 + longString2
        }
}

fun sendCustomerInfoToServer(customer: CustomerInfo) {
        Server.send(customer.toString())
}