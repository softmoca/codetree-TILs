from collections import deque


def bfs():
    q=deque()
    q.append([row,col])
    dis_ch[row][col]=1
    global flag

    while q:
        x,y=q.popleft()
        if arr[x][y]==3:
            flag=1
            temp[row][col]=dis_ch[x][y]-1
            return
        
        for k in range(4):
            nx=x+dx[k]
            ny=y+dy[k]
            if 0<=nx <n and 0<=ny <n and dis_ch[nx][ny]==0 and arr[nx][ny]!=1:
                dis_ch[nx][ny]=dis_ch[x][y]+1
                q.append([nx,ny])



n,h,m=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
dis_ch=[[0]*n for _ in range(n)]

temp=[[0]*n for _ in range(n)]
dx=[-1,0,1,0]
dy=[0,1,0,-1]



for row in range(n):
    for col in range(n):
        if arr[row][col]==2:
            
            for i in range(n):
                for j in range(n):
                    dis_ch[i][j]=0

            flag=0
            bfs()
            if flag==0:
                temp[row][col]=-1
     

for row in range(n):
    for col in range(n):
        print(temp[row][col],end=' ')
    print()