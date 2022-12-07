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
        return this.files.values.sum() + this.subDirectories.sumOf { it.getDirectorySize() }
    }

    fun addFile(filename: String, size: Int) {
        this.files = this.files.plus((filename to size))
    }
}