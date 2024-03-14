n=int(input())

arr=[]
for _ in range(n):
    arr.append(int(input()))

temp=[]
a,b=map(int,input().split())
for i in range(n):
    if a-1<=i<b:
        continue
    else:
        temp.append(arr[i])
    



temp2=[]
a,b=map(int,input().split())
for i in range(len(temp)):
    if a-1<=i<b:
        continue
    else:
        temp2.append(temp[i])




print(len(temp2))
for x in temp2:
    print(x)