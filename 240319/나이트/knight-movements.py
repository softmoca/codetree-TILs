from collections import deque

def bfs():
    global flag
    global cnt
    q=deque()
    q.append([start_row,start_col])
    ch[start_row][start_col]=1

    while q:
        x,y=q.popleft()
        if x==end_row and y==end_col:
            flag=1
            return

        for k in range(8):
            nx=x+dx[k]
            ny=y+dy[k]
            if 0<=nx<n and 0<=ny<n and ch[nx][ny]==0:
                ch[nx][ny]=ch[x][y]+1
                q.append([nx,ny])

n=int(input())
ch=[[0]*n for _ in range(n)]
flag=0
cnt=1
start_row,start_col,end_row,end_col=map(int,input().split())

start_col-=1
start_row-=1
end_col-=1
end_row-=1

dx=[-2,-1,1,2,2,1,-1,-2]
dy=[1,2,2,1,-1,-2,-2,-1]

bfs()


if flag==0:
    print(-1)
else:
    print(ch[end_row][end_col]-1)