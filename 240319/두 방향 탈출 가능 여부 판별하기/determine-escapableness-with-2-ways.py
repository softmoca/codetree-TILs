def dfs(x,y):
    global Flag
    if x==n-1 and y==m-1:
        Flag=1
        
    else:
        for k in range(2):
            nx=x+dx[k]
            ny=y+dy[k]

            if 0<=nx<n and 0<=ny<m and ch[nx][ny]==0 and arr[nx][ny]==1:
                ch[nx][ny]=1
                dfs(nx,ny)




n,m=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n) ]
ch=[[0]*m for _ in range(n)]
dx=[1,0]
dy=[0,1]
Flag=0
ch[0][0]=1

dfs(0,0)
print(Flag)