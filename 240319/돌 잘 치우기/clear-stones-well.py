from collections import deque
from itertools import combinations

def bfs():
    q=deque()
    for a,b in start_point:
        q.append([a,b])
        temp[a][b]=1
        ch[a][b]=1
    
    while q:
        x,y=q.popleft()
        for k in range(4):
            nx=x+dx[k]
            ny=y+dy[k]

            if 0<=nx<n and 0<=ny<n and ch[nx][ny]==0 and temp[nx][ny]==0:
                ch[nx][ny]=1
                q.append([nx,ny])

n,k,m=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
temp=[[0]*n for _ in range(n)]
ch=[[0]*n for _ in range(n)]
dx=[-1,0,1,0]
dy=[0,1,0,-1]

start_point=[]
for _ in range(k):
    a,b=map(int,input().split())
    start_point.append([a-1,b-1])
max_answer=0
All_one_list=[]
for row in range(n):
    for col in range(n):
        if arr[row][col]==1:
            All_one_list.append([row,col])

one_list=list(combinations(All_one_list,m))

for temp_one_list in one_list:
    
    for row in range(n):
        for col in range(n):
            temp[row][col]=arr[row][col]

    for row in range(n):
        for col in range(n):
            ch[row][col]=0

    for row,col in temp_one_list:
        temp[row][col]=0

    bfs()
    cnt=0
    for row in range(n):
        for col in range(n):
            if ch[row][col]==1:
                cnt+=1
    max_answer=max(max_answer,cnt)

print(max_answer)