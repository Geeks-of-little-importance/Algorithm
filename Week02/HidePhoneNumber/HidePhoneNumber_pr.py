def solution(phone_number):
    # 파이썬 인덱싱 사용
    return len(phone_number[:-4]) * "*" + phone_number[-4:]
