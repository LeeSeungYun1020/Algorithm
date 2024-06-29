import sys

(N, M) = map(int, sys.stdin.readline().split(" "))
hands = []
for i in range(M):
  (h1, h2) = map(int, sys.stdin.readline().split(" "))
  hands.append([h1, i])
  hands.append([h2, i])

print(sorted(hands)[(N - 1) % (M * 2)][1] + 1)
