package easy

fun romanToInteger(s: String = "MCMXCIV"): Int {
    var acc = 0
    var forwardValue = 1001
    s.forEach {
        val num = when (it) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
        acc += if (forwardValue >= num) num else num - forwardValue * 2
        forwardValue = num
    }
    return acc
}
