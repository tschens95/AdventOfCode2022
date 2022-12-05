package day05

import readText

fun main() {

    val crateMap = mutableMapOf<Int, MutableList<String>>()

    fun initMap(length: Int) {
        for(i in 0 until length) {
            crateMap[i] = mutableListOf()
        }
    }

    fun moveCrate(command: Command, reversePart2: Boolean) {
        val cratesFrom = crateMap[command.crateFrom - 1] ?: throw RuntimeException("null")
        val x = cratesFrom.size
        val cratesList = cratesFrom.subList(x - command.number, x)
        if (!reversePart2) cratesList.reverse()
        crateMap[command.crateFrom - 1] = cratesFrom.subList(0, x - command.number)
        crateMap[command.crateTo - 1] = crateMap[command.crateTo - 1]!!.plus(cratesList).toMutableList()
    }

    fun solvePuzzle(input: List<String>, reversePart2: Boolean): String {
        val crates = input[0]
        val commands = input[1]
        val commandList = commands.split("\n").map {
            val parts = it.split(" ")
            val number = parts[1].toInt()
            val from = parts[3].toInt()
            val to = parts[5].trim().toInt()
            Command(number, from, to)
        }

        val lines = crates.split("\n")
        val length = lines[lines.size - 1].split("   ").map { it.trim().toInt() }.last()
        initMap(length)
        var rowCount = 0
        while (rowCount < lines.size - 1) {
            val s = lines[rowCount]
            var i = 0
            var column = 0
            while (column < length) {
                val element = s.substring(i + 1, i + 2)
                if (element.isNotBlank()) {
                    crateMap[column]!!.add(element)
                }
                i += 4
                column += 1
            }
            rowCount += 1
        }
        for (s in crateMap.values) {
            s.reverse()
        }
        for (c in commandList) {
            moveCrate(c, reversePart2)
        }
        var resultString = ""
        for (a in crateMap.values) {
            resultString += a.last()
        }

        return resultString
    }

    // the list contains (crates, rearrangement commands), the last line of crates are the numbers of the crate
    fun part1(input: List<String>) : String {
        return solvePuzzle(input, false)
    }

    fun part2(input: List<String>) : String {
        return solvePuzzle(input, true)
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

    val input = readText("05").split("\r\n\r\n")
    println("Part1:")
    println(part1(input))
    println("Part2:")
    println(part2(input))
}

data class Command(val number: Int, val crateFrom: Int, val crateTo: Int)