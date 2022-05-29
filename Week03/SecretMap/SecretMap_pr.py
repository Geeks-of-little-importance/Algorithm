def solution(n, arr1, arr2):
    answer = []
    for idx in range(n):
        # 비트 연산자 사용
        # zfill : 앞에 0을 길이에 맞춰 추가, rjust : 앞에 공백을 길이에 맞춰 추가
        secret = bin(arr1[idx] | arr2[idx])[2:].replace('0', ' ').replace('1', '#').rjust(n)
        answer.append(secret)
        
    return answer
