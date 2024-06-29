import sys
from collections import deque

(N, M) = map(int, sys.stdin.readline().split(" "))

cls = [[] for _ in range(N)]
counter = [0 for _ in range(N)]
for i in range(M):
  (pre, next) = map(int, sys.stdin.readline().split(" "))
  cls[pre - 1].append(next - 1)
  counter[next - 1] += 1

deq = deque()
dp = [0 for _ in range(N)]
for i in range(N):
  if counter[i] == 0:
    dp[i] = 1
    deq.append(i)

while len(deq) > 0:
  target = deq.popleft()
  for nextTarget in cls[target]:
    dp[nextTarget] = dp[target] + 1
    counter[nextTarget] -= 1
    if counter[nextTarget] == 0:
      deq.append(nextTarget)

print(*dp)
