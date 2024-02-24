def is_prime():
    arr=[]
    for i in range(N+1):
        if prime[i]:
            arr.append(i)
            for j in range(i*2,N+1,i):
                prime[j]=False
    return arr

N= int(input())
prime=[False,False]+[True for _ in range(N)]
arr = is_prime()

left, right = 0,0
cnt = 0

while right <= len(arr) and left<= right:
    total = sum(arr[left:right])
    if total == N:
        cnt +=1
        right+=1
    elif total <N:
        right+=1
    else:
        left+=1
print(cnt)