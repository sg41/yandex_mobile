fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }

    val result = if (a + b == c || a + c == b || b + c == a) "YES" else "NO"
    println(result)
}