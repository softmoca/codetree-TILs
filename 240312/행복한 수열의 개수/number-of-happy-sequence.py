def check_happy(tmp):
    Maxx=1
    cnt=1

    for i in range(1,len(tmp)):
        if tmp[i]==tmp[i-1]:
            cnt+=1
        
        else:
            Maxx=max(Maxx,cnt)
            cnt=1
    Maxx=max(cnt,Maxx)
    if Maxx>=m:
        return True
    else:
        return False







n,m=map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]


answer=0

# 행 확인
for row in range(n):
    tmp=arr[row]
    
    if check_happy(tmp):
        answer+=1

# 열확인

for row in range(n):
    tmp=[]
    for col in range(n):
        tmp.append(arr[col][row])
    if check_happy(tmp):
        answer+=1




print(answer)