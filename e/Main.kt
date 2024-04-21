fun solve(s: String, l: Int, r: Int): String {
    val n = s.length
    val dp = IntArray(n + 1) { -1 }
    val prev = IntArray(n + 1) { -1 }
    dp[0] = 0

    for (i in 1..n) {
        val charIdx = mutableMapOf<Char, Int>()
        for (j in maxOf(0, i - r) until i - l + 1) {
            charIdx[s[j]] = j
            val profit = s[i - 1].toInt() - charIdx.values.minOrNull()!!.toInt() 
            if (dp[j] + profit > dp[i]) {
                dp[i] = dp[j] + profit
                prev[i] = j
            }
        }
    }

    if (dp[n] == -1) return "NO SOLUTION"

    val words = mutableListOf<String>()
    var i = n
    while (i > 0) {
        words.add(s.substring(prev[i], i))
        i = prev[i]
    }
    words.reverse()

    return buildString {
        appendLine(dp[n])
        appendLine(words.size)
        words.forEach { appendLine(it) }
    }
}
fun main() {
    val (n, l, r) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!
    println(solve(s, l, r))
}