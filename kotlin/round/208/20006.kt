fun main() {
    val (numberOfPlayer, maxPlayer) = readln().split(" ").map { it.toInt() }
    val rooms = mutableListOf<Room>()
    List(numberOfPlayer) { readln().toPlayer() }.forEach { player ->
        var isAdded = false
        for (room in rooms) {
            if (room.add(player)) {
                isAdded = true
                break
            }
        }
        if (!isAdded) {
            rooms.add(Room(host = player, maxPlayer = maxPlayer))
        }
    }
    println(rooms.joinToString(separator = "\n"))
}

class Player(val level: Int, val name: String) {
    override fun toString(): String {
        return "$level $name"
    }
}

fun String.toPlayer(): Player {
    val intermediate = this.split(" ")
    return Player(intermediate[0].toInt(), intermediate[1])
}

class Room(private val host: Player, private val maxPlayer: Int) {
    private val playerList = mutableListOf(host)
    private val status: String
        get() = if (playerList.size == maxPlayer) "Started!" else "Waiting!"

    fun add(player: Player): Boolean {
        return if (playerList.size < maxPlayer && player.level in host.level - 10..host.level + 10)
            playerList.add(player)
        else
            false
    }

    override fun toString(): String {
        return status + "\n" + playerList.sortedBy { it.name }.joinToString(separator = "\n")
    }
}