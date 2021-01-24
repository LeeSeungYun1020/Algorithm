fun main() {
    val (a, b) = readLine()!!.split(" ")
    val sum = mutableListOf<String>()
    var carry = 0

    var aPos = a.length - 18
    var bPos = b.length - 18
    while (true) {
        val aNum = when {
                aPos > 0 -> a.substring(aPos, aPos + 18).toULong()
                aPos in -17..0 -> a.substring(0, aPos + 18).toULong()
                else -> 0UL
            }
        val bNum = when {
            bPos > 0 -> b.substring(bPos, bPos + 18).toULong()
            bPos in -17..0 -> b.substring(0, bPos + 18).toULong()
            else -> 0UL
        }

        var s = aNum + bNum + carry.toULong()
        if (s >= 1000000000000000000UL) {
            s -= 1000000000000000000UL
            carry = 1
        } else
            carry = 0

        sum.add(s.toString())
        if (aPos < 0 && bPos < 0)
            break
        aPos -= 18
        bPos -= 18
    }

    print(sum.last())
    for (i in (sum.size - 2).downTo(0))
        print(sum[i].padStart(18, '0'))
}