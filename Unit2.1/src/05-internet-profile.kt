fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")

        // check of persoon een hobby heeft
        if (hobby != null) {
            print("Likes to $hobby. ")
        }
        // check of er een referrer is
        if (referrer != null) {
            print("Has a referrer named ${referrer.name}")

            // check of de referrer een hobby heeft
            if (referrer.hobby != null) {
                print(", who likes to ${referrer.hobby}.")
            }
        }
        // persoon heeft geen referrer
        else {
            print("Doesn't have a referrer.")
        }

        println()
        println()
    }
}