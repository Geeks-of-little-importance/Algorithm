def calc_dist(hand, lh, rh, num):  # 거리가 같다면 왼손잡이, 오른손잡이 구분
    # 처음에는 왼손이나 오른손이 2,5,8,11에 있다고 생각 못함 -> 추가 조건을 줬지만 예외가 있었다..!
    # lh = abs((lh + 1) - num) // 3 if lh not in [2, 5, 8, 11] else abs(lh - num) // 3
    # rh = abs((rh - 1) - num) // 3 if rh not in [2, 5, 8, 11] else abs(rh - num) // 3
    # 다른 방식을 생각해내어 적용
    lh = sum(divmod(abs(lh - num), 3))
    rh = sum(divmod(abs(rh - num), 3))

    if lh < rh:
        return True
    elif rh < lh:
        return False
    else:
        return True if hand == 'left' else False

def solution(numbers, hand):
    left_hand, right_hand = 10, 12
    result = ''
    for num in numbers:
        if num == 0:
            num = 11

        if num in [1, 4, 7]:
            left_hand = num
            result += 'L'
        elif num in [3, 6, 9]:
            right_hand = num
            result += 'R'
        else:
            if calc_dist(hand, left_hand, right_hand, num):
                left_hand = num
                result += 'L'
            else:
                right_hand = num
                result += 'R'
    return result
