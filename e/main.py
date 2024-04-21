def max_burles(s: str, l: int, r: int, n: int) -> tuple[int, list[str]]:
  """
  Finds the maximum burles value and the corresponding word divisions for a string.

  Args:
      s: The input string.
      l: The minimum length of a word.
      r: The maximum length of a word.
      n: The length of the string.

  Returns:
      A tuple containing:
          - The maximum burles value.
          - A list of words that achieve the maximum burles value (or an empty list if no solution exists).
  """
  dp = [0] * (n + 1)
  prev = [0] * (n + 1)

  for i in range(1, n + 1):
    for j in range(max(0, i - r), min(i - l, i - 1) + 1):
      substring = s[j:i]
      min_order = min(ord(c) for c in substring)
      max_order = max(ord(c) for c in substring)
      burles = dp[j] + (max_order - min_order)
      if burles > dp[i]:
        dp[i] = burles
        prev[i] = j

  # Reconstruct the solution
  if dp[n] == 0:
    return 0, []  # No solution

  result = []
  i = n
  while i > 0:
    j = prev[i]
    if abs(j - i) < l or abs(i - j) > r:
      return 0, []  # No solution
    result.append(s[j:i])
    i = j
  result.reverse()

  return dp[n], result

def main():
  n, l, r = map(int, input().split())
  s = input()

  max_burles_value, words = max_burles(s, l, r, n)
  if words:
    print(max_burles_value)
    print(len(words))
    print("\n".join(words))
  else:
    print("NO SOLUTION")

if __name__ == "__main__":
  main()