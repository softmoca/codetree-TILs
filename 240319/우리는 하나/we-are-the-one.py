from collections import deque
from itertools import combinations

def bfs():
    q=deque()
    for row, col in temp_start:
        q.append([row,col])
        ch[row][col]=1
    
    while q:
        x,y=q.popleft()
        for k in range(4):
            nx=x+dx[k]
            ny=y+dy[k]

            if 0<=nx<n and 0<=ny<n and ch[nx][ny]==0 and ( u<= abs(arr[nx][ny]-arr[x][y]  )<=d ):
                ch[nx][ny]=1
                q.append([nx,ny])

n,k,u,d=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
ch=[[0]*n for _ in range(n)]
dx=[-1,0,1,0]
dy=[0,1,0,-1]

All_list=[]
max_anwer=0
for row in range(n):
    for col in range(n):
        All_list.append([row,col])
k_list=list(combinations(All_list,k))
for temp_start in k_list:
    for row in range(n):
        for col in range(n):
            ch[row][col]=0

    bfs()
    
    cnt=0
    for row in range(n):
        for col in range(n):
            if ch[row][col]==1:
                cnt+=1
    max_anwer=max(max_anwer,cnt)
print(max_anwer)