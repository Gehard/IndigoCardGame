const val BASE_PAY = 50
const val BASE_WORKLOAD = 20
const val EXTRA_HOURS_PAY = 2.8

data class Intern(val weeklyWorkload: Int) {
    val baseWorkload = BASE_WORKLOAD

    class Salary {
        val basePay = BASE_PAY
        val extraHoursPay = EXTRA_HOURS_PAY
    }

    val weeklySalary = Salary().let { it.basePay + (weeklyWorkload - baseWorkload) * it.extraHoursPay }
}