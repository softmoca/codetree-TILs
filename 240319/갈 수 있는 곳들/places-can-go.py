from collections import deque

def bfs():
    while q:
        x,y=q.popleft()
        for k in range(4):
           nx=x+dx[k]
           ny=y+dy[k]

           if 0<=nx<n and 0<=ny<n and ch[nx][ny]==0 and arr[nx][ny]==0:
            ch[nx][ny]=1
            q.append([nx,ny])

n,k=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
ch=[[0]*n for _ in range(n)]
dx=[-1,0,1,0]
dy=[0,1,0,-1]

q=deque()
for _ in range(k):
    a,b=map(int,input().split())
    q.append([a-1,b-1])
    ch[a-1][b-1]=1

bfs()
anwer=0
for i in range(n):
    for j in range(n):
        if ch[i][j]==1:
            anwer+=1
print(anwer)