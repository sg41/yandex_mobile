import kotlin.math.abs

fun maxBurles(s: String, l: Int, r: Int, n: Int): Pair<Int, List<String>> {
    // val n = s.length
    val dp = IntArray(n + 1)
    val prev = IntArray(n + 1) 

    for (i in 1..n) {
        for (j in maxOf(0, i - r)..minOf(i - l, i - 1)) {
            val substring = s.substring(j, i)
            val minOrder = substring.minOf { it.code }
            val maxOrder = substring.maxOf { it.code }
            val burles = dp[j] + (maxOrder - minOrder)
            if (burles > dp[i]) {
                dp[i] = burles
                prev[i] = j
            }
        }
    }

    // Восстановление решения
    if (dp[n] == 0) {
        return 0 to emptyList() // NO SOLUTION
    }

    val result = mutableListOf<String>()
    var i = n
    while (i > 0) {
        val j = prev[i]
        if (abs(j-i) < l || abs(i-j) > r) {
            return 0 to emptyList() // NO SOLUTION
        }
        result.add(s.substring(j, i))
        i = j
    }
    result.reverse()

    return dp[n] to result
}

fun main() {
    val (n, l, r) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!

    val (maxBurles, words) = maxBurles(s, l, r, n)
    if (words.isNotEmpty()) {
        println(maxBurles)
        println(words.size)
        println(words.joinToString("\n"))
    } else {
        println("NO SOLUTION")
    }
}