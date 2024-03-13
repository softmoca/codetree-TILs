n,t=map(int,input().split())


arr1=list(map(int,input().split()))
arr2=list(map(int,input().split()))
arr3=list(map(int,input().split()))



for _ in range(t):
    temp=arr3[-1]
    for i in range(n-1,0,-1):
        arr3[i]=arr3[i-1]
    arr3[0]=arr2[-1]


    for i in range(n-1,0,-1):
        arr2[i]=arr2[i-1]
    arr2[0]=arr1[-1]



    for i in range(n-1,0,-1):
        arr1[i]=arr1[i-1]
    arr1[0]=temp


for x in arr1:
    print(x,end=' ')

print()

for x in arr2:
    print(x,end=' ')
print()
for x in arr3:
    print(x,end=' ')