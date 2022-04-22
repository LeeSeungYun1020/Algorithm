T = int(input())

for test_case in range(1, T + 1):
    moveTime, areaN = map(int, input().split())
    moveA = list(map(int, input().split()))
    moveB = list(map(int, input().split()))

    posA = [0, 0]
    posB = [9, 9]
    board = [[[] for _ in range(10)] for _ in range(10)]
    area = [ 0 for _ in range(areaN)]

    for areaI in range(areaN):
        # x, y, 충전 범위, 처리량
        x, y, C, P = map(int, input().split())
        x -= 1
        y -= 1
        area[areaI] = P
        for i in range(10):
            for j in range(10):
                if 0 <= i < 10 and 0 <= j < 10 and abs(x - i) + abs(y - j) <= C:
                    board[j][i] += [areaI]

    bestMove = [0 for _ in range(moveTime + 1)]
    for t in range(moveTime + 1):
        targetA = board[posA[0]][posA[1]]
        targetB = board[posB[0]][posB[1]]
        #areaTarget에서 구할 수 있음
        # a 하나 b 하나씩 고르고 max 구해야함

        if len(targetA) == 0 and len(targetB) == 0:
            bestMove[t] = 0
        elif len(targetA) == 0:
            bMax = 0
            for target in targetB:
                bMax = max(bMax, area[target])
            bestMove[t] = bMax
        elif len(targetB) == 0:
            aMax = 0
            for target in targetA:
                aMax = max(aMax, area[target])
            bestMove[t] = aMax
        else:
            sMax = 0
            for at in targetA:
                for bt in targetB:
                    if at == bt:
                        sMax = max(sMax, area[at])
                    else:
                        sMax = max(sMax, area[at] + area[bt])
            bestMove[t] = sMax

        if t != moveTime:
            if moveA[t] == 1:
                posA[0] -= 1
            elif moveA[t] == 2:
                posA[1] += 1
            elif moveA[t] == 3:
                posA[0] += 1
            elif moveA[t] == 4:
                posA[1] -= 1

            if moveB[t] == 1:
                posB[0] -= 1
            elif moveB[t] == 2:
                posB[1] += 1
            elif moveB[t] == 3:
                posB[0] += 1
            elif moveB[t] == 4:
                posB[1] -= 1

    print(f"#{test_case} {sum(bestMove)}")
