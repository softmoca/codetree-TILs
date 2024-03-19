import sys
sys.setrecursionlimit(100)



def dfs(row,col):
    for k in range(4):
        nx=row+dx[k]
        ny=col +dy[k]
        if 0<=nx<n and 0<=ny <m and tmp[nx][ny]==0:
            tmp[nx][ny]=1
            dfs(nx,ny)



n,m=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]

tmp=[[0]*m for _ in range(n)]
dx=[-1,0,1,0]
dy=[0,1,0,-1]

max_k=1
max_cnt=0

for h in range(1,101):
    cnt=0

    for row in range(n):
        for col in range(m):
            tmp[row][col]=0


    for row in range(n):
        for col in range(m):
            if arr[row][col]<=h:
                tmp[row][col]=1  # 잠긴 집


    for row in range(n):
        for col in range(m):
            if tmp[row][col]==0:
                cnt+=1
                tmp[row][col]=1
                dfs(row,col)
    if cnt>max_cnt:
        max_cnt=cnt
        max_k=h
print(max_k,max_cnt)