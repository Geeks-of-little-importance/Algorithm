def solution(n):  # 규칙성을 찾는 것이 관건인 문제
    value = ''
    while n > 0:
        if n % 3 == 0:
            value = '4' + value
            n = (n // 3) - 1
        else:
            value = str(n % 3) + value
            n = n // 3
    return value
