def L_slide(r):
    temp=arr[r][-1]

    for i in range(m-1,0,-1):
        arr[r][i]=arr[r][i-1]
    arr[r][0]=temp

def R_slide(r):
    tmep=arr[r][0]
    for i in range(m-1):
        arr[r][i]=arr[r][i+1]
    arr[r][-1]=tmep

n,m,q=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]

for _ in range(q):
    r,d=map(str,input().split())
    r=int(r)-1
    if d=='L':
        L_slide(r)
    else:
        R_slide(r)
    tmp_d=d
    tmp_u=d
    for row in range(r,0,-1):
        flag=0
        for j in range(m):
            if arr[row][j]==arr[row-1][j]:
                flag=1
                if tmp_d=='L':
                    R_slide(row-1)
                    tmp_d='R'
                elif tmp_d=='R':
                    L_slide(row-1)
                    tmp_L='L'
                break
        if flag==0:
            break
        

    
    for row in range(r,n-1):
        flag=0
        for j in range(m):
            if arr[row][j]==arr[row+1][j]:
                flag=1
                if tmp_u=='L':
                    R_slide(row+1)
                    tmp_u='R'
                elif tmp_u=='R':
                    L_slide(row+1)
                    tmp_u='L'
                break
        if flag==0:
            break
                
for i in range(n):
    for j in range(m):
        print(arr[i][j],end=' ')
    print()
    
    




# 1. c처음 부는 바람 밀기
# 2. 바로 위행에서 같은 열에 같은 숫자 있는지 확인  반복 
# 3. 바로 아래 행에서 같은 열에 같은 숫자 있는지 확인
#