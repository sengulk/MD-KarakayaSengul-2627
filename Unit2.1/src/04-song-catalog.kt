class Song (val title: String, val artist: String, val yearPublished: Int, var playCount: Int) {
    val isPopular: Boolean
        get() = playCount >= 1000

    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}

fun main() {
    val song1 = Song("Bohemian Rhapsody", "Queen", 1975, 2500000)
    val song2 = Song("Tourner dans le vide", "Indila", 2014, 850000)
    val song3 = Song("My first song", "Sengül", 2026, 42)

    song1.printDescription()
    song2.printDescription()
    song3.printDescription()

    println(song3.isPopular)
    song3.playCount = 5000
    println(song3.isPopular)
}