package day07

import readInput

fun main() {

    val totalSize = 70000000
    val requiredSpace = 30000000
    var mapDirectoryToSizeLimited = listOf<Int>()
    var mapDirectoryToSize = listOf<Int>()
    val root = Directory("/")

    fun findDirectoriesWithSize(iterateDirectory: Directory, maxSize: Int) {
        if (iterateDirectory.getDirectorySize() <= maxSize) {
            mapDirectoryToSizeLimited = mapDirectoryToSizeLimited.plus(iterateDirectory.getDirectorySize())
        }
        if (iterateDirectory.subDirectories.isNotEmpty()) {
            for (d in iterateDirectory.subDirectories) {
                findDirectoriesWithSize(d, maxSize)
            }
        }
    }

    fun fillMapDirectoryToSize(iterateDirectory: Directory) {
        mapDirectoryToSize = mapDirectoryToSize.plus(iterateDirectory.getDirectorySize())
        if (iterateDirectory.subDirectories.isNotEmpty()) {
            for (d in iterateDirectory.subDirectories) {
                fillMapDirectoryToSize(d)
            }
        }
    }

    fun solvePuzzle(input: List<String>) {
        var currentDirectory = root
        val iterator = input.iterator()
        while (iterator.hasNext()) {
            val line = iterator.next()
            if (line.startsWith("$")) {
                val command = line.split("$")[1]
                if (command.trim().contains("cd") && command.split(" ")[2] != "..") {
                    // read in directory name
                    val directoryName = command.split(" ")[2]
                    if (directoryName != "/") {
                        currentDirectory =
                            currentDirectory.subDirectories.find { it.name == directoryName } ?: throw RuntimeException("ERROR 1")
                    }
                } else if (command.trim().contains("cd") && command.split(" ")[2] == "..") {
                    currentDirectory =
                        currentDirectory.parentDirectory ?: throw RuntimeException("ERROR 2")
                } else if (command.trim().contains("ls")){
                    // read in new directories and files
                    continue
                }
            } else {
                // we are now reading in files and subdirectories
                if (line.startsWith("dir")) {
                    currentDirectory.addSubdirectory(line.split(" ")[1])
                } else if (line[0].isDigit()) {
                    val size = line.split(" ")[0].toInt()
                    val filename =  line.split(" ")[1]
                    currentDirectory.addFile(filename, size)
                }
            }
        }
    }

    fun part1(input: List<String>): Int {
        solvePuzzle(input)
        findDirectoriesWithSize(root, 100000)
        return mapDirectoryToSizeLimited.sum()
    }

    fun part2(input: List<String>): Int {
        solvePuzzle(input)
        fillMapDirectoryToSize(root)
        mapDirectoryToSize = mapDirectoryToSize.sorted()
        val requiredFreeSpace = requiredSpace - (totalSize - root.getDirectorySize())
        return mapDirectoryToSize.find { it >= requiredFreeSpace } ?: throw RuntimeException("ERROR 3")
    }

    val testInput =
            "\$ cd /\n" +
            "\$ ls\n" +
            "dir a\n" +
            "14848514 b.txt\n" +
            "8504156 c.dat\n" +
            "dir d\n" +
            "\$ cd a\n" +
            "\$ ls\n" +
            "dir e\n" +
            "29116 f\n" +
            "2557 g\n" +
            "62596 h.lst\n" +
            "\$ cd e\n" +
            "\$ ls\n" +
            "584 i\n" +
            "\$ cd ..\n" +
            "\$ cd ..\n" +
            "\$ cd d\n" +
            "\$ ls\n" +
            "4060174 j\n" +
            "8033020 d.log\n" +
            "5626152 d.ext\n" +
            "7214296 k"

//    println(part1(testInput.split("\n")))
//    println(part2(testInput.split("\n")))

    val input = readInput("07")
    println("Part1:")
    println(part1(input))
    println("Part2:")
    println(part2(input))
}