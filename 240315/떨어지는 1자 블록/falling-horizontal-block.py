import sys





n,m,k=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]


temp=[1]*m



for row in range(n):
    for col in range(k-1,m):
        if arr[row][col]==temp[col]:
            for i in range(m):
                arr[row-1][col+i]=temp[i]

            for i in range(n):
                for j in range(n):
                    print(arr[i][j],end=' ')
                print()
        
            sys.exit()