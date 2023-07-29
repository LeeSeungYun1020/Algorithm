fun main() {
    val input = readln()
    var leftGreaterThanTwoCounter = 0
    var rightCounter = 0
    var status = 0
    for (item in input) {
        if (item == '(') {
            status++
            if (status >= 2)
                leftGreaterThanTwoCounter++
        } else {
            rightCounter++
            status--
            if (status < 2)
                leftGreaterThanTwoCounter = 0
        }

        if (status < 0) {
            println(rightCounter)
            return
        }
    }
    println(leftGreaterThanTwoCounter)
}