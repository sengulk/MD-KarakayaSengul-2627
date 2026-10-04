open class Phone(var isScreenLightOn: Boolean = false) {
    // switchOn() krijgt ook 'open', zodat we die kunnen overschrijven
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean = true) : Phone() {
    // switchOn() overschrijven
    override fun switchOn() {
        if (!isFolded) {
            super.switchOn()
        }
    }

    fun fold() {
        isFolded = true
        switchOff()
    }

    fun unfold() {
        isFolded = false
        switchOn()
    }
}

fun main() {
    val phone = FoldablePhone()

    // telefoon is dicht
    phone.switchOn()
    phone.checkPhoneScreenLight()

    // telefoon is open
    phone.unfold()
    phone.checkPhoneScreenLight()

    // telefoon is terug dicht
    phone.fold()
    phone.checkPhoneScreenLight()
}