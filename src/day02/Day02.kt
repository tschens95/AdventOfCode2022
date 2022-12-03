fun main() {
    val valueMap =
        mapOf("A" to 1, "B" to 2, "C" to 3, "X" to 1, "Y" to 2, "Z" to 3)

    fun part1(input: List<String>): Int {
        var totalSum = 0
        for (r in input) {
            val s = r.split(" ")
            val myShapeValue = valueMap[s[1]]
            val enemyShapeValue = valueMap[s[0]]
            if (myShapeValue != null && enemyShapeValue != null) {
                when (s[1]) {
                    "X" -> when (s[0]) {
                        "A" -> totalSum += myShapeValue + 3
                        "B" -> totalSum += myShapeValue
                        "C" -> totalSum += myShapeValue + 6
                    }
                    "Y" -> when (s[0]) {
                        "A" -> totalSum += myShapeValue + 6
                        "B" -> totalSum += myShapeValue + 3
                        "C" -> totalSum += myShapeValue
                    }
                    "Z" -> when (s[0]) {
                        "A" -> totalSum += myShapeValue
                        "B" -> totalSum += myShapeValue + 6
                        "C" -> totalSum += myShapeValue + 3
                    }
                }
            }
        }
        return totalSum
    }

    fun part2(input: List<String>): Int {
        var totalSum2 = 0
        for (r in input) {
            val s = r.split(" ")
            val enemyShapeValue = valueMap[s[0]]
            if (enemyShapeValue != null) {
                when (s[1]) {
                    "X" -> when (s[0]) {
                        "A" -> totalSum2 += 3
                        "B" -> totalSum2 += 1
                        "C" -> totalSum2 += 2
                    }
                    "Y" -> when (s[0]) {
                        "A" -> totalSum2 += 4
                        "B" -> totalSum2 += 5
                        "C" -> totalSum2 += 6
                    }
                    "Z" -> when (s[0]) {
                        "A" -> totalSum2 += 8
                        "B" -> totalSum2 += 9
                        "C" -> totalSum2 += 7
                    }
                }
            }
        }
        return totalSum2
    }

    val input = readInput("02")
    println(part1(input))
    println(part2(input))
}
