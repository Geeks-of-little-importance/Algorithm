def solution(sizes):
    sizes = [sorted(namecard) for namecard in sizes]
    w, h = list(zip(*sizes))
    answer = max(w) * max(h)
    return answer

# 1
def solution2(sizes):
    return max(max(x) for x in sizes) * max(min(x) for x in sizes)
