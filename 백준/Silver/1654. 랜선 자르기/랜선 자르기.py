import sys
K, N = map(int,input().split())
arr=[]

for _ in range(K):
    arr.append(int(sys.stdin.readline()))

start = 0
end = max(arr)
result = 0

while start<=end:
    total =0
    mid =(end+start)//2

    for x in arr:
        if x>=mid:
            if mid!=0:
                total +=(x//mid)
            else:
                total +=x
    if total>=N:
        result = max(mid,result)
        start = mid+1
    else:
        end = mid-1
print(result)