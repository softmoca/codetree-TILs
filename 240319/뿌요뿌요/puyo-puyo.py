def dfs(row,col,h):
    global cnt
    cnt+=1
    for k in range(4):
        nx=row+dx[k]
        ny=col+dy[k]
        if 0<=nx<n and 0<=ny<n and ch[nx][ny]==h:
            ch[nx][ny]=0
            dfs(nx,ny,h)

n=int(input())
dx=[-1,0,1,0]
dy=[0,1,0,-1]
arr=[list(map(int,input().split())) for _ in range(n)]
ch=[[0]*n for _ in range(n)]


max_block_cnt=0

cnt_boom=0
for h in range(1,101):
    for row in range(n):
        for col in range(n):
            ch[row][col]=arr[row][col]

    for row in range(n):
        for col in range(n):
            if arr[row][col]==h:
                cnt=0
                ch[row][col]=0
                dfs(row,col,h)
                if cnt>=4:
                    cnt_boom+=1

                max_block_cnt=max(max_block_cnt,cnt)


print(cnt_boom,max_block_cnt)