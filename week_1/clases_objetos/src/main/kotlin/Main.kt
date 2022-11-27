import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty as KProperty1

open class SmartDevice(val name: String, val category: String) {

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    var deviceStatus = "online"
        protected set


    open val deviceType: String = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
//    val name = "Android TV"
//    val category = "Entertainment"
//    var deviceStatus1 = "online"
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    var speakerVolume1 = 2
//        get() = field
//        set(value) {
//            field = value
//        }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}


class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
    override val deviceType: String = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name is turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("$name turned off")
    }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decrease to $brightnessLevel.")
    }
}


class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
    //    var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }
    override val deviceType: String = "Smart TV"
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume set to $speakerVolume and channel number is " + "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    fun decreaseVolume() {
        speakerVolume--
        println("Speaker volume decrease to $speakerVolume.")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel number decrease to $channelNumber.")
    }
}


class SmartHome(val smartTvDevice: SmartTvDevice, val smartLightDevice: SmartLightDevice) {
    var deviceTurnOnCount = 0
        private set
    var deviceStatus = "on"
    fun turnOnTv() {
        deviceStatus = "on"
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceStatus = "off"
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        if (deviceStatus == "on") smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        if (deviceStatus == "on") smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        if (deviceStatus == "on") {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
    }

    fun turnOffLight() {
        if (deviceStatus == "on") {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
    }

    fun increaseLightBrightness() {
        if (deviceStatus == "on") smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        if (deviceStatus == "on") {
            turnOffTv()
            turnOffLight()
        }
    }

    fun decreaseTvVolume() {
        if (deviceStatus == "on") smartTvDevice.decreaseVolume()
    }

    fun changeTvChannelToPrevious() {
        if (deviceStatus == "on") smartTvDevice.previousChannel()
    }

    fun printSmartTvInfo() {
        if (deviceStatus == "on") smartTvDevice.printDeviceInfo()
    }

    fun printSmartLightInfo() {
        if (deviceStatus == "on")  smartLightDevice.printDeviceInfo()
    }

    fun decreaseLightBrightness() {
        if (deviceStatus == "on") smartLightDevice.decreaseBrightness()
    }
}

class RangeRegulator(
    initialValue: Int, private val minValue: Int, private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {
    private var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty1<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty1<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }

}

fun main() {
//    val smartTvDevice = SmartDevice(name = "Android TV", category = "Entertainment")
//
//    println("Device name is: ${smartTvDevice.name}")
//    smartTvDevice.turnOn()
//    smartTvDevice.turnOff()
    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
    )

    smartHome.turnOnTv()
    smartHome.turnOnLight()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseTvVolume()
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.changeTvChannelToPrevious()

    smartHome.increaseLightBrightness()
    smartHome.decreaseLightBrightness()
    println()

    smartHome.printSmartLightInfo()
    smartHome.printSmartTvInfo()
    println()

    smartHome.turnOffAllDevices()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}.")
}


