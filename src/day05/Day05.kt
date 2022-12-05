package day05

import readText

fun main() {

    val crateMap = mutableMapOf<Int, List<String>>()

    // the list contains (crates, rearrangement commands), the last line of crates are the numbers of the crate
    fun part1(input: List<String>) : Int {

        val crates = input[0]
        val commands = input[1]
        val commandList = commands.split("\n").map {
            val parts = it.split(" ")
            val number = parts[1].toInt()
            val from = parts[3].toInt()
            val to = parts[5].toInt()
            Command(number, from, to)
        }

        val lines = crates.split("\n")
        val length = lines[0].length
        for (s in lines) {

        }

        return 0
    }

    fun part2(input: List<String>) : Int {
        return 0
    }

    val testInput =
            "    [D]    \n" +
            "[N] [C]    \n" +
            "[Z] [M] [P]\n" +
            " 1   2   3 \n" +
            "\n" +
            "move 1 from 2 to 1\n" +
            "move 3 from 1 to 3\n" +
            "move 2 from 2 to 1\n" +
            "move 1 from 1 to 2"

    println(part1(testInput.split("\n\n")))
    println(part2(testInput.split("\n\n")))

    val input = readText("05").split("\n\n")
    println(part1(input))
    println(part2(input))
}

data class Command(val number: Int, val crateFrom: Int, val crateTo: Int)