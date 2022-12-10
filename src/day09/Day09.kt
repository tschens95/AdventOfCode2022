package day09

import readInput
import kotlin.math.abs

fun main() {

    fun adjacent(h: Pair<Int, Int>, t: Pair<Int, Int>): Boolean {
        val xDiff = abs(h.first - t.first)
        val yDiff = abs(h.second - t.second)

        return (xDiff == 0 && yDiff == 0) || (xDiff == 0 && yDiff == 1) || (xDiff == 1 && yDiff == 0)
    }

    fun diagonal(h: Pair<Int, Int>, t: Pair<Int, Int>): Boolean {
        val xDiff = abs(h.first - t.first)
        val yDiff = abs(h.second - t.second)
        return (xDiff == 1 && yDiff == 1)
    }

    fun part1(input: List<String>): Int {
        val positions: MutableSet<Pair<Int, Int>> = mutableSetOf()
        var posH = (0 to 0)
        var posT = posH
        positions.add(posT)
        val commands = input.map { Command(it.split(" ")[0], it.split(" ")[1].toInt()) }
        commands.forEach {
            when (it.direction) {
                "R" -> for (i in 0 until it.value) {
                    posH = posH.copy(first = posH.first + 1)
                    if (!adjacent(posH, posT) && !diagonal(posH, posT)) {
                        posT = posT.copy(posT.first + 1, posH.second)
                        positions.add(posT)
                    }
                }
                "L" -> for (i in 0 until it.value) {
                    posH = posH.copy(first = posH.first - 1)
                    if (!adjacent(posH, posT) && !diagonal(posH, posT)) {
                        posT = posT.copy(posT.first - 1, posH.second)
                        positions.add(posT)
                    }
                }
                "U" -> for (i in 0 until it.value) {
                    posH = posH.copy(second = posH.second + 1)
                    if (!adjacent(posH, posT) && !diagonal(posH, posT)) {
                        posT = posT.copy(posH.first, posT.second + 1)
                        positions.add(posT)
                    }
                }
                "D" -> for (i in 0 until it.value) {
                    posH = posH.copy(second = posH.second - 1)
                    if (!adjacent(posH, posT) && !diagonal(posH, posT)) {
                        posT = posT.copy(posH.first, posT.second - 1)
                        positions.add(posT)
                    }
                }
            }
        }
        return positions.size
    }

    val testInput = "R 4\n" +
            "U 4\n" +
            "L 3\n" +
            "D 1\n" +
            "R 4\n" +
            "D 1\n" +
            "L 5\n" +
            "R 2"

    println(part1(testInput.split("\n")))
    println(part1(readInput("09")))
}