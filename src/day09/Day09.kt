package day09

import kotlin.math.abs

fun main() {

    fun part1(input: List<String>) : Int {
        val positions : MutableSet<Pair<Int, Int>> = mutableSetOf()
        var posH = (0 to 0)
        var posT = posH
        positions.add(posT)
        val commands = input.map { Command(it.split(" ")[0], it.split(" ")[1].toInt()) }
        commands.forEach {
            when (it.direction) {
                "R" ->  for (i in 0 until it.value) {
                    // if not adjacent and on different y level, H above T
                    if (abs(posH.first - posT.first) < 1 && abs (posH.second - posT.second) < 1) {
                        posH = posH.copy(first = posH.first + 1)
                    } else {
                        posH = posH.copy(first = posH.first + 1)
                        posT = if (abs(posH.first - posT.first) > 1 && posH.second - posT.second > 0) {
                            posT.copy(posT.first + 1, posT.second + 1)
                        } else if (abs(posH.first - posT.first) > 1 && posH.second - posT.second < 0) {
                            posT.copy(posT.first + 1, posT.second - 1)
                        } else {
                            posT.copy(posT.first + 1)
                        }
                        positions.add(posT)
                    }
                }
                "L" -> for (i in 0 until it.value) {
                    if (abs(posH.first - posT.first) < 1 && abs (posH.second - posT.second) < 1) {
                        posH = posH.copy(first = posH.first - 1)
                    } else {
                        posH = posH.copy(first = posH.first - 1)
                        posT = if (abs(posH.first - posT.first) > 1 && posH.second - posT.second > 0) {
                            posT.copy(posT.first - 1, posT.second + 1)
                        } else if (abs(posH.first - posT.first) > 1 && posH.second - posT.second < 0) {
                            posT.copy(posT.first - 1, posT.second - 1)
                        } else {
                            posT.copy(posT.first - 1)
                        }
                        positions.add(posT)
                    }
                }
                "U" -> for (i in 0 until it.value) {
                    if (abs(posH.first - posT.first) < 1 && abs (posH.second - posT.second) < 1) {
                        posH = posH.copy(second = posH.second + 1)
                    } else {
                        posH = posH.copy(second = posH.second + 1)
                        posT = if (posH.first - posT.first > 0 && abs(posH.second - posT.second) > 1) {
                            posT.copy(posT.first + 1, posT.second + 1)
                        } else if (posH.first - posT.first < 0 && abs(posH.second - posT.second) > 1) {
                            posT.copy(posT.first - 1, posT.second + 1)
                        } else {
                            posT.copy(posT.second + 1)
                        }
                        positions.add(posT)
                    }
                }
                "D" -> for (i in 0 until it.value) {
                    if (abs(posH.first - posT.first) < 1 && abs (posH.second - posT.second) < 1) {
                        posH = posH.copy(second = posH.second - 1)
                    } else {
                        posH = posH.copy(second = posH.second - 1)
                        posT = if (posH.first - posT.first > 0 && abs(posH.second - posT.second) > 1) {
                            posT.copy(posT.first + 1, posT.second - 1)
                        } else if (posH.first - posT.first < 0 && abs(posH.second - posT.second) > 1) {
                            posT.copy(posT.first - 1, posT.second - 1)
                        } else {
                            posT.copy(posT.second + 1)
                        }
                        positions.add(posT)
                    }
                }
            }
        }
        positions.also { print(it) }
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
}