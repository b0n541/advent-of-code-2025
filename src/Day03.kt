import org.assertj.core.api.Assertions.assertThat

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day03_test.txt` file:
    val testInput = readInput("Day03_test")
    assertThat(part1(testInput)).isEqualTo(1)

    // Read the input from the `src/Day03.txt` file.
    val input = readInput("Day03")
    part1(input).println()

    assertThat(part2(testInput)).isEqualTo(4174379265)
    part2(input).println()
}