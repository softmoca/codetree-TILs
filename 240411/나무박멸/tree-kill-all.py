n,m,k,c=map(int,input().split())
tree=[list(map(int,input().split())) for i in range(n)]
temp_tree=[[0]*n for _ in  range(n)]
herb=[[0]*n for _ in range(n)]
dx=[-1,0,1,0]
dy=[0,1,0,-1]

dxx=[-1,1,1,-1]
dyy=[1,1,-1,-1]
ans=0
for year  in range(1,m+1):
    # 1.나무의 성장
    for row in range(n):
        for col in range(n):
            if tree[row][col]>0 and herb[row][col]==0:
                for w in range(4):
                    nx=row+dx[w]
                    ny=col+dy[w]
                    if 0<=nx<n and 0<=ny<n and tree[nx][ny]>0 and herb[nx][ny]==0:
                        tree[row][col]+=1


    # 2. 나무의 번식
    for row in range(n):
        for col in range(n):
            if tree[row][col]>0 and herb[row][col]==0:
                count=0
                for w in range(4):
                    nx=row+dx[w]
                    ny= col+dy[w]
                    if 0<=nx<n and 0<=ny<n and tree[nx][ny]==0 and herb[nx][ny]==0:
                        count+=1
                for w in range(4):
                    nx = row + dx[w]
                    ny = col + dy[w]
                    if 0 <= nx < n and 0 <= ny < n and tree[nx][ny] == 0 and herb[nx][ny] == 0:
                        temp_tree[nx][ny]+=tree[row][col]//count

    for row in range(n):
        for col in range(n):
            if temp_tree[row][col]>0:
                tree[row][col]=temp_tree[row][col]

    for row in range(n):
        for col in range(n):
            temp_tree[row][col]=0


    #3-0 제초제 남아 있는 수 감소
    for row in range(n):
        for col in range(n):
            if herb[row][col]>0:
                herb[row][col]-=1

    # 3. 제초제 뿌리기
    #3-1 최대 지점 찾기
    max_row,max_col,max_count=0,0,0
    for row in range(n):
        for col in range(n):
            if tree[row][col]>0 and herb[row][col]==0:
                count=tree[row][col]
                for w in range(4):
                    nx = row
                    ny = col
                    for _ in range(k):
                        nx = nx + dxx[w]
                        ny = ny + dyy[w]
                        if 0<=nx<n and 0<=ny<n and tree[nx][ny]>0 and herb[nx][ny]==0:
                            count+=tree[nx][ny]
                        else:
                            break

                if count>max_count:
                    max_row=row
                    max_col=col
                    max_count=count


    ans=ans+max_count
    herb[max_row][max_col] = c
    tree[max_row][max_col] = 0
    #제초제 뿌리기
    for w in range(4):
        nx=max_row
        ny=max_col
        for z in range(k):
            nx=nx+dxx[w]
            ny=ny+dyy[w]
            if 0<=nx<n and 0<=ny<n:
                if tree[nx][ny]>0 and herb[nx][ny]==0:
                    #ans+=tree[nx][ny]
                    herb[nx][ny]=c
                    tree[nx][ny]=0
                elif tree[nx][ny]<=0:
                    herb[nx][ny]=c

                    break


print(ans)