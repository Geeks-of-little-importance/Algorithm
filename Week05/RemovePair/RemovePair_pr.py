def solution(s):
    stack = []  # stack에 쌓아가며 체크
    for i in s:
        if stack and stack[-1] == i:
            stack.pop()
            continue
        stack.append(i)
    return 1 if not stack else 0
