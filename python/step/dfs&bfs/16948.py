from collections import deque

n = int(input())
r1, c1, r2, c2 = map(int, input().rstrip().split())

move = [(-2, -1), (-2, 1), (0, -2), (0, 2), (2, -1), (2, 1)]
visited = [[False for _ in range(n)] for _ in range(n)]

visited[r1][c1] = True
q = deque()
q.append(((r1, c1), 0))
while len(q) != 0:
    now = q.popleft()
    x = now[0][0]
    y = now[0][1]
    count = now[1]
    if x == r2 and y == c2:
        print(count)
        exit()

    for mx, my in move:
        cx, cy = x + mx, y + my
        if 0 <= cx < n and 0 <= cy < n and not visited[cx][cy]:
            visited[cx][cy] = True
            q.append(((cx, cy), count + 1))

print(-1)
