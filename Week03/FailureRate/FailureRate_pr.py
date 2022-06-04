def solution(N, stages):
    user_num = len(stages)  # 사용자의 숫자
    stage = []  # stage의 실패율을 저장하는 리스트
    
    for i in range(1, N + 1):
        if user_num != 0:
            stage.append([stages.count(i) / user_num, i])
            user_num -= stages.count(i)
        else:  # zero Division
            stage.append([0, i])
            
    # 결과 값을 sort : lambda를 사용하면 여러 기준으로 정렬 가능
    stage.sort(key=lambda x: (-x[0], x[1]))
    result = list(zip(*stage))
    
    return list(result[1])
