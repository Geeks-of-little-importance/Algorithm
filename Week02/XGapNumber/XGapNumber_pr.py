def solution(x, n):
    add = 1 if x > 0 else -1
    return [i for i in range(x, x * n + add, x)] if x != 0 else [0] * n

def solution2(x, n):
    return [i * x + x for i in range(n)]
