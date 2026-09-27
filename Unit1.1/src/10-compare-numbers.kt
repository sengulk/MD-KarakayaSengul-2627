fun main() {
    println(compare(300, 250))
    println(compare(300, 300))
    println(compare(200, 220))
}

fun compare(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
    return timeSpentToday > timeSpentYesterday
}