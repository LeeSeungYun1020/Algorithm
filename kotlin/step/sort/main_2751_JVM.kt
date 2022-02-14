import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val count = br.readLine()!!.toInt()
    val num = Array(count) { 0 }
    for (i in 0 until count){
        num[i] = (br.readLine()!!.toInt())
    }
    val tem = Array(count) { 0 }
    mergeSort(num, 0, num.lastIndex, tem)
    num.forEach { bw.write("$it\n") }
    bw.flush()
    bw.close()
    br.close()
}

fun mergeSort(origin:Array<Int>, low:Int, high:Int, sorted:Array<Int>) {
    if (low >= high) return
    val mid = (low + high) / 2

    mergeSort(origin, low, mid, sorted)
    mergeSort(origin, mid + 1, high, sorted)

    var i = low
    var j = mid + 1
    var k = low
    while (k <= high){
        sorted[k] = when {
            i > mid -> origin[j++]
            j > high -> origin[i++]
            origin[i] < origin[j] -> origin[i++]
            else -> origin[j++]
        }
        k++
    }
    for (l in low..high)
        origin[l] = sorted[l]
}