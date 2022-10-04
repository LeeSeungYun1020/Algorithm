# step1. 물고기의 수가 min인 어항에 물고기 한 마리 넣기
def step1(list):
    minList = [0]
    min = list[0]
    for i in range(1, len(list)):
        if min > list[i]:
            minList = [i]
            min = list[i]
        elif min == list[i]:
            minList.append(i)

    for i in minList:
        list[i] += 1


# step2. 어항을 쌓는다.
def step2(board):
    return [[board[0][0]], [board[0][i] for i in range(1, len(board[0]))]]


# step3. 2개 이상 쌓여 있는 어항을 모두 공중 부양시키고 시계방향으로 90도 회전하여 어항 위에 올려놓는다.
def step3(board):
    while True:
        width, height, cut, floor = cutUp(board)
        if len(floor) >= height:
            rotate = rotate90(cut)
        else:
            break
        board = rotate
        board.append(floor)
    return board


# 공중 부양
def cutUp(board):
    width = len(board[0])
    height = len(board)
    cut = [[board[i][j] for j in range(0, width)] for i in range(0, height)]
    floor = [board[height - 1][j] for j in range(width, len(board[height - 1]))]
    return [width, height, cut, floor]


# 시계방향 90도 회전
def rotate90(board):
    width = len(board[0])
    height = len(board)
    nBoard = [[0 for j in range(0, height)] for i in range(0, width)]
    for i in range(0, width):
        for j in range(0, height):
            nBoard[i][j] = board[height - j - 1][i]
    return nBoard


# step4. 어항에 있는 물고기 수 조절 (현재 -= ((현재 - 비교) // 5))
def step4(board):
    nBoard = [board[i].copy() for i in range(0, len(board))]
    for i in range(0, len(board)):
        for j in range(0, len(board[i])):
            if 0 <= i - 1 and j < len(board[i - 1]):
                diff = board[i][j] - board[i - 1][j]
                if diff > 0:
                    nBoard[i][j] -= diff // 5
                elif diff < 0:
                    nBoard[i][j] += -diff // 5
            if i + 1 < len(board) and j < len(board[i + 1]):
                diff = board[i][j] - board[i + 1][j]
                if diff > 0:
                    nBoard[i][j] -= diff // 5
                elif diff < 0:
                    nBoard[i][j] += -diff // 5
            if 0 <= j - 1:
                diff = board[i][j] - board[i][j - 1]
                if diff > 0:
                    nBoard[i][j] -= diff // 5
                elif diff < 0:
                    nBoard[i][j] += -diff // 5
            if j + 1 < len(board[i]):
                diff = board[i][j] - board[i][j + 1]
                if diff > 0:
                    nBoard[i][j] -= diff // 5
                elif diff < 0:
                    nBoard[i][j] += -diff // 5
    return nBoard


# 어항을 바닥에 일렬로 놓는다. 가장 왼쪽에 있는 어항부터 아래에 있는 어항부터 가장 위에 있는 어항까지 순서대로 바닥에 놓는다.
def step5(board):
    width, height, cut, floor = cutUp(board)
    rotate = rotate90(cut)
    nBoard = [[]]
    for list in rotate:
        nBoard[0] += list
    nBoard[0] += floor
    return nBoard


# 왼쪽 N/2개를 공중 부양시켜 전체를 시계 방향으로 180도 회전 시킨 다음, 오른쪽 N/2개 위에 놓는다.
def step6(board):
    nBoard = [[board[i][j] for j in range(0, len(board[0]) // 2)] for i in range(0, len(board))]
    oBoard = [[board[i][j] for j in range(len(board[0]) // 2, len(board[0]))] for i in range(0, len(board))]
    nBoard = rotate90(nBoard)
    nBoard = rotate90(nBoard)
    return nBoard + oBoard


# 물고기가 가장 많이 든 어항과 가장 적게 든 어항의 물고기 수 차이가 K 이하가 되었는가?
def check(board, k):
    mn = board[0][0]
    mx = board[0][0]
    for i in range(0, len(board)):
        for j in range(0, len(board[i])):
            if mn > board[i][j]:
                mn = board[i][j]
            if mx < board[i][j]:
                mx = board[i][j]
    return mx - mn <= k


def main():
    n, k = map(int, input().split(" "))
    arr = list(map(int, input().split(" ")))
    board = [arr]
    #print(board)
    answer = 0
    while True:
        if check(board, k):
            break
        #print(board)
        step1(board[0])
        #print(board)
        board = step2(board)
        #print(board)
        board = step3(board)
        #print(board)
        board = step4(board)
        #print(board)
        board = step5(board)
        #print(board)
        board = step6(board)
        #print(board)
        board = step6(board)
        #print(board)
        board = step4(board)
        #print(board)
        board = step5(board)
        #print(board)
        answer += 1
    print(answer)
main()
