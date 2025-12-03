import org.assertj.core.api.Assertions.assertThat
import kotlin.math.pow

fun main() {
    fun part1(input: List<String>): Int {
        var joltageSum = 0

        input.map { it -> it.chunked(1).map { it.toInt() } }
            .forEach {
                println(it)
                val indexTenner = findFirstIndexOfBiggestInt(it.take(it.size - 1))
                val indexOner = findFirstIndexOfBiggestInt(it.drop(indexTenner + 1)) + indexTenner + 1

                val biggestJoltage = it[indexTenner] * 10 + it[indexOner]
                println("Biggest joltage: $biggestJoltage")

                joltageSum += biggestJoltage
            }

        return joltageSum
    }

    fun part2(input: List<String>): Long {
        var joltageSum = 0L

        input.map { it -> it.chunked(1).map { it.toInt() } }
            .forEach {

                println("Batteries: $it")

                var biggestJoltage = 0L
                var startIndex = 0

                for (battery in 1..12) {

                    val subList = it.subList(startIndex, it.size - (12 - battery))

                    println("SubList $subList")

                    val subListIndex = findFirstIndexOfBiggestInt(subList)

                    println("SubListIndex $subListIndex")

                    val biggestValue = subList[subListIndex]

                    println("Biggest value $biggestValue")

                    val shift = 10.toDouble().pow(12 - battery).toLong()

                    println("Shift $shift")

                    biggestJoltage += biggestValue * shift

                    println("Biggest joltage: $biggestJoltage")

                    startIndex += subListIndex + 1
                }

                println("Biggest joltage: $biggestJoltage")

                joltageSum += biggestJoltage
            }

        return joltageSum
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day03_test.txt` file:
    val testInput = readInput("Day03_test")
    assertThat(part1(testInput)).isEqualTo(357)

    // Read the input from the `src/Day03.txt` file.
    val input = readInput("Day03")
    part1(input).println()

    assertThat(part2(testInput)).isEqualTo(3121910778619L)
    part2(input).println()
}

fun findFirstIndexOfBiggestInt(numbers: List<Int>): Int {
    var biggestNumber = 0
    var firstIndex = 0
    var index = 0

    while (index < numbers.size) {
        if (numbers[index] > biggestNumber) {
            biggestNumber = numbers[index]
            firstIndex = index
        }
        index++
    }

    return firstIndex
}