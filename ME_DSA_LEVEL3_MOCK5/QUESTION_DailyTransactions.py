def dailyTransactions(n, arr):
    # Dictionary to store the first occurrence of each cumulative sum
    sum_map = {}
    max_length = 0
    current_sum = 0
    start_index = -1

    for i in range(n):
        current_sum += arr[i]

        if current_sum == 0:
            max_length = i + 1
            start_index = 0

        if current_sum in sum_map:
            if i - sum_map[current_sum] > max_length:
                max_length = i - sum_map[current_sum]
                start_index = sum_map[current_sum] + 1
        else:
            sum_map[current_sum] = i

    if max_length == 0:
        return [-1]
    else:
        return arr[start_index:start_index + max_length]

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    n = int(data[0])
    arr = list(map(int, data[1:n+1]))
    result = dailyTransactions(n, arr)
    print(*result)

if __name__ == "__main__":
    main()
