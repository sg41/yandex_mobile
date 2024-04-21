fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val weights = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()

    var trips = 0
    var left = 0
    var right = n - 1
    var possible = true

    // Pair heaviest with lightest while possible
    while (left <= right) {
        if (weights[left] + weights[right] <= k) {
            right--  // Lightest taken with heaviest
        } else if (weights[left] > k) {
            possible = false
            break
        }
        left++      // Heaviest always requires a trip 
        trips++
    }

    println(if (possible) trips else "Impossible")  // Check if all watermelons can be carried
}