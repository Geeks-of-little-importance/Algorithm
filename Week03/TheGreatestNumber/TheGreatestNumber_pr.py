# 시간 초과
from itertools import permutation
def solution1(numbers):
    # 모든 경우의 수를 확인하여 더하고 그 값을 비교
    all_types = list(permutations(map(str, numbers), len(numbers)))
    add_all_types = list(map(lambda x: eval(''.join(x)), all_types))
    return str(max(add_all_types))
  
def solution(numbers):
    # 문자열 연산의 경우 하나씩 비교함, 최종 숫자가 크더라도 문자열 앞 부터 비교하기 때문에 가능한 정렬
    numbers = sorted(numbers, key=lambda x: str(x) * 4, reverse=True)
    return str(int(''.join(list(map(str, numbers)))))  # 000의 경우

print(solution([6, 10, 2]))
print(solution([3, 30, 34, 5, 9]))
