n = int(input())
arr=[0]*(n+2)
for i in range(n):
    arr[i]=int(input())
dp=[0]*(n+2)
dp[0]= arr[0]
dp[1]= arr[1]+arr[0]
dp[2]= max(arr[1]+arr[2],arr[0]+arr[2])
for i in range(3,n):
    dp[i]= max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i],)

print(dp[n-1])