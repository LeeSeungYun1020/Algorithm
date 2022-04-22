T = int(input())
for test_case in range(1, T + 1):
    rotateK = int(input())
    # S = 1 N = 0
    magnet = [list(map(int, input().split())) for _ in range(4)]
    position = [0, 0, 0, 0]
    for r in range(rotateK):
        magN, direction = map(int, input().split())
        nPosition = position.copy()

        left = magnet[magN - 1][(position[magN - 1] - 2) % 8]
        leftDirection = -direction
        for i in range(magN-2, -1, -1):
            right = magnet[i][(position[i] + 2) % 8]
            if left != right:
                left = magnet[i][(position[i] - 2) % 8]
                nPosition[i] = (position[i] - leftDirection) % 8
                leftDirection = -leftDirection
            else:
                break

        right = magnet[magN - 1][(position[magN - 1] + 2) % 8]
        rightDirection = -direction
        for i in range(magN, 4):
            left = magnet[i][(position[i] - 2) % 8]
            if left != right:
                right = magnet[i][(position[i] + 2) % 8]
                nPosition[i] = (position[i] - rightDirection) % 8
                rightDirection = -rightDirection
            else:
                break

        nPosition[magN - 1] = (position[magN - 1] - direction) % 8
        position = nPosition

    # S면 각 1, 2, 4, 8점
    sum = 0
    point = 1
    for i in range(4):
        if magnet[i][position[i]] == 1:
            sum += point
        point *= 2
    print(f"#{test_case} {sum}")