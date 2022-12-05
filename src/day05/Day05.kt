package day05

import readText

fun main() {

    val crateMap = mutableMapOf<Int, MutableList<String>>()

    fun initMap(length: Int) {
        for(i in 0 until length) {
            crateMap[i] = mutableListOf()
        }
    }

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
        val length = lines[lines.size -1].split("   ").map { it.trim().toInt() }.last()
        initMap(length)
        for (s in lines) {
            var i = 0
            var column = 0
            while (column < length) {
                crateMap[column]!!.add(s.substring(i+1,i+2))
                i+=4
                column+=1
            }
//            val crate1 = s.substring(1..2)
//            val crate2 = s.substring(5..6)
//            val crate3 = s.substring(9..10)
//            val crate4 = s.substring(13..14)
//            val crate5 = s.substring(17..18)
//            val crate6 = s.substring(21..22)
//            val crate7 = s.substring(25..26)
//            val crate8 = s.substring(29..30)
//            val crate9 = s.substring(33..34)
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