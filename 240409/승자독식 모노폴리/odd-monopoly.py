N,M,K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

# [0] 상어 정보 저장 + 초기 냄새 남김
shk = [[0]*4 for _ in range(M)]
v = [[[-1]*2 for _ in range(N)] for _ in range(N)]
for i in range(N):
    for j in range(N):
        if arr[i][j]>0:
            sn = arr[i][j]-1
            shk[sn]=[sn,i,j,0]              # 상어번호,i,j,dr
            v[i][j][0],v[i][j][1] = sn, K   # 상어번호, 냄새남김(초기냄새)

lst = list(map(int, input().split()))
for i in range(M):                  # 상어마리수
    shk[i][3]=lst[i]                # 방향저장

dtbl = [[[0]*4 for _ in range(5)] for _ in range(M)]    # 방향에따른 방향우선순위 룩업테이블 설정
for i in range(M):
    for j in range(1,5):
        dtbl[i][j]=list(map(int,input().split()))

#       상,하,좌,우
di = [0,-1, 1, 0, 0]
dj = [0, 0, 0,-1, 1]

for ans in range(1, 1001):  # 1초~1000초
    # [1] 각 상어를 이동: 현재방향기준, 빈칸->자기냄새
    for i in range(len(shk)):
        sn,si,sj,sd=shk[i]
        for dr in dtbl[sn][sd]:
            ni,nj=si+di[dr],sj+dj[dr]
            # 범위내 냄새가 없는 경우(빈칸 ==-1)
            if 0<=ni<N and 0<=nj<N and v[ni][nj][0]==-1:
                shk[i]=[sn,ni,nj,dr]
                break
        else:               # 빈칸이 없는 경우=>내냄새
            for dr in dtbl[sn][sd]:
                ni,nj=si+di[dr],sj+dj[dr]
                if 0<=ni<N and 0<=nj<N and v[ni][nj][0]==sn:
                    shk[i]=[sn,ni,nj,dr]
                    break

    # [2-1] 각 칸 냄새 -1
    for i in range(N):
        for j in range(N):
            if v[i][j][0]!=-1:      # 빈칸이 아닌경우(냄새있음)
                v[i][j][1]-=1       # 0되면 빈칸으로 처리
                if v[i][j][1]==0:
                    v[i][j][0]=-1

    # [2-2] 낮은번호상어처리(냄새있고, 내냄새 아니면 => 삭제)
    i=0
    while i<len(shk):
        sn,si,sj,sd=shk[i]
        # 냄새있고(==빈칸이 아니고), 내냄새 아니면 !=sn
        if v[si][sj][0]!=-1 and v[si][sj][0]!=sn:
            shk.pop(i)
        else:                       # 빈칸에 내가 처음 또는 내냄새 => 새냄새 뿌림
            v[si][sj]=[sn,K]
            i+=1

    if len(shk)<=1:                 # 1마리 이하면 종료
        break
else:
    ans=-1
print(ans)