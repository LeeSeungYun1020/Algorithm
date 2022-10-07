def calcPos(pos, direction):
    # 방향은 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    x = pos[0]
    y = pos[1]
    if direction == 1:
        return [x, y - 1]
    elif direction == 2:
        return [x - 1, y - 1]
    elif direction == 3:
        return [x - 1, y]
    elif direction == 4:
        return [x - 1, y + 1]
    elif direction == 5:
        return [x, y + 1]
    elif direction == 6:
        return [x + 1, y + 1]
    elif direction == 7:
        return [x + 1, y]
    else:
        return [x + 1, y - 1]


# 2. 모든 물고기가 한 칸 이동한다.
# 상어, 물고기 냄새, 격자 범위 밖 이동 불가
# 45도 반시계 회전, 모든 칸에 이동 불가할 경우 이동하지 않는다
# 방향은 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
def moveFishes(fishes, shark, smell):
    n_fishes = [[[] for _ in range(0, 5)] for _ in range(0, 5)]
    for i in range(1, 5):
        for j in range(1, 5):
            for fish in fishes[i][j]:
                is_pass = False
                for rotate in range(0, 8):
                    direction = (fish - rotate + 7) % 8 + 1
                    x, y = calcPos([i, j], direction)
                    if x < 1 or x > 4 or y < 1 or y > 4 or (shark[0] == x and shark[1] == y) or (smell[x][y] > 0):
                        continue
                    else:
                        n_fishes[x][y].append(direction)
                        is_pass = True
                        break
                # 회전 불가
                if not is_pass:
                    n_fishes[i][j].append(fish)
    return n_fishes


def printFishes(fishes):
    for i in range(1, 5):
        for j in range(1, 5):
            print(fishes[i][j], end=" ")
        print()
    print("---")


def main():
    smell = [[0 for _ in range(0, 5)] for _ in range(0, 5)]
    M, S = map(int, input().split(" "))
    fishes = [[[] for _ in range(0, 5)] for _ in range(0, 5)]
    for i in range(0, M):
        fx, fy, d = map(int, input().split(" "))
        fishes[fx][fy].append(d)
    shark = list(map(int, input().split(" ")))

    for turn in range(0, S):
        # 1. 상어가 모든 물고기에 복제 마법을 시전한다.
        copiedFishes = fishes.copy()
        # 2. 물고기 이동
        fishes = moveFishes(fishes, shark, smell)
        # print("물고기 이동")
        # printFishes(fishes)
        # 3. 상어가 연속해서 3칸 이동한다. 상하좌우로 이동, 물고기와 만나면 해당 물고기는 격자에서 제외하고 물고기 냄새를 남김
        mx = -1
        mx_path = 0
        visited = [[False for _ in range(0, 5)] for _ in range(0, 5)]

        def dfs(level, x, y, dead, path):
            nonlocal mx, mx_path, visited
            if level == 3:
                if mx < dead:
                    mx = dead
                    mx_path = path
                elif mx == dead and mx_path > path:
                    mx_path = path
                return
            if 1 <= x - 1 and not visited[x - 1][y]:
                visited[x - 1][y] = True
                dfs(level + 1, x - 1, y, dead + len(fishes[x - 1][y]), path * 10 + 1)
                visited[x - 1][y] = False
            if 1 <= x - 1 and visited[x - 1][y]:
                dfs(level + 1, x - 1, y, dead, path * 10 + 1)

            if 1 <= y - 1 and not visited[x][y - 1]:
                visited[x][y - 1] = True
                dfs(level + 1, x, y - 1, dead + len(fishes[x][y - 1]), path * 10 + 2)
                visited[x][y - 1] = False
            if 1 <= y - 1 and visited[x][y - 1]:
                dfs(level + 1, x, y - 1, dead, path * 10 + 2)

            if x + 1 <= 4 and not visited[x + 1][y]:
                visited[x + 1][y] = True
                dfs(level + 1, x + 1, y, dead + len(fishes[x + 1][y]), path * 10 + 3)
                visited[x + 1][y] = False
            if x + 1 <= 4 and visited[x + 1][y]:
                dfs(level + 1, x + 1, y, dead, path * 10 + 3)

            if y + 1 <= 4 and not visited[x][y + 1]:
                visited[x][y + 1] = True
                dfs(level + 1, x, y + 1, dead + len(fishes[x][y + 1]), path * 10 + 4)
                visited[x][y + 1] = False
            if y + 1 <= 4 and visited[x][y + 1]:
                dfs(level + 1, x, y + 1, dead, path * 10 + 4)

        dfs(0, shark[0], shark[1], 0, 0)
        # print(mx, mx_path)

        move = [mx_path // 100, (mx_path % 100) // 10, mx_path % 10]
        for direction in move:
            x = shark[0]
            y = shark[1]
            if direction == 1:
                x -= 1
            elif direction == 2:
                y -= 1
            elif direction == 3:
                x += 1
            else:
                y += 1
            if len(fishes[x][y]) > 0:
                fishes[x][y] = []
                smell[x][y] = 3
            shark = [x, y]
        # print("상어 이동")
        # printFishes(fishes)

        # 4. 두번 전 연습에서 생긴 물고기 냄새가 사라진다.
        for i in range(1, 5):
            for j in range(1, 5):
                if smell[i][j] > 0:
                    smell[i][j] -= 1

        # 5. 복제 마법이 완료된다.
        for i in range(1, 5):
            for j in range(1, 5):
                fishes[i][j] += copiedFishes[i][j]

        # printFishes(fishes)

    count = 0
    for i in range(1, 5):
        for j in range(1, 5):
            count += len(fishes[i][j])
    print(count)


main()
