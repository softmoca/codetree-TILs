from collections import deque

def bfs():
    global flag
    while q:
        for i in range(len(q)):
            x,y=q.popleft()
            if x==n-1 and y==m-1:
                flag=1
                return

            for k in range(4):
                nx=x+dx[k]
                ny=y+dy[k]

                if 0<=nx<n and 0<=ny<m and arr[nx][ny]==1 and ch[nx][ny]==0:
                    ch[nx][ny]=1
                    q.append([nx,ny])




n,m=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n) ]
ch=[[0]*m for _ in range(n)]
dx=[-1,0,1,0]
dy=[0,1,0,-1]
flag=0

q=deque()
q.append([0,0])

bfs()
print(flag)