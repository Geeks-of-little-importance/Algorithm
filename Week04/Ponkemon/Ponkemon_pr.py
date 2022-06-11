def solution(nums):
    # 이해를 잘 못해서 시간이 조금 걸렸던 문제, 하지만 코드 자체는 간결하다
    return min(len(list(set(nums))), len(nums) // 2)
