def jinbob(n, q):
    base = ''

    while n > 0:
        n, mod = divmod(n, q)
        base = str(mod) + base

    return base

def solution(n):
    sam = jinbob(n, 3)[::-1]
    return int(sam, 3)
