fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8

    val result = firstNumber + secondNumber
    val anotherResult = add(firstNumber, thirdNumber)
    val subtractResult = subtract(firstNumber, secondNumber)

    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")
    println("$firstNumber - $secondNumber = $subtractResult")
}

fun add(a: Int, b: Int) : Int {
    return a + b
}

fun subtract(a: Int, b: Int) : Int {
    return a - b
}