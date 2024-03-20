from collections import deque

n,k=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
dis=[[0]*n for _ in range(n)]
dx=[-1,0,1,0]
dy=[0,1,0,-1]

q=deque()
for row in range(n):
    for col in range(n):
        if arr[row][col]==2:
            q.append([row,col])
            dis[row][col]=1


while q:
    x,y=q.popleft()
    for k in range(4):
        nx=x+dx[k]
        ny=y+dy[k]

        if 0<=nx<n and 0<=ny<n and dis[nx][ny]==0 and arr[nx][ny]==1:
            dis[nx][ny]=dis[x][y]+1
            q.append([nx,ny])

for row in range(n):
    for col in range(n):
        if dis[row][col]>=0:
            dis[row][col]-=1
        elif dis[row][col]==0:
            dis[row][col]=-1
        
for row in range(n):
    for col in range(n):
        print(dis[row][col],end=' ')
    print()