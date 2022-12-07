package day07

class Directory(val name: String) {
    var parentDirectory: Directory? = null
    var files: Map<String, Int> = emptyMap()
    var subDirectories: Collection<Directory> = mutableListOf()

    fun addSubdirectory(directoryName: String) {
        val newDirectory = Directory(directoryName)
        newDirectory.parentDirectory = this
        this.subDirectories = this.subDirectories.plus(newDirectory)
    }

    fun getDirectorySize(): Int {
        val fileSize = this.files.values.sum()
        val recursiveFileSize = this.subDirectories.sumOf { it.getDirectorySize() }
        return fileSize + recursiveFileSize
    }

    fun addFile(filename: String, size: Int) {
        this.files = this.files.plus((filename to size))
    }
}