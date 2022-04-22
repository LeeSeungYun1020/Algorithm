T = int(input())
for test_case in range(1, T + 1):
    n, k = map(int, input().split())
    numbers = input()
    length = n // 4
    numSet = set()
    for i in range(len(numbers)):
        subNum = numbers[i:i + length]
        if len(subNum) < length:
            subNum += numbers[:length - len(subNum)]
        numSet.add(int(subNum, 16))
    # print(sorted(list(numSet), reverse=True))
    print(f"#{test_case} {sorted(list(numSet), reverse=True)[k - 1]}")
