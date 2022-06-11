def solution(board, moves):
    # 세로로 되어있는 board를 가로로 변환
    sero = list(map(list, list(zip(*board))))
    baguni = []; rst = 0
    for m in moves:  # 크레인 이동 명령
        for v in sero[m-1]:  # 해당 줄을 훑어내려감
            if v != 0:  # 0일때는 빈공간이므로 무시
                doll = v
                sero[m - 1].remove(v)
                break
        else:  # 반복문이 break되지 않고 완료되었을 경우는 0으로만 차있는 빈 Column이라는 뜻, 루프를 넘겨버린다
            continue
        if len(baguni) > 0 and baguni[-1] == doll:  # 바구니가 비어있지 않고, 인형이 들어왔을 때 체크해주는 함수
            baguni.pop()
            rst += 2
            continue
        baguni.append(doll)
    return rst
