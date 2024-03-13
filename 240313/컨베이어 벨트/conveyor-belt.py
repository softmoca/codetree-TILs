n,t=map(int,input().split())

arr1=list(map(int,input().split()))
arr2=list(map(int,input().split()))

for _ in range(t):
    arr1.insert(0,arr2.pop())
    arr2.insert(0,arr1.pop())



for x in arr1:
    print(x,end=' ')
print()
for x in arr2:
    print(x,end=' ')