package day10

import readInput

fun main() {

    fun part1(input: List<String>) : Int {
        val commands = input.map {
            val inSplit = it.split(" ")
            if (inSplit.size > 1) {
                Command(it.split(" ")[0], it.split(" ")[1].toInt())
            } else {
                Command(it.split(" ")[0], null)
            }
        }

        val valueList = mutableListOf(1)
        var counter = 0
        var currVal = 1
        for (c in commands) {
            if (c.name == "addx" && c.value != null) {
                valueList.add(currVal)
                counter++
                currVal += c.value
                valueList.add(currVal)
                counter++
            } else if (c.name == "noop") {
                valueList.add(currVal)
                counter++
            }
        }
        val x20 = valueList[19] * 20
        val x60 = valueList[59] * 60
        val x100 = valueList[99] * 100
        val x140 = valueList[139] * 140
        val x180 = valueList[179] * 180
        val x220 = valueList[219] * 220
        println("cycle 20: $x20}")
        println("cycle 60: $x60")
        println("cycle 100: $x100")
        println("cycle 140: $x140")
        println("cycle 180: $x180")
        println("cycle 220: $x220")

        return x20 + x60 + x100 + x140 + x180 + x220
    }

    val testInput = "addx 15\n" +
            "addx -11\n" +
            "addx 6\n" +
            "addx -3\n" +
            "addx 5\n" +
            "addx -1\n" +
            "addx -8\n" +
            "addx 13\n" +
            "addx 4\n" +
            "noop\n" +
            "addx -1\n" +
            "addx 5\n" +
            "addx -1\n" +
            "addx 5\n" +
            "addx -1\n" +
            "addx 5\n" +
            "addx -1\n" +
            "addx 5\n" +
            "addx -1\n" +
            "addx -35\n" +
            "addx 1\n" +
            "addx 24\n" +
            "addx -19\n" +
            "addx 1\n" +
            "addx 16\n" +
            "addx -11\n" +
            "noop\n" +
            "noop\n" +
            "addx 21\n" +
            "addx -15\n" +
            "noop\n" +
            "noop\n" +
            "addx -3\n" +
            "addx 9\n" +
            "addx 1\n" +
            "addx -3\n" +
            "addx 8\n" +
            "addx 1\n" +
            "addx 5\n" +
            "noop\n" +
            "noop\n" +
            "noop\n" +
            "noop\n" +
            "noop\n" +
            "addx -36\n" +
            "noop\n" +
            "addx 1\n" +
            "addx 7\n" +
            "noop\n" +
            "noop\n" +
            "noop\n" +
            "addx 2\n" +
            "addx 6\n" +
            "noop\n" +
            "noop\n" +
            "noop\n" +
            "noop\n" +
            "noop\n" +
            "addx 1\n" +
            "noop\n" +
            "noop\n" +
            "addx 7\n" +
            "addx 1\n" +
            "noop\n" +
            "addx -13\n" +
            "addx 13\n" +
            "addx 7\n" +
            "noop\n" +
            "addx 1\n" +
            "addx -33\n" +
            "noop\n" +
            "noop\n" +
            "noop\n" +
            "addx 2\n" +
            "noop\n" +
            "noop\n" +
            "noop\n" +
            "addx 8\n" +
            "noop\n" +
            "addx -1\n" +
            "addx 2\n" +
            "addx 1\n" +
            "noop\n" +
            "addx 17\n" +
            "addx -9\n" +
            "addx 1\n" +
            "addx 1\n" +
            "addx -3\n" +
            "addx 11\n" +
            "noop\n" +
            "noop\n" +
            "addx 1\n" +
            "noop\n" +
            "addx 1\n" +
            "noop\n" +
            "noop\n" +
            "addx -13\n" +
            "addx -19\n" +
            "addx 1\n" +
            "addx 3\n" +
            "addx 26\n" +
            "addx -30\n" +
            "addx 12\n" +
            "addx -1\n" +
            "addx 3\n" +
            "addx 1\n" +
            "noop\n" +
            "noop\n" +
            "noop\n" +
            "addx -9\n" +
            "addx 18\n" +
            "addx 1\n" +
            "addx 2\n" +
            "noop\n" +
            "noop\n" +
            "addx 9\n" +
            "noop\n" +
            "noop\n" +
            "noop\n" +
            "addx -1\n" +
            "addx 2\n" +
            "addx -37\n" +
            "addx 1\n" +
            "addx 3\n" +
            "noop\n" +
            "addx 15\n" +
            "addx -21\n" +
            "addx 22\n" +
            "addx -6\n" +
            "addx 1\n" +
            "noop\n" +
            "addx 2\n" +
            "addx 1\n" +
            "noop\n" +
            "addx -10\n" +
            "noop\n" +
            "noop\n" +
            "addx 20\n" +
            "addx 1\n" +
            "addx 2\n" +
            "addx 2\n" +
            "addx -6\n" +
            "addx -11\n" +
            "noop\n" +
            "noop\n" +
            "noop"

    println(part1(testInput.split("\n")))
    println(part1(readInput("10")))
}