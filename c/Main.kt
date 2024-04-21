fun main() {
    val n = readLine()!!.toInt()
    val words = List(n) { readLine()!! }

    // Custom comparator to prioritize vowel count and then length
    val comparator = compareByDescending<String> { it.count { c -> c in "aeiou" } }
        .thenBy { it.length }

    val sortedWords = words.sortedWith(comparator)
    sortedWords.forEach { println(it) }
}