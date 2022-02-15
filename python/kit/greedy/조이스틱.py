def solution(name):
    # 알파벳 이동
    change = sum([min(ord(ch) - ord('A'), ord('Z') - ord(ch) + 1) for ch in name])
    answer = change

    # 오른쪽으로 쭉 이동
    count = 0
    for i in range(len(name)):
        if name[i] == 'A':
            count += 1
        else:
            count = 0
    moveRight = len(name) - 1 - count
    moveRight = max(moveRight, 0)
    # 왼쪽으로 쭉 이동
    count = 0
    for i in range(0, -len(name), -1):
        if name[i] == 'A':
            count += 1
        else:
            count = 0
    print(count)
    moveLeft = len(name) - 1 - count
    moveLeft = max(moveLeft, 0)
    # 오른쪽으로 가다 왼쪽으로 이동
    moveRL = len(name) - 1
    for i in range(1, len(name)):
        count = 0
        for j in range(i - 1, i - len(name), -1):
            if name[j] == 'A':
                count += 1
            else:
                count = 0
        moveRL = min(moveRL, i + len(name) - 1 - count)
    # 왼쪽으로 가다 오른쪽으로 이동
    moveLR = len(name) - 1
    for i in range(-1, -len(name), -1):
        count = 0
        for j in range(i, i + len(name)):
            if name[j] == 'A':
                count += 1
            else:
                count = 0
        moveLR = min(moveLR, -i + len(name) - 1 - count)

    # print(change, end=", ")
    # print(moveRight, moveLeft, moveRL, moveLR)
    answer += min(moveRight, moveLeft, moveRL, moveLR)
    return answer
