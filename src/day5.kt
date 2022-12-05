import java.io.File
import java.util.Stack

fun main() {

    val file5 = File("src", "day5.txt").readText()
    val (stacks, movementsStr) = file5.split("\r\n\r\n")
    val stackLines = stacks.split("\r\n")
    val movements = movementsStr.split("\r\n")

    var stackMap = getStackMapFromInput(stackLines)
    println(stackMap)

    movements.forEach { movement ->
        val (n, f) = movement.replace("move ", "").split(" from ")
        val numberOfMoves = n.toInt()
        val (from, to) = f.split(" to ").map { it.toInt() }
        repeat(numberOfMoves) {
            stackMap[to]!!.push(stackMap[from]!!.pop())
        }
    }

    println(stackMap)

    val result = stackMap.map { it.value.pop() }.joinToString(separator = "") { it.toString() }
    println("result is $result")

    // part 2
    stackMap = getStackMapFromInput(stackLines)
    movements.forEach { movement ->
        val (n, f) = movement.replace("move ", "").split(" from ")
        val numberOfMoves = n.toInt()
        val (from, to) = f.split(" to ").map { it.toInt() }
        val listToAdd = mutableListOf<Char>()
        repeat(numberOfMoves) {
            listToAdd.add(stackMap[from]!!.pop())
        }
        listToAdd.reversed().forEach {
            stackMap[to]!!.push(it)
        }
    }

    val result2 = stackMap.map { it.value.pop() }.joinToString(separator = "") { it.toString() }
    println("result2 is $result2")

}

private fun getStackMapFromInput(
    stackLines: List<String>,
): MutableMap<Int, Stack<Char>> {
    val stackMap = mutableMapOf<Int, Stack<Char>>()
    (stackLines.size - 2 downTo 0).forEach { lineIndex ->
        val line = stackLines[lineIndex]
        (1..line.length step 4).forEachIndexed { stepIndex, charIndex ->
            val stackIndex = stepIndex + 1
            val stack = stackMap[stackIndex] ?: Stack<Char>()
            val char = line[charIndex]
            if (char.isLetter()) {
                stack.push(char)
                stackMap[stackIndex] = stack
            }
        }
    }
    return stackMap
}