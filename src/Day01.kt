fun main() {
    fun part1(input: List<String>): Int {

        var zeroCount = 0
        var dial = 50

        input.map { line -> Pair(line.take(1), line.substring(1).toInt()) }
            .forEach { instruction ->
                when (instruction.first) {
                    "L" -> dial -= instruction.second
                    "R" -> dial += instruction.second
                }

                while (dial < 0) {
                    dial += 100
                }

                while (dial > 99) {
                    dial -= 100
                }

                if (dial == 0) {
                    zeroCount++
                }
            }

        println("Zero count: $zeroCount")

        return zeroCount
    }

    fun part2(input: List<String>): Int {

        var zeroCount = 0
        var dial = 50

        input.map { line -> Pair(line.take(1), line.substring(1).toInt()) }
            .forEach { instruction ->
                val direction = when (instruction.first) {
                    "L" -> -1
                    "R" -> 1
                    else -> 0
                }

                var amount = instruction.second

                println("Direction: $direction Amount: $amount")
                println("Start dial: $dial")
                println("Start zero count: $zeroCount")

                while (amount > 99) {
                    amount -= 100
                    zeroCount++
                }

                println("Amount left: ${direction * amount}")

                val startDialAtZero = dial == 0
                dial += direction * amount

                if (dial == 0) {
                    zeroCount++
                }

                if (dial < 0) {
                    dial += 100
                    if (!startDialAtZero) {
                        zeroCount++
                    }
                }

                if (dial > 99) {
                    dial -= 100
                    zeroCount++
                }

                println("End dial: $dial")
                println("End zero count: $zeroCount")
                println()
            }

        println("Zero count: $zeroCount")

        return zeroCount
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 3)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()

    check(part2(testInput) == 6)
    part2(input).println() // > 5956 && < 6582
}
