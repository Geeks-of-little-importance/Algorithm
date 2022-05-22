def solution(numbers):
    check_list = [i for i in range(10)] # [0, ~ 9]

    answer = 0
    for cl in check_list:
        if cl not in numbers:
            answer += cl

    return answer
