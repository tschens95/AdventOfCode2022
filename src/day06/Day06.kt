package day06

import readText

fun main() {

    fun solvePuzzle(input: String, i: Int): Int {
        var marker = ""
        var count = 0
        for (c in input) {
            if (c in marker) {
                val index = marker.indexOf(c)
                marker = marker.substring(index + 1, marker.length) + c
            } else {
                marker += c
            }
            count++
            if (marker.length == i) {
                break
            }
        }
        println(marker)
        return count
    }

    fun part1(input: String): Int {
        return solvePuzzle(input, 4)
    }

    fun part2(input: String): Int {
        return solvePuzzle(input, 14)
    }

    val testInput = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"

    println(part1(testInput))
    println(part2(testInput))

    val input = readText("06")
    println("Part1:")
    println(part1(input))
    println("Part2:")
    println(part2(input))
}