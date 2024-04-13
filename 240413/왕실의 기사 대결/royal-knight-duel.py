# 4 3 3           L, N, Q 체스판의 크기, 기사의 수, 명령수
# 0 0 1 0
# 0 0 1 0
# 1 1 0 1   체스판의 정보 , 0 빈칸, 1, 함정, 2 벽
# 0 0 2 0
# 1 2 2 1 5
# 2 1 2 1 1   N개의 기사 정보 , r,c,h,w,k,   행,열,세로, 가로, 체력
# 3 2 1 2 3
# 1 2
# 2 1        Q개의 왕의 명령 , i,d i번 기사에서    d로 이동하라. d =0, 1, 2, 3 ( 위, 오른쪽, 아래, 왼)
# 3 3
#
# 출력 : q개의 명령 이후 생존한 기사들이 받은 데미지 총합을 출력
#
# 체스판 밖도 벽으로 간주
#
# 1) 기사의 이동
# - 상하좌우중 한칸 이동
#   - 이동하려는 위치에 다른 기사가 있으면 연쇄적으로 밀린다
#     - 기사가 이동하려는곳 끝에 벽이 있으면 모든 기사는 이동 할수 없다.
# - 체스판에서 사라진 기사에게 명령을 내려도 아무런 반응이
# if 없다:
#
#
# 2) 대결 데미지
# - 밀려난 기사는 wh 직사각형 내부에 있는 함정의 수만큼 피해를
# - 현재 체력 이상 만큼 데이지를 입으면 체스판에서 사라진다.
# - 명령을 받은 기사는 피해를 입지 않는다.
# - 모두 밀린 이후 데이지를 입는다.
#

from collections import deque

L,N,Q=map(int,input().split())
arr=[list(map(int,input().split())) for i in range(L)]
ch=[[0]*L for i in range(L)]

command=[]
person=[[[0,0] for i in range(L)]for j in range(L)]
next_person=[[[0,0] for i in range(L)]for j in range(L)]
person_list=[0]
target=[]
first_k=[0]
dx=[-1,0,1,0]
dy=[0,1,0,-1]


for i in range(L):
    arr[i].append(2)
    arr[i].insert(0,2)
    ch[i].append(0)
    ch[i].insert(0,0)
    person[i].append([0,0])
    person[i].insert(0, [0,0])
    next_person[i].append([0, 0])
    next_person[i].insert(0, [0, 0])


arr.insert(0,[2]*(L+2))
arr.append([2]*(L+2))
ch.insert(0,[0]*(L+2))
ch.append([0]*(L+2))

person.insert(0,[[0,0]]*(L+2))
person.append([[0,0]]*(L+2))

next_person.insert(0,[[0,0]]*(L+2))
next_person.append([[0,0]]*(L+2))

answer=0
for i in range(1,N+1):
    r,c,h,w,k=map(int,input().split())
    person_list.append([r,c,h,w,k])
    first_k.append([r,c,h,w,k])
    for row in range(r,r+h):
        for col in range(c,c+w):
            person[row][col]=[i,k]

for _ in range(Q):
    i,d=map(int,input().split())
    command.append([i,d])


def bfs(start_row,start_col,idx,d,target,ch,person_list,arr,person):
    q = deque()
    q.append([start_row, start_col])

    for row in range(L+2):
        for col in range(L+2):
            if person[row][col][0]==person[start_row][start_col][0] :
                ch[row][col]=1


    target.append([start_row, start_col])

    while q:
        row, col = q.popleft()


        r, c, h, w, k =  person_list[    person[row][col][0]      ]

        # 벽만나는지 검사
        for ch_row in range(r, r + h):
            for ch_col in range(c, c + w):
                if arr[ch_row][ch_col] == 2:
                    return False

        nx = row + dx[d]
        ny = col + dy[d]
        for x in range(nx, nx + h):
            for y in range(ny, ny + w):
                # 벽만나는지 검사
                if arr[x][y] == 2:
                    return False

                if person[x][y] != [0, 0] and person[x][y] != person[row][col] and ch[x][y] == 0 :
                    r, c, h, w, k = person_list[person[x][y][0]]
                    target.append([r, c])

                    q.append([r, c])
                    for ch_row in range(L + 2):
                        for ch_col in range(L + 2):
                            if person[ch_row][ch_col][0] == person[r][c][0]:
                                ch[ch_row][ch_col] = 1

    return True

def find_person(i):
    for row in range(1,L+1):
        for col in range(1,L+1):
            if person[row][col][0]==i:
                start_row=row
                start_col=col
                return start_row,start_col

for trun in range(1,Q):
    idx,d=command[trun]
    if person_list[idx][4]<=0:
        continue


    start_row=-1
    start_col=-1




    # 명령 받은 기사 정보 찾기
    start_row,start_col=find_person(idx)




    #bfs탐색 시작
    target = []
    for row in range(L + 2):
        for col in range(L + 2):
            ch[row][col] = 0

    if bfs(start_row, start_col, idx, d, target, ch, person_list, arr, person):
        # 벽에 안부딪혔으면 이동시작
        for target_row,target_col in target:
            target_number=person[target_row][target_col][0]

            person_list[target_number][0]=target_row+dx[d]
            person_list[target_number][1]=target_col+dy[d]

            for row in range(L + 2):
                for col in range(L + 2):
                    if person[row][col][0]==target_number:
                        next_person[row+dx[d]][col+dy[d]]=person[row][col]

        for row in range(L+2):
            for col in range(L+2):
                person[row][col]=next_person[row][col]

        for i in range(len(target)):
            target[i][0]=target[i][0]+dx[d]
            target[i][1]=target[i][1]+dy[d]




    #체력 감소
    for target_row, target_col in target:
        target_number = person[target_row][target_col][0]
        if target_number==idx:
            continue

        r, c, h, w, k = person_list[target_number]


        for row in range(r,r+h):
            for col in range(c,c+w):
                if person[row][col]!=[0,0] and arr[row][col]==1:
                    person_list[target_number][4] -= 1




for i in range(1,len(person_list)):
    if person_list[i][4]!=0:
        answer=answer+(first_k[i][4]-person_list[i][4])




print(answer)