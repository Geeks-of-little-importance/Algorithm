def solution(s):
    num = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    for idx, n in enumerate(num):
        s = s.replace(n, str(idx))
    return int(s)
