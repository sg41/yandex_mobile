fun main() {
    val path = readLine()!!

    // Store visited coordinates and their visit count
    val visited = mutableMapOf<Pair<Int, Int>, Int>()
    var x = 0
    var y = 0
    visited[Pair(x, y)] = 1 // Initial position visited once

    // Iterate over the path and update visit counts
    for (direction in path) {
        when (direction) {
            'U' -> y++
            'R' -> x++
            'D' -> y--
            'L' -> x--
        }
        val currentPos = Pair(x, y)
        visited[currentPos] = visited.getOrDefault(currentPos, 0) + 1
    }

    // Count developers praised more than once
    val multiplePraises = visited.count { it.value > 1 }
    println(multiplePraises)
}