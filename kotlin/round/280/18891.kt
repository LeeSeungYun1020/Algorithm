import kotlin.math.floor
import kotlin.math.roundToInt

fun main() {
    val (numberOfParties, _) = readln().split(" ").map { it.toInt() }

    Election(
        parties = List(numberOfParties) { readln().toParty() },
        assignable = { party, validVoters -> party.votesOfProportion >= validVoters * 0.03 || party.local >= 5 }
    ).report.run { println(this) }
}

class Election(
    parties: List<Party>,
    assignable: (party: Party, validVoters: Long) -> Boolean,
) {
    private val state = parties.associate { it.name to it.local }.toMutableMap()
    val report
        get() = state.entries.sortedWith(compareBy({ -it.value }, { it.key }))
            .joinToString(separator = "\n") { "${it.key} ${it.value}" }

    init {
        val assign =
            parties.filter { assignable(it, parties.sumOf { it.votesOfProportion }) }.let { assignableParties ->
                val sum = assignableParties.sumOf { it.votesOfProportion }
                assignableParties.map { AssignParty(it.name, it.local, it.votesOfProportion.toDouble() / sum) }
            }

        calcPrioritySeats(assign)
        calcParallelSeats(assign)
    }

    private fun calcPrioritySeats(assign: List<AssignParty>) {
        val priority = (47 + assign.sumOf { it.local })
        val prioritySeats = assign.map {
            val intermediate = (priority * it.ratioOfProportion - it.local) / 2
            Seat(it.name, if (intermediate < 1) 0 else intermediate.roundToInt())
        }
        val prioritySeatsSum = prioritySeats.sumOf { it.seats }

        val interlockSeats = when {
            prioritySeatsSum < 30 -> {
                allocate(
                    30,
                    assign.zip(prioritySeats)
                        .map { it.first.name to it.second.seats + ((30 - prioritySeatsSum) * it.first.ratioOfProportion) })
            }
            prioritySeatsSum > 30 -> {
                allocate(30, prioritySeats.map { it.name to (30.0 * it.seats) / prioritySeatsSum })
            }
            else -> prioritySeats
        }
        interlockSeats.forEach { state[it.name] = (state[it.name] ?: 0) + it.seats }
    }

    private fun calcParallelSeats(assign: List<AssignParty>) {
        val parallelSeats = allocate(17, assign.map { it.name to 17 * it.ratioOfProportion })
        parallelSeats.forEach { state[it.name] = (state[it.name] ?: 0) + it.seats }
    }

    private fun allocate(number: Int, data: List<Pair<String, Double>>): List<Seat> {
        val calc =
            data.map {
                Triple(
                    it.first,
                    floor(it.second).toInt(),
                    ((it.second - floor(it.second)) * 10_000_000_000_000L).toLong()
                )
            }
                .sortedByDescending { it.third }.toCollection(ArrayDeque())

        repeat(number - calc.sumOf { it.second }) {
            val state = calc.removeFirst()
            calc.addLast(Triple(state.first, state.second + 1, state.third))
        }

        return calc.map { Seat(it.first, it.second) }
    }

    private class AssignParty(
        val name: String,
        val local: Int,
        val ratioOfProportion: Double,
    )

    private class Seat(
        val name: String,
        val seats: Int,
    )
}

class Party(
    val name: String,
    val local: Int,
    val votesOfProportion: Long,
)

fun String.toParty() = split(" ").let { Party(it[0], it[1].toInt(), it[2].toLong()) }