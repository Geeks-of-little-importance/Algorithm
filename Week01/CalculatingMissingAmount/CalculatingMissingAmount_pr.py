def solution(price, money, count):
    total_price = sum([price * i for i in range(1, count + 1)])
    return total_price - money if total_price > money else 0

# 1
def solution2(price, money, count):
    return abs(min(money - sum([price * i for i in range(1, count + 1)]), 0))

# 2
def solution3(price, money, count):
    return max(0, price * (count + 1) * count // 2 - money)

print(solution(3, 20, 4))
