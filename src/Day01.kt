fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }


    // test if implementation meets criteria from the description, like:
    val input: List<String> = readInput("Day01")

    

    val indexes = mutableListOf<Int>()
    indexes.add(0)
    input.forEachIndexed { index, s ->
        if (s.isEmpty()) {
            indexes.add(index - 1)
            indexes.add(index + 1)
        }
    }
    indexes.add(input.size - 1)

    val ranges: MutableList<IntRange> = mutableListOf()
    for (index in 0 until indexes.size step 2) {
        ranges.add(indexes.get(index)..indexes.get(index + 1))
    }
    val slices: MutableList<List<String>> = mutableListOf()
    ranges.forEach {range ->
        slices.add(input.slice(range))
    }

    val max = slices.maxOf {
        it.sumOf { it.toInt() }
    }

    // part 1
    println("max is $max")


    // part 2
    slices.sortByDescending {
        it.sumOf { it.toInt() }
    }
    val top3 = slices.take(3).sumOf {
        it.sumOf { it.toInt() }
    }

    println("Top3 sum is $top3")

}
