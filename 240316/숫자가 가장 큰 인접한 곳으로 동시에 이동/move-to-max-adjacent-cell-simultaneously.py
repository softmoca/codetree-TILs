def get_next_pos(row,col):
    maxx=0
    max_pos=[-1,-1]
    for k in range(4):
        nx= row + dx[k]
        ny= col + dy[k]
        if 0<=nx<n and 0<=ny<n and arr[nx][ny]>maxx:
            maxx=arr[nx][ny]
            max_pos=[nx,ny]
    for k in range(4):
        nx= row + dx[k]
        ny= col + dy[k]
        if 0<=nx<n and 0<=ny<n and arr[nx][ny]==maxx:
            return max_pos
           
            


def move(row,col):
    next_x,next_y=get_next_pos(row,col)

    next_count[next_x][next_y]+=1


n,m,t=map(int,input().split())


arr=[list(map(int,input().split())) for _ in range(n)]

count=[[0]*n for _ in range(n)]
next_count=[[0]*n for _ in range(n)]

for _ in range(m):
    row,col=map(int,input().split())
    count[row-1][col-1]=1


dx=[-1,1,0,0]
dy=[0,0,-1,1]



for _ in range(t):
    for row in range(n):
        for col in range(n):
            next_count[row][col]=0


    for row in range(n):
        for col in range(n):
            if count[row][col]==1:
                move(row,col)
    
    for row in range(n):
        for col in range(n):
            count[row][col]=next_count[row][col]

    for row in range(n):
        for col in range(n):
            if count[row][col]>1:
                count[row][col]=0


answer=0
for row in range(n):
    for col in range(n):
        if count[row][col]==1:
            answer+=1

print(answer)