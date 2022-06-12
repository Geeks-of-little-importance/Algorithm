from collections import Counter
def solution(participant, completion):
    participant = Counter(participant)  # {'mislav': 2, 'stanko': 1, 'ana': 1}
    for com in completion:
        participant[com] -= 1

    for k, v in participant.items():
        if v == 1:
            return k

# Original Code
def solution2(participant,completion):
    d  = {} # 빈 사전을 만들고
    for x in participant :
        # key로 value를 얻어내는 함수가 get이다.
        # get(x,'default값') 딕셔너리에 x가 없을 시 default 값을 출력
        d[x] = d.get(x, 0) + 1
        # 처음 등장하면 1로 만들고, 처음 등장한게 아니면, 원래 있던 value에 1을 더해줌
    for x in completion:
        d[x] -=1
    # 단 한명만 완주하지 못했으므로, 그리고 그게 1명이라고 했으므로
    answer = [k for k, v in d.items() if v >0]
    answer = answer[0]
    return answer
