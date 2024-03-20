from collections import deque
from itertools import combinations

def bfs():
    global flag
    q=deque()
    q.append([start_row,start_col])
    dis[start_row][start_col]=1

    while q:
        x,y=q.popleft()
        if x==end_row and y==end_col:
            flag=1
 
            return

        for k in range(4):
            nx=x+dx[k]
            ny=y+dy[k]
            if 0<=nx<n and 0<=ny<n and temp[nx][ny]==0 and dis[nx][ny]==0:
                dis[nx][ny]=dis[x][y]+1
                q.append([nx,ny])
            





n,k=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
dis=[[0]*n for _ in range(n)]
temp=[[0]*n for _ in range(n)]
dx=[-1,0,1,0]
dy=[0,1,0,-1]

start_row,start_col=map(int,input().split())
end_row,end_col=map(int,input().split())
start_row-=1
start_col-=1
end_col-=1
end_row-=1


All_list=[]

for row in range(n):
    for col in range(n):
        if arr[row][col]==1:
            All_list.append([row,col])

All_FLAG=0
All_delete_list=list(combinations(All_list,k))
min_answer=1000000
for delete_list  in All_delete_list:
    flag=0
    for row in range(n):
        for col in range(n):
            temp[row][col]=arr[row][col]
    for row in range(n):
        for col in range(n):
            dis[row][col]=0


    for x,y in delete_list:
        temp[x][y]=0
    
    bfs()

    # for x in dis:
    #     print(x)
    # print(flag)

    if flag==1:
        All_FLAG=1
        min_answer=min(min_answer,dis[end_row][end_col]-1)



if All_FLAG==1:
    print(min_answer)
else:
    print(-1)