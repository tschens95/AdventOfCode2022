package day11

data class Monkey(
    val id: Int,
    var items: MutableList<Int>,
    val operation: (Int) -> Int,
    val test: (Int) -> Boolean,
    val targetMonkey: (Boolean) -> Int
)
