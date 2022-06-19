def solution(s):
    num = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    # index를 해당 숫자로 보고 replace
    for idx, n in enumerate(num):
        s = s.replace(n, str(idx))
    return int(s)
