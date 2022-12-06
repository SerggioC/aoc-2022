import java.io.File

fun main() {

    val file6 = File("src/day6.txt").readText()

    var index = 0
    do {
        val set = file6.subSequence(index, index + 14).toSet()
        index++
    } while (set.size != 14 && index < file6.length - 14)
    index--

    println("The index is ${index + 14}")

}
