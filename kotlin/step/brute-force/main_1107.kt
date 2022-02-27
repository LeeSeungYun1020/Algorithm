import kotlin.math.absoluteValue
import kotlin.math.min

fun main() {
    val input = readLine()!!
    val target = input.toInt()
    val tList = input.map { it.toInt() - 48 }
    var channel = 100
    if (target == channel) {
        println(0)
        return
    }

    val br = readLine()!!.toInt()
    if (br == 0) {
        println(min((target - channel).absoluteValue, input.length))
        return
    } else if (br == 10) {
        println((target - channel).absoluteValue)
        return
    }

    val button = MutableList(10) { true }
    val buttonInput = readLine()!!.split(" ").map { it.toInt() }
    for (i in buttonInput) {
        button[i] = false
    }


    var countLow = input.length
    var countHigh = input.length
    var branch = false
    var compareLow = 0
    var compareHigh = 0
    var checkLow = true
    var checkHigh = true

    for ((idx, n) in tList.withIndex()) {
        // 앞 단계에서 분기된 경우 (이미 앞자리 결정된 경우) -> 남은 자리가 작은 값은 최대, 큰 값은 최소가 되어야 함
        if (branch) {
            if (checkHigh) {
                for (i in 0..9) {
                    if (button[i]) {
                        compareHigh = compareHigh * 10 + i
                        break
                    }
                }
            }
            if (checkLow) {
                for (i in 9 downTo 0) {
                    if (button[i]) {
                        compareLow = compareLow * 10 + i
                        break
                    }
                }
            }
        }
        // 해당 번호 사용 가능
        else if (button[n]) {
            compareLow = compareLow * 10 + n
            compareHigh = compareHigh * 10 + n
        }
        // 번호 사용 불가 -> 작은 값, 큰 값으로 경우 분기
        else {
            if (checkHigh) {
                var changeHigh = false
                for (i in n + 1..9) {
                    if (button[i]) {
                        compareHigh = compareHigh * 10 + i
                        changeHigh = true
                        break
                    }
                }
                if (!changeHigh) {
                    // 올림 시도
                    val up = compareHigh % 10
                    for (i in up + 1..9) {
                        if (button[i]) {
                            compareHigh -= up
                            compareHigh += i
                            if (up == 0)
                                countHigh++
                            for (j in 0..9) {
                                if (button[j]) {
                                    compareHigh = compareHigh * 10 + j
                                    break
                                }
                            }
                            changeHigh = true
                            break
                        }
                    }
                    if (!changeHigh)
                        checkHigh = false
                }
            }
            if (checkLow) {
                var changeLow = false
                for (i in n - 1 downTo 0) {
                    if (button[i]) {
                        if (idx == 0 && i == 0 && input.length > 1) {
                            countLow--
                        }
                        compareLow = compareLow * 10 + i
                        changeLow = true
                        break
                    }
                }
                if (!changeLow) {
                    // 내림 시도
                    if (idx == 0 && input.length > 1)
                        countLow--
                    else {
                        val down = compareLow % 10
                        for (i in down - 1 downTo 0) {
                            if (button[i] || (idx == 1 && i == 0)) {
                                if (idx == 1 && i == 0)
                                    countLow--
                                compareLow -= down
                                compareLow += i
                                for (j in 9 downTo 0)
                                    if (button[j]) {
                                        compareLow = compareLow * 10 + j
                                        break
                                    }
                                changeLow = true
                                break
                            }
                        }

                        if (!changeLow)
                            checkLow = false
                    }
                }
            }
            branch = true
        }
    }
    // println("$compareHigh $countHigh ($checkHigh) //  $compareLow $countLow ($checkLow)")
    var answer = (target - channel).absoluteValue
    if (checkHigh)
        answer = min(answer, compareHigh - target + countHigh)
    if (checkLow)
        answer = min(answer, target - compareLow + countLow)
    println(answer)
}