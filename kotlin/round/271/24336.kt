import kotlin.math.absoluteValue

fun main() {
    val station = mapOf(
        "Seoul" to 0.0,
        "Yeongdeungpo" to 9.1,
        "Anyang" to 23.9,
        "Suwon" to 41.5,
        "Osan" to 56.5,
        "Seojeongri" to 66.5,
        "Pyeongtaek" to 75.0,
        "Seonghwan" to 84.4,
        "Cheonan" to 96.6,
        "Sojeongni" to 107.4,
        "Jeonui" to 114.9,
        "Jochiwon" to 129.3,
        "Bugang" to 139.8,
        "Sintanjin" to 151.9,
        "Daejeon" to 166.3,
        "Okcheon" to 182.5,
        "Iwon" to 190.8,
        "Jitan" to 196.4,
        "Simcheon" to 200.8,
        "Gakgye" to 204.6,
        "Yeongdong" to 211.6,
        "Hwanggan" to 226.2,
        "Chupungnyeong" to 234.7,
        "Gimcheon" to 253.8,
        "Gumi" to 276.7,
        "Sagok" to 281.3,
        "Yangmok" to 289.5,
        "Waegwan" to 296.0,
        "Sindong" to 305.9,
        "Daegu" to 323.1,
        "Dongdaegu" to 326.3,
        "Gyeongsan" to 338.6,
        "Namseonghyeon" to 353.1,
        "Cheongdo" to 361.8,
        "Sangdong" to 372.2,
        "Miryang" to 381.6,
        "Samnangjin" to 394.1,
        "Wondong" to 403.2,
        "Mulgeum" to 412.4,
        "Hwamyeong" to 421.8,
        "Gupo" to 425.2,
        "Sasang" to 430.3,
        "Busan" to 441.7,
    )

    val (numberOfTimes, numberOfQueries) = readln().split(" ").map { it.toInt() }
    val timetable = buildMap<String, Pair<Int, Int>> {
        var day = 0
        var last = -1
        repeat(numberOfTimes) {
            val time = readln().split(" ")
            var start = day + time[1].toMinute()
            var end = day + time[2].toMinute()
            if (start < last) {
                day += 24 * 60
                start += 24 * 60
                end += 24 * 60
            }
            last = end
            put(time[0], start to end)
        }
    }
    repeat(numberOfQueries) {
        val (departure, destination) = readln().split(" ")
        val distance = (station.getValue(departure) - station.getValue(destination)).absoluteValue
        val time = timetable.getValue(destination).first - timetable.getValue(departure).second
        println(distance / time * 60)
    }
}

fun String.toMinute(): Int {
    val (hour, minute) = split(":").map { it.toIntOrNull() ?: 0 }
    return hour * 60 + minute
}

/*
    """
        1	Seoul	0.0	Y	23	Chupungnyeong	234.7	N
        2	Yeongdeungpo	9.1	Y	24	Gimcheon	253.8	Y
        3	Anyang	23.9	N	25	Gumi	276.7	Y
        4	Suwon	41.5	Y	26	Sagok	281.3	N
        5	Osan	56.5	N	27	Yangmok	289.5	N
        6	Seojeongri	66.5	N	28	Waegwan	296.0	Y
        7	Pyeongtaek	75.0	Y	29	Sindong	305.9	N
        8	Seonghwan	84.4	N	30	Daegu	323.1	Y
        9	Cheonan	96.6	Y	31	Dongdaegu	326.3	Y
        10	Sojeongni	107.4	N	32	Gyeongsan	338.6	N
        11	Jeonui	114.9	N	33	Namseonghyeon	353.1	N
        12	Jochiwon	129.3	Y	34	Cheongdo	361.8	N
        13	Bugang	139.8	N	35	Sangdong	372.2	N
        14	Sintanjin	151.9	N	36	Miryang	381.6	Y
        15	Daejeon	166.3	Y	37	Samnangjin	394.1	N
        16	Okcheon	182.5	N	38	Wondong	403.2	N
        17	Iwon	190.8	N	39	Mulgeum	412.4	N
        18	Jitan	196.4	N	40	Hwamyeong	421.8	N
        19	Simcheon	200.8	N	41	Gupo	425.2	Y
        20	Gakgye	204.6	N	42	Sasang	430.3	N
        21	Yeongdong	211.6	Y	43	Busan	441.7	Y
        22	Hwanggan	226.2	N
    """.trimIndent().split("\t", " ").filter { it.isNotBlank() }.chunked(4) {
        it[1] to it[2].toDouble()
    }.sortedBy { it.second }.joinToString(separator = "\n") { "\"${it.first}\" to ${it.second},"}.let { println(it) }
 */