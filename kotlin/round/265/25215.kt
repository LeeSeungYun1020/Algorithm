import kotlin.math.min

fun main() {
    var capsLockOn = 0
    var capsLockOff = 0
    val input = readln()

    if (input.first().isLowerCase()) {
        capsLockOff += 1
        capsLockOn += 2
    } else {
        capsLockOff += 2
        capsLockOn += 2
    }
    (1 until input.lastIndex).map { input[it] }.forEach { c ->
        (capsLockOff to capsLockOn).let { (off, on) ->
            if (c.isLowerCase()) {
                capsLockOff = min(off + 1, on + 2)
                capsLockOn = min(off + 2, on + 2)
            } else {
                capsLockOff = min(off + 2, on + 2)
                capsLockOn = min(off + 2, on + 1)
            }
        }
    }
    if (input.length > 1) {
        if (input.last().isLowerCase()) {
            capsLockOff += 1
            capsLockOn += 2
        } else {
            capsLockOff += 2
            capsLockOn += 1
        }
    }
    println(min(capsLockOff, capsLockOn))
}