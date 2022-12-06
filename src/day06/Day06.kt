package day06

import readText

fun main() {

    fun part1(input: String): Int {
        var fourMarker = ""
        var count = 0
        for (c in input) {
            if (c in fourMarker) {
                val index = fourMarker.indexOf(c)
                fourMarker = fourMarker.substring(index+1, fourMarker.length) + c
            } else {
                fourMarker += c
            }
            count++
            if (fourMarker.length == 4) {
                break
            }
        }
        println(fourMarker)
        return count
    }

    fun part2(input: String): Int {
        var marker = ""
        var count = 0
        for (c in input) {
            if (c in marker) {
                val index = marker.indexOf(c)
                marker = marker.substring(index+1, marker.length) + c
            } else {
                marker += c
            }
            count++
            if (marker.length == 14) {
                break
            }
        }
        println(marker)
        return count
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