def solution(sizes):
    sizes = [sorted(namecard) for namecard in sizes]
    w, h = list(zip(*sizes))
    answer = max(w) * max(h)
    return answer
