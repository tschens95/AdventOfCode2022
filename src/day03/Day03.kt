package day03

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        var totalSum = 0
        for (s in input) {
            val half = s.length / 2
            val parts = s.chunked(half)
            for (c in parts[0]) {
                if (parts[1].contains(c)) {
                    if (c.isLowerCase()) {
                        totalSum += (c.code - 96)
                        break
                    } else {
                        totalSum += (c.code - 38)
                        break
                    }
                }
            }
        }
        return totalSum
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val testInput = "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
            "PmmdzqPrVvPwwTWBwg\n" +
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
            "ttgJtRGJQctTZtZT\n" +
            "CrZsJsPPZsGzwwsLwLmpwMDw"

    println(part1(testInput.split("\n")))

    val input = readInput("03")
    println(part1(input))
    println(part2(input))
}
