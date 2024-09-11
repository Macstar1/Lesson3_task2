fun main() {
    val cardType = MIR
    val dayTransferSum = 0
    val monthTransferSum = 0
    val transfer = 75_500

    printResult(cardType, monthTransferSum, dayTransferSum, transfer)

}

fun printResult(cardType: String, monthTransferSum: Int, dayTransferSum: Int, transfer: Int){

    if ((monthTransferSum + transfer <= MAX_MONTH_TRANSFER) &&
        (dayTransferSum + transfer <= MAX_DAY_TRANSFER)
    )
        println(transferComission(cardType, transfer))
    else println("Операция заблокирована из-за превышения лимита!")
}

fun transferComission(cardType: String, transfer: Int): Int {
    return when (cardType) {
        MASTERCARD -> masterCsrdComission(transfer)
        VISA -> visaComission(transfer)
        else -> 0
    }
}

fun masterCsrdComission(sum: Int): Int {
    return if (sum <= MASTERCARD_LIMIT) 0 else ((sum - MASTERCARD_LIMIT) * MASTERCARD_COMISSION + 20).toInt()
}

fun visaComission(sum: Int): Int {
    return if (sum * VISA_COMISSION < VISA_MIN_COMISSION) {
        VISA_MIN_COMISSION
    } else (sum * VISA_COMISSION).toInt()
}

const val MASTERCARD_LIMIT = 75_000
const val MAX_DAY_TRANSFER = 150_000
const val MAX_MONTH_TRANSFER = 600_000
const val MIR = "Мир"
const val VISA = "Visa"
const val MASTERCARD = "Mastercard"
const val VISA_COMISSION = 0.0075
const val MASTERCARD_COMISSION = 0.006
const val VISA_MIN_COMISSION = 35

