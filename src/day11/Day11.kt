package day11

import readInput
import readText

fun main() {

    val inspectingMap = mutableListOf<Int>()

    fun mapToMonkey(it: String): Monkey {
        val lines = it.split("\n")
        val operator = lines[2].split("=")[1].trim().substring(4, 5)
        val operand = lines[2].split(operator)[1].trim()

        val operation = if (operand == "old") {
            when (operator) {
                "+" -> { i: Int -> i + i }
                "*" -> { i: Int -> i * i }
                else -> throw RuntimeException("Error")
            }
        } else {
            val parsedOperand = operand.toInt()
            when (operator) {
                "+" -> { i: Int -> i + parsedOperand }
                "*" -> { i: Int -> i * parsedOperand }
                else -> throw RuntimeException("Error")
            }
        }

        val test = lines[3].split("divisible by")[1].trim().toInt()

        val trueMap = lines[4].trim().split(" ")[5].toInt()
        val falseMap = lines[5].trim().split(" ")[5].toInt()

        val items = lines[1].trim().split(":")[1].trim().split(",")
            .map { it.trim().toInt() }.toMutableList()

        return Monkey(
            id = lines[0].substring(7, 8).toInt(),
            items = items,
            operation = operation,
            test = { i: Int -> i.mod(test) == 0 },
            targetMonkey = { b: Boolean -> if (b) trueMap else falseMap }
        )
    }

    fun part1(input: List<String>): Int {
        val monkeys = input.map { mapToMonkey(it) }
        // init counting map
        for (i in monkeys.indices) {
            inspectingMap.add(i, 0)
        }
        for (i in 1..20) {
            for (m in monkeys) {
                val itemIterator = m.items.iterator()
                while (itemIterator.hasNext()) {
                    inspectingMap[m.id]++
                    val item = itemIterator.next()
                    val newItem = m.operation(item)
                    val boredItem = newItem.div(3)
                    val test = m.test(boredItem)
                    monkeys[m.targetMonkey(test)].items.add(boredItem)
                    itemIterator.remove()
                }
            }
        }
        inspectingMap.sortDescending()
        println(inspectingMap)

        return inspectingMap[0] * inspectingMap[1]
    }

    val testInput =
        "Monkey 0:\n" +
                "  Starting items: 79, 98\n" +
                "  Operation: new = old * 19\n" +
                "  Test: divisible by 23\n" +
                "    If true: throw to monkey 2\n" +
                "    If false: throw to monkey 3\n" +
                "\n" +
                "Monkey 1:\n" +
                "  Starting items: 54, 65, 75, 74\n" +
                "  Operation: new = old + 6\n" +
                "  Test: divisible by 19\n" +
                "    If true: throw to monkey 2\n" +
                "    If false: throw to monkey 0\n" +
                "\n" +
                "Monkey 2:\n" +
                "  Starting items: 79, 60, 97\n" +
                "  Operation: new = old * old\n" +
                "  Test: divisible by 13\n" +
                "    If true: throw to monkey 1\n" +
                "    If false: throw to monkey 3\n" +
                "\n" +
                "Monkey 3:\n" +
                "  Starting items: 74\n" +
                "  Operation: new = old + 3\n" +
                "  Test: divisible by 17\n" +
                "    If true: throw to monkey 0\n" +
                "    If false: throw to monkey 1"

    println(part1(testInput.split("\n\n")))
    println(part1(readText("11").split("\r\n\r\n")))
}