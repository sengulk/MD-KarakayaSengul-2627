// TASK 2
enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

// TASK 1
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

// TASK 7
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

// TASK 1 - 2 - 3
fun main() {
    val events = mutableListOf(
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
        Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
        Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
        Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
        Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
        Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    )

    // TASK 3
    println("Amount of events: ${events.size}")
    events.add(Event(title = "Sleep", daypart = Daypart.EVENING, durationInMinutes = 480))
    println("Amount of events after add: ${events.size}")

    // TASK 4
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("You have ${shortEvents.size} short events.")

    // TASK 5
    val eventsByDaypart = events.groupBy { it.daypart }
    eventsByDaypart.forEach { daypart, events ->
        println("$daypart: ${events.size} events")
    }

    // TASK 6
    println("Last event of the day: ${events.last().title}")

    // TASK 7
    println("Duration of first event of the day: ${events[0].durationOfEvent}")
}