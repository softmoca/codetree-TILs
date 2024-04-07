# 격자의 크기 n, 박멸이 진행되는 년 수 m, 제초제의 확산 범위 k, 제초제가 남아있는 년 수 c

# 1. 인접한 네칸 중 나무가 있는 칸수 만큼 나무가 성장 -> 동시에 성장 temp 배열 생성
# 2. 벽, 다른 나무, 제초제 없는 칸에 번식 진행 (각 칸의 나무 그루 수 //번식이 가능한 칸수 ) 동시에 tmep 배열 생성 +
# 3. 자신 포함 4개의 대각선으로 제초제 살포시 가장 많이 박멸하는 칸 선택
# 4. 한번 뿌리면 c년 ㅁ나큼 있다가 c+1년째 사라진다.

# 1. 성장      (주변 나무만 확인)
# 2. 제초제 확인 후 번식   (  해당칸의 나무수/독, 나무, 벽 없는 빈칸의 수)
# 3. 제초제 뿌릴 위치 선정   
#4-0. 제초제 1년씩 감소 
# 4. 제초제 뿌리기


n,m,k,c=map(int,input().split())
tree=[list(map(int,input().split())) for _ in range(n)]
herb=[[0]*n for _ in range(n)]
next_tree=[[0]*n for _ in range(n)]
answer=0
dx=[-1,0,1,0]
dy=[0,1,0,-1]

dxx=[-1,1,1,-1]
dyy=[1,1,-1,-1]



def grow_count_fun(row,col):
    count=0
    for w in range(4):
        nx=row +dx[w]
        ny=col + dy[w]

        if 0<=nx<n and 0<=ny<n and tree[nx][ny]>0:
            count+=1
    return count




def grow():
    for row in range(n):
        for col in range(n):
            if tree[row][col]>0:
                grow_count=0
                grow_count=grow_count_fun(row,col)
                tree[row][col]+=grow_count



def bun_count_fun(row,col):
    count=0
    for w in range(4):
        nx=row +dx[w]
        ny=col + dy[w]
        if 0<=nx<n and 0<=ny<n and tree[nx][ny]==0 and herb[nx][ny]==0:
            count+=1
    return count

def bunsic_next_tree(row,col,bun_count):
    for w in range(4):
        nx=row +dx[w]
        ny=col + dy[w]
        if 0<=nx<n and 0<=ny<n and tree[nx][ny]==0 and herb[nx][ny]==0:
            next_tree[nx][ny]+=tree[row][col]//bun_count





def bunsic():
    for row in range(n):
        for col in range(n):
            next_tree[row][col]=0


    for row in range(n):
        for col in range(n):
            if tree[row][col]>0:
                bun_count=0
                bun_count=bun_count_fun(row,col)
                bunsic_next_tree(row,col,bun_count)

    for row in range(n):
        for col in range(n):
            if next_tree[row][col]:
                tree[row][col]=next_tree[row][col]

def herb_down():
    for row in range(n):
        for col in range(n):
            if herb[row][col]>0:
                herb[row][col]-=1

def find_max_herb():
    max_row,max_col,max_count=0,0,0

    for row in range(n):
        for col in range(n):
            if tree[row][col]>0:
                count=tree[row][col]
            
                for w in range(4):
                    nx=row
                    ny=col
                    for _ in range(k):
                        nx=nx+dxx[w]
                        ny=ny+dyy[w]
                        # 벽이 있거나 나무가 아얘없으면 뿌리고 이후 전파 그만
                        if 0<=nx<n and 0<=ny<n:
                            if tree[nx][ny]>0:
                                count+=tree[nx][ny]
                            elif tree[nx][ny]<=0:
            
                                break
                if count>max_count:
                    max_row=row
                    max_col=col
                    max_count=count
    return max_row,max_col,max_count
                                 

def herb_fun():
    global answer
    max_row,max_col,max_count=find_max_herb()
    
    answer=answer+max_count

    herb[max_row][max_col]=c
    tree[max_row][max_col]=0
    for w in range(4):
                    nx=max_row
                    ny=max_col
                    for _ in range(k):
                        nx=nx+dxx[w]
                        ny=ny+dyy[w]
                        # 벽이 있거나 나무가 아얘없으면 뿌리고 이후 전파 그만
                        if 0<=nx<n and 0<=ny<n:
                            if tree[nx][ny]>0:
                                herb[nx][ny]=c
                                tree[nx][ny]=0
                            elif tree[nx][ny]<=0:
                                herb[nx][ny]=c
                            
                                break
    


for _ in range(m):
    grow()
    
    bunsic()
    herb_down()

    herb_fun()

    
print(answer)