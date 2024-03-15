n,row,col=map(int,input().split())

arr=[list(map(int,input().split())) for _ in range(n)]

dxs=[-1,1,0,0]
dys=[0,0,-1,1]

row=row-1
col=col-1
answer=[arr[row][col]]
while True:
    flag=0


    for dx,dy in zip(dxs,dys):
        nx=row+dx
        ny= col +dy

        if 0<=nx<n and 0<=ny<n and arr[nx][ny]>arr[row][col]:
            flag=1
            row=nx
            col=ny
            answer.append(arr[row][col])


    if flag==0:
        for x in answer:
            print(x,end=' ')
        break