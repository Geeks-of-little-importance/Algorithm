from collections import defaultdict
def solution(id_list, report, k):
    singo = defaultdict(list)  # 누가 누구를 신고했는지
    num = defaultdict(int)  # 누가 몇 번 신고당했는지
    result = []  # id_list를 기반으로 유저가 받을 결과 메일 수
    for r in list(set(report)):  # 중복을 제거하기 위한 set 사용
        id, bad = r.split()
        singo[id].append(bad)
        num[bad] += 1

    for i in id_list:
        cnt = 0
        for s in singo[i]:
            if num[s] < k:
                continue
            cnt += 1
        result.append(cnt)

    return result

print(solution(["muzi", "frodo", "apeach", "neo"],["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"], 2))
print(solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3))

# Original Code
def solution(id_list, report, k):
    report = list(set(report))
    id_dict = {id: [] for id in id_list}
    sin_dict = {id: 0 for id in id_list}

    for r in report:
        user, sin = r.split()
        id_dict[user].append(sin)
        sin_dict[sin] += 1

    answer = [0 for i in range(len(id_list))]
    for i in range(len(id_list)):
        for iv in id_dict[id_list[i]]:
            if sin_dict[iv] >= k:
                answer[i] += 1

    return answer
