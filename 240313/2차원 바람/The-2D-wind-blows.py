n,m,q=map(int,input().split())

arr=[list(map(int,input().split())) for _ in range(n)]
board=[[0]*m for _ in range(n)]



for _ in range(q):
    r1,c1,r2,c2=map(int,input().split())
    r1=r1-1
    c1=c1-1
    r2=r2-1
    c2=c2-1


    tmp_up=arr[r1][c2]
    tmp_down=arr[r2][c1]
    #1 오른쪽 위 오른쪾으로 이동 
    for i in range(c2-1,c1-1,-1):
        arr[r1][i+1]=arr[r1][i]


    #2 왼쪽 아래 왼쪾으로 이동
    for i in range(c1+1,c2+1):
        arr[r2][i-1]=arr[r2][i]

    #3 오른쪽 위에서 아래로 이동
    for i in range(r2-1,r1,-1):
        arr[i+1][c2]=arr[i][c2]
    arr[r1+1][c2]=tmp_up

    #4 왼쪽 아래에서 위로 이동
    for i in range(r1+1,r2):
        arr[i-1][c1]=arr[i][c1]
    arr[r2-1][c1]=tmp_down

    dx=[-1,0,1,0]
    dy=[0,1,0,-1]




    for i in range(r1,r2+1):
        for j in range(c1,c2+1):
            summ=arr[i][j]
            cnt=1
            for k in range(4):
                x=i+dx[k]
                y=j+dy[k]
                if 0<=x<n and 0<=y<m:
                    summ=summ+arr[x][y]
                    cnt+=1
            board[i][j]=summ//cnt
            




    for i in range(r1,r2+1):
        for j in range(c1,c2+1):
            arr[i][j]=board[i][j]


for i in range(n):
    for j in range(m):
        print(arr[i][j],end=' ')
    print()



# 1. 시계방향 회전 ( )
#3 1-1 가로 먼저 이동 + /방향 대각선 양끝 tmep

# 3. 평균 구하기 ( 주변 인접 갯수세는 함수)
#