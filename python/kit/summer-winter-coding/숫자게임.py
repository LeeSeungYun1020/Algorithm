def solution(A, B):
    A.sort()
    B.sort()
    ans = 0
    idx = 0
    for b in B:
        if A[idx] < b:
            ans += 1
            idx += 1
    return ans


print(solution([5, 1, 3, 7], [2, 2, 6, 8]))
print(solution([2, 2, 2, 2], [1, 1, 1, 1]))
