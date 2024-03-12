def dfs(x,y):
    arr[x][y]=0
    global cnt
    cnt+=1
    for k in range(4):
        nx=x+dx[k]
        ny=y+dy[k]
        if 0<=nx<n and 0<=ny<n and arr[nx][ny]==1:
            dfs(nx,ny)

dx=[-1,0,1,0]
dy=[0,1,0,-1]

n=int(input())
cnt_block=0
arr=[list(map(int,input().split())) for _ in range(n)]
answer=[]
cnt=0
for i in range(n):
    for j in range(n):
        if arr[i][j]==1:
            cnt_block+=1
            cnt=0
            dfs(i,j)
            answer.append(cnt)
answer.sort()
print(cnt_block)
for x in answer:
    print(x)