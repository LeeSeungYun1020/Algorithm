def solution(n, lost, reserve):
    answer = 0

    for i in lost:
        if i in reserve:
            reserve.remove(i)
            lost.remove(i)

    for i in range(1, n + 1):
        # 잃어버린 경우
        if i in lost:
            if i - 1 in reserve:
                answer += 1
                reserve.remove(i - 1)
            elif i in reserve:
                answer += 1
                reserve.remove(i)
            elif i + 1 in reserve:
                answer += 1
                reserve.remove(i + 1)
        # 잃어버리지 않은 경우
        else:
            answer += 1
    return answer