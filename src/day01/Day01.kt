fun main() {
    fun part1(input: String): Int {
        val elves = input.split("\r\n\r\n")
        val mapElveToCalories = elves.map { it.split("\r\n").sumOf { ele -> Integer.parseInt(ele) } }
        return mapElveToCalories.max()
    }

    fun part2(input: String): Int {
        val elves = input.split("\r\n\r\n")
        val mapElveToCalories = elves.map { it.split("\r\n").sumOf { ele -> Integer.parseInt(ele) } }
        val mutableList = mapElveToCalories.toMutableList()
        var tempSum = 0
        for (i in 0..2) {
            val currMax = mutableList.max()
            tempSum += currMax
            mutableList.remove(currMax)
        }
        return tempSum
    }

    val input = readText("01")
    println(part1(input))
    println(part2(input))
}
