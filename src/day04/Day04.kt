
fun main() {

    // check if r1 in r2 or r2 in r1
    fun contains(r1: IntRange, r2: IntRange) : Boolean {
        return (r2.first <= r1.first && r1.last <= r2.last)
                || (r1.first <= r2.first && r2.last <= r1.last)
    }

    // check borders of ranges for overlapping
    fun overlap(r1: IntRange, r2: IntRange) : Boolean {
        return if (r2.first > r1.first) {
            r2.first <= r1.last
        } else if (r2.first < r1.first) {
            r1.first <= r2.last
        } else {
            true
        }
    }

    fun part1(input: List<String>) : Int {
        var count = 0
        for(line in input) {
            val ranges = line.split(",")
            val range1 = ranges[0]
            val range2 = ranges[1]

            val r1b = range1.split("-")
            val r2b = range2.split("-")
            if (contains(IntRange(r1b[0].toInt(), r1b[1].toInt()), IntRange(r2b[0].toInt(), r2b[1].toInt()))) {
                count++
            }
        }
        return count
    }

    fun part2(input: List<String>) : Int {
        var count = 0
        for(line in input) {
            val ranges = line.split(",")
            val range1 = ranges[0]
            val range2 = ranges[1]

            val r1b = range1.split("-")
            val r2b = range2.split("-")
            if (overlap(IntRange(r1b[0].toInt(), r1b[1].toInt()), IntRange(r2b[0].toInt(), r2b[1].toInt()))) {
                count++
            }
        }
        return count
    }

    val testInput = "2-4,6-8\n" +
            "2-3,4-5\n" +
            "5-7,7-9\n" +
            "2-8,3-7\n" +
            "6-6,4-6\n" +
            "2-6,4-8"

    println(part1(testInput.split("\n")))
    println(part2(testInput.split("\n")))

    val input = readInput("04")
    println(part1(input))
    println(part2(input))
}