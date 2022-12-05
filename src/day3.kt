fun main() {

    val input: List<String> = readInput("day3")
    var total = 0
    input.forEach {
        val input2: List<String> = it.chunked(it.length / 2)
        val left = input2.get(0)
        val right = input2.get(1)
        val result: Char = left.first {
            right.contains(it)
        }
        println("common in $it: $result")
        total += totalFromChar(result)
    }
    println("total is $total")

    // part 2
    total = 0
    val groups: List<List<String>> = input.chunked(3)
    groups.forEach { group: List<String> ->
        val elf1 = group.get(0)
        val elf2 = group.get(1)
        val elf3 = group.get(2)
        val result = elf1.first {
            elf2.contains(it) && elf3.contains(it)
        }
        total += totalFromChar(result)
    }
    println("total part 2 is $total")

}

private fun totalFromChar(result: Char) = if (result.isLowerCase()) {
    result.code - 96
} else {
    (result.code - 64) + 26
}
