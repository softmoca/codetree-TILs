n,m,k=map(int,input().split()) # 격자 크기, 참가수, 게임 시간
arr=[list(map(int,input().split())) for i in range(n)] # 미로 벽 관리
person=[]    # 현재 생존한 참가자 관리
for _ in range(m):
    a,b=map(int,input().split())
    a-=1
    b-=1
    person.append([a,b])
answer=0 # 참가자들 이동 거리 출력값
a,b=map(int,input().split())
exit_row=a-1 # 출구 좌표
exit_col=b-1 # 출구 좌표

dx=[-1,1,0,0]  # 상하 좌우   상하 우선
dy=[0,0,-1,1]

def find_samllest_square():
    for size in range(1, n):
        for start_row in range(n):
            for start_col in range(n):
                if not (start_row <= exit_row <= start_row + size and start_col <= exit_col <= start_col + size):
                    continue
                for i in range(len(person)):
                    person_row = person[i][0]
                    person_col = person[i][1]
                    if start_row <= person_row <= start_row + size and start_col <= person_col <= start_col + size:
                        return size,start_row,start_col



for second in range(1,k+1):
    # 1. 참가자 이동
    for i in range(len(person)):
        person_row=person[i][0]
        person_col=person[i][1]

        min_dist=1000
        for w in range(4):
            nx=person_row+dx[w]
            ny=person_col+dy[w]
            if 0<=nx<n and 0<=ny<n:
                min_dist=min(min_dist,abs(exit_row-nx)+abs(exit_col-ny))

        for w in range(4):
            nx = person_row + dx[w]
            ny = person_col + dy[w]
            if 0 <= nx < n and 0 <= ny < n:
                if (abs(exit_row-nx)+abs(exit_col-ny)) == min_dist and arr[nx][ny]==0:
                    person[i]=[nx,ny]
                    answer+=1
                    break

  #  print('d')

    for i in range(len(person) - 1, -1, -1):
        if person[i] == [exit_row, exit_col]:
            person.pop(i)

    if len(person)==0:
        break

    # 2. 정사각형 최전
    #2-1 정사각형 찾기

    size,start_row,start_col,=find_samllest_square()
 #   print('d')

    # 미로 회전
    temp_square=[[0]*(size+1) for _ in range(size+1)]
    for row in range(start_row,start_row+size+1):
        for col in range(start_col,start_col+size+1):
            temp_square[row-start_row][col-start_col]=arr[row][col]
    temp_temp_square=[[0]*(size+1) for _ in range(size+1)]


    for row in range(size+1):
        for col in range(size+1):
            temp_temp_square[col][size-row]=temp_square[row][col]



    for row in range(start_row,start_row+size+1):
        for col in range(start_col,start_col+size+1):
            arr[row][col]=temp_temp_square[row-start_row][col-start_col]
   # print('d')
    # 출구 회전

    ox, oy = exit_row - start_row, exit_col - start_col
    rx, ry = oy, size - ox
    exit_row=rx+start_row
    exit_col=ry+start_col
   # print('d')

    # 사람 회전 (정 사각현 내부에 있는 사람들만)
    for i in range(len(person)):
        tx, ty = person[i]
        # 해당 참가자가 정사각형 안에 포함되어 있을 때에만 회전시킵니다.
        if start_row <= tx and tx < start_row +size+1 and start_col <= ty and ty < start_col + size+1:
            # Step 1. (sx, sy)를 (0, 0)으로 옮겨주는 변환을 진행합니다.
            ox, oy = tx - start_row, ty - start_col
            # Step 2. 변환된 상태에서는 회전 이후의 좌표가 (x, y) . (y, square_n - x - 1)가 됩니다.
            rx, ry = oy, size - ox
            # Step 3. 다시 (sx, sy)를 더해줍니다.
            person[i] = [rx + start_row, ry + start_col]
  #  print('d')


    # 3. 사각형 내구도 1 감소
    for row in range(start_row,start_row+size+1):
        for col in range(start_col,start_col+size+1):
            if arr[row][col]>0:
                arr[row][col]-=1
   # print('d')



print(answer)
print(exit_row+1,exit_col+1)