n,m=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]



def move(row,col):
    maxx=0
    max_pos=[-1,-1]
    for k in range(8):
        nx=row+dx[k]
        ny=col+dy[k]

        if 0<=nx<n and 0<=ny<n and arr[nx][ny]>maxx:
            maxx=arr[nx][ny]
            max_pos=[nx,ny]
    
    for k in range(8):
        nx = row+dx[k]
        ny= col +dy[k]
        if 0<=nx<n and 0<=ny<n and arr[nx][ny]==maxx:
            arr[nx][ny]=arr[row][col]
            arr[row][col]=maxx
            return

def rotate_num():
    for row in range(n):
        for col in range(n):
            if arr[row][col]==num:
                move(row,col)
                return


dx=[-1,-1,0,1,1,1,0,-1]
dy=[0,1,1,1,0,-1,-1,-1]

for _ in range(m):
    for num in range(1,n*n+1):
        rotate_num()

  
                    
               
             
                    



for row in range(n):
    for col in range(n):
        print(arr[row][col],end=' ')
    print()