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
        var totalSum = 0
        var index = 0
        while (index < input.size) {
            val s1 = input[index]
            val s2 = input[index + 1]
            val s3 = input[index + 2]
            var found = false
            while (!found) {
                for (c in s1) {
                    if (s2.contains(c) && s3.contains(c)) {
                        totalSum += if (c.isLowerCase()) {
                            (c.code - 96)
                        } else {
                            (c.code - 38)
                        }
                        found = true
                        break
                    }
                }
                if (found)
                    break
            }
            index += 3
        }

        return totalSum
    }

    val testInput = "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
            "PmmdzqPrVvPwwTWBwg\n" +
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
            "ttgJtRGJQctTZtZT\n" +
            "CrZsJsPPZsGzwwsLwLmpwMDw"

    println(part1(testInput.split("\n")))
    println(part2(testInput.split("\n")))

    val input = readInput("03")
    println(part1(input))
    println(part2(input))
}
