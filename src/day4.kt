fun main() {

    val input: List<String> = readInput("day4")

    val map = input.map { sections ->
        val (pair1, pair2) = sections.split(",")
        val section1 = pair1.split("-").map(String::toInt)
        val section2 = pair2.split("-").map(String::toInt)
        val range1 = IntRange(section1.get(0), section1.get(1))
        val range2 = IntRange(section2.get(0), section2.get(1))
        range1 to range2
    }

    fun part1(): Int {
        return map.count { it: Pair<IntRange, IntRange> ->
            val range1 = it.first
            val range2 = it.second
            range1.first in range2 && range1.last in range2 || range2.first in range1 && range2.last in range1
        }
    }

    fun part2(): Int {
        return map.count {
            val range1 = it.first
            val range2 = it.second
            range1.intersect(range2).isNotEmpty()
        }
    }

    println("Total part 1 is ${part1()}")
    println("Total part 2 is ${part2()}")




    fun parse(input: List<String>) = input
        .map { line ->
            val (a1, a2) = line.substringBefore(',').split('-').map(String::toInt)
            val (b1, b2) = line.substringAfter(',').split('-').map(String::toInt)
            (a1..a2) to (b1..b2)
        }

    operator fun IntRange.contains(other: IntRange) =
        other.first in this && other.last in this

    fun part1(input: List<String>) = parse(input)
        .count { (r1, r2) -> r1 in r2 || r2 in r1 }

    fun part2(input: List<String>) = parse(input)
        .count { (r1, r2) -> r1.intersect(r2).isNotEmpty() }

}
