class Song(val name: Int, val play: Int)

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val songs = mutableMapOf<String, MutableList<Song>>()
        val songPlays = mutableMapOf<String, Int>()
        for (i in 0..genres.lastIndex) {
            if (songs.get(genres[i]) == null || songPlays.get(genres[i]) == null) {
                songs.put(genres[i], mutableListOf(Song(i, plays[i])))
                songPlays.put(genres[i], plays[i])
            } else {
                songs[genres[i]]?.add(Song(i, plays[i]))
                songPlays[genres[i]] = songPlays[genres[i]]!! + plays[i]
            }
        }

        val sortedSongPlays = songPlays.toList().sortedBy{ -it.second }
        val answer = mutableListOf<Int>()
        for ((genre, play) in sortedSongPlays) {
            val gSongs = songs[genre]
            if (gSongs != null) {
                if (gSongs.size == 1) {
                    answer.add(gSongs[0].name)
                } else {
                    val sortedGSongs = gSongs.sortedBy { -it.play }
                    answer.add(sortedGSongs[0].name)
                    answer.add(sortedGSongs[1].name)
                }
            }

        }

        return answer.toIntArray()
    }
}