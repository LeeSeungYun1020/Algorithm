from collections import deque

N, M, R = map(int, input().split(" "))
board = [[] for i in range(N)]
for i in range(M):
    a, b = map(int, input().split(" "))
    board[a-1].append(b-1)
    board[b-1].append(a-1)

for i in range(N):
    board[i].sort()

visited = [False for i in range(N)]
deq = deque()
deq.append(R-1)
visited[R-1] = True
order = [0 for i in range(N)]
order[R-1] = 1
count = 2

while deq:
    item = deq.popleft()
    for i in board[item]:
        if not visited[i]:
            visited[i] = True
            deq.append(i)
            order[i] = count
            count += 1

for i in range(N):
    print(order[i])

