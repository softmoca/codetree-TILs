from collections import deque

def bfs():
    q=deque()
    q.append([0,0])
    step[0][0]=1
    while q:
        x,y=q.popleft()
        if x==n-1 and y==m-1:
            return

        for k in range(4):
            nx=x+dx[k]
            ny=y+dy[k]

            if 0<=nx<n and 0<=ny<n and step[nx][ny]==0 and arr[nx][ny]==1:
                step[nx][ny]=step[x][y]+1
                q.append([nx,ny])




n,m=map(int,input().split())

arr=[list(map(int,input().split())) for _ in range(n)]
step=[[0]*m for _ in range(n)]

dx=[-1,0,1,0]
dy=[0,1,0,-1]

bfs()



print(step[n-1][m-1]-1)