fun main() {

    // A, X -> rock = 1
    // B, Y -> paper = 2
    // C, Z -> scissors = 3

    val input: List<String> = readInput("day2")
    var total = 0
    input.forEach {
        val game = it.split(" ")
        val player2 = game[0]
        when (game[1]) {
            "X" -> total += getGameScoreForX(player2)
            "Y" -> total += getGameScoreForY(player2)
            "Z" -> total += getGameScoreForZ(player2)
        }
    }

    println("total score of games = $total")

    // part 2
    // X loose
    // y draw
    // z win
    total = 0
    input.forEach {
        val game = it.split(" ")
        val player2 = game[0]
        when (game[1]) {
            "X" -> total += getScoreToLoose(player2)
            "Y" -> total += getScoreToDraw(player2) + 3
            "Z" -> total += getScoreToWin(player2) + 6
        }
    }
    println("total score of game 2 = $total")

}



fun getGameScoreForX(player2: String): Int {
    val score = when (player2) {
        "A" -> 3
        "B" -> 0
        "C" -> 6
        else -> 0
    }
    return score + 1
}
fun getGameScoreForY(player2: String): Int {
    val score = when (player2) {
        "A" -> 6
        "B" -> 3
        "C" -> 0
        else -> 0
    }
    return score + 2
}
fun getGameScoreForZ(player2: String): Int {
    val score = when (player2) {
        "A" -> 0
        "B" -> 6
        "C" -> 3
        else -> 0
    }
    return score + 3
}

fun getScoreOfPlay(play: String): Int {
    if (play == "X") return 1
    if (play == "Y") return 2
    if (play == "Z") return 3
    return 0
}

fun getScoreToWin(player2: String): Int {
    if (player2 == "A") return getScoreOfPlay("Y")
    if (player2 == "B") return getScoreOfPlay("Z")
    if (player2 == "C") return getScoreOfPlay("X")
    return 0
}


fun getScoreToDraw(player2: String): Int {
    if (player2 == "A") return getScoreOfPlay("X")
    if (player2 == "B") return getScoreOfPlay("Y")
    if (player2 == "C") return getScoreOfPlay("Z")
    return 0
}

fun getScoreToLoose(player2: String): Int {
    if (player2 == "A") return getScoreOfPlay("Z")
    if (player2 == "B") return getScoreOfPlay("X")
    if (player2 == "C") return getScoreOfPlay("Y")
    return 0
}




