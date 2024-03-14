arr=list(map(str,input()))
Minn=100
N=len(arr)


for i in range(N):
    arr.append('temp')
    cnt=1
    tmp=[]
    for j in range(N):
        if arr[j]==arr[j+1]:
            cnt+=1
        else:
            tmp.append(cnt)
            cnt=1
    answer=0
    if len(tmp)==1:
        answer=3
    else:
        answer=2*len(tmp)
    if Minn>answer:
        Minn=answer
    



    arr.pop()
    arr.insert(0,arr.pop())



print(Minn)