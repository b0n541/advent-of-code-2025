import org.assertj.core.api.Assertions.assertThat

fun main() {
    fun part1(input: List<String>): Long {

        var invalidIdSum = 0L

        input[0].split(",")
            .map { range ->
                LongRange(
                    range.split("-")[0].toLong(),
                    range.split("-")[1].toLong()
                )
            }
            .forEach { range ->
                run {
                    println("Checking IDs $range")

                    range.forEach { productId ->
                        run {
                            if (isInvalidProductId(productId)) {
                                println("Invalid ID: $productId")
                                invalidIdSum += productId
                            }
                        }
                    }
                }
            }

        return invalidIdSum
    }

    fun part2(input: List<String>): Long {

        var invalidIdSum = 0L

        input[0].split(",")
            .map { range ->
                LongRange(
                    range.split("-")[0].toLong(),
                    range.split("-")[1].toLong()
                )
            }
            .forEach { range ->
                run {
                    println("Checking IDs $range")

                    range.forEach { productId ->
                        run {
                            if (isInvalidProductId2(productId)) {
                                println("Invalid ID: $productId")
                                invalidIdSum += productId
                            }
                        }
                    }
                }
            }

        return invalidIdSum
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day02_test.txt` file:
    val testInput = readInput("Day02_test")
    assertThat(part1(testInput)).isEqualTo(1227775554)

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day02")
    part1(input).println()

    assertThat(part2(testInput)).isEqualTo(4174379265)
    part2(input).println()
}

fun isInvalidProductId(id: Long): Boolean {

    val idString = id.toString()

    return idString.take(idString.length / 2) == idString.substring(idString.length / 2)
}

fun isInvalidProductId2(id: Long): Boolean {

    val idString = id.toString()

    for (chunkSize in 1..idString.length / 2) {
        val chunk = idString.take(chunkSize)
        var repetitionCount = 2
        while (chunk.length * repetitionCount <= idString.length) {
            if (idString == chunk.repeat(repetitionCount)) {
                return true
            }
            repetitionCount++
        }
    }

    return false
}