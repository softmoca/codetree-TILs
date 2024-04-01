# 격자의 크기 n, 박멸이 진행되는 년 수 m, 제초제의 확산 범위 k, 제초제가 남아있는 년 수 c

# 1. 인접한 네칸 중 나무가 있는 칸수 만큼 나무가 성장 -> 동시에 성장 temp 배열 생성
# 2. 벽, 다른 나무, 제초제 없는 칸에 번식 진행 (각 칸의 나무 그루 수 //번식이 가능한 칸수 ) 동시에 tmep 배열 생성 +
# 3. 자신 포함 4개의 대각선으로 제초제 살포시 가장 많이 박멸하는 칸 선택
# 4. 한번 뿌리면 c년 ㅁ나큼 있다가 c+1년째 사라진다.

# 1. 성장
# 2. 제초제 확인 후 번식
# 3. 제초제 뿌릴 위치 선정
# 4. 제초제 뿌리기

n,m,k,c=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]
grow_temp=[[0]*n for _ in range(n)]
bunsic_temp=[[0]*n for _ in range(n)]
posion_ch=[[0]*n for _ in range(n)]
anwer=0
dx=[-1,0,1,0]
dy=[0,1,0,-1]

dxx=[-1,1,1,-1]
dyy=[1,1,-1,-1]

def count_tree(row,col):
    count=0
    for w in range(4):
        nx=row+dx[w]
        ny=col+dy[w]
        if 0<=nx<n and 0<=ny<n and arr[nx][ny]>0 and posion_ch[nx][ny]==0:
            count+=1
    return count

def count_zero(row,col):
    count =0
    for w in range(4):
        nx=row+dx[w]
        ny=col+dy[w]
        if 0<=nx<n and 0<=ny<n and arr[nx][ny]==0 and posion_ch[nx][ny]==0:
            count+=1
    return count

def grow():
    for row in range(n):
        for col in range(n):
            grow_temp[row][col]=0


    for row in range(n):
        for col in range(n):
            
            if arr[row][col]>0:
                count=count_tree(row,col)
                grow_temp[row][col]=arr[row][col]+count
    for row in range(n):
        for col in range(n):
            if grow_temp[row][col]:
                arr[row][col]=grow_temp[row][col]



def bunsic():
    for row in range(n):
        for col in range(n):
            bunsic_temp[row][col]=0
    

    for row in range(n):
        for col in range(n):
            if arr[row][col]>0:
                count=count_zero(row,col)
                for w in range(4):
                    nx=row+dx[w]
                    ny=col+dy[w]
                    if 0<=nx<n and 0<=ny<n and arr[nx][ny]==0 and posion_ch[nx][ny]==0:
                        bunsic_temp[nx][ny]+=arr[row][col]//count
    for row in range(n):
        for col in range(n):
            if bunsic_temp[row][col]:
                arr[row][col]=bunsic_temp[row][col]


def count_posion(row,col):
    count=0
    for w in range(4):
        nx=row
        ny=col
        for _ in range(k):
            nx=nx+dxx[w]
            ny=ny+dyy[w]
            if 0<=nx<n and 0<=ny<n and arr[nx][ny]>0:
                count=count+arr[nx][ny]
            else:
                break
    return count

def find_max_posion():
    global anwer
    max_row,max_col,Maxx_count=0,0,0
    for row in range(n):
        for col in range(n):
            if arr[row][col]>0:
                count=count_posion(row,col)+arr[row][col]
                if Maxx_count<count:
                    max_row=row
                    max_col=col
                    Maxx_count=count

    anwer=anwer+Maxx_count
    return max_row,max_col



def posion():
    row, col=find_max_posion()
    # print(row,col)
    arr[row][col]=-2
    posion_ch[row][col]=c
    for w in range(4):
        nx =row
        ny=col
        for _ in range(k):
            nx=nx+dxx[w]
            ny=ny+dyy[w]
            if 0<=nx<n and 0<=ny<n :
                if arr[nx][ny]<0:
                    if arr[nx][ny]==-1:
                        arr[nx][ny]=-1
                        posion_ch[nx][ny]=c  
                    else:
                        arr[nx][ny]=-2
                        posion_ch[nx][ny]=c                    
                    break
                else:
                    arr[nx][ny]=-2
                    posion_ch[nx][ny]=c


            else:
                break

def down_posion():
    for row in range(n):
        for col in range(n):
            if posion_ch[row][col]>0:
                posion_ch[row][col]-=1
                if posion_ch[row][col]==0:
                    arr[row][col]=0



for _ in range(m):
    
    grow()
    # for x in posion_ch:
    #     print(x)
    # print()


    bunsic()
    # for x in posion_ch:
    #     print(x)
    # print()

    down_posion()
    posion()
    # for x in posion_ch:
    #     print(x)
    # print(anwer)
    # print()

print(anwer)