def birthdayParty(arr):
    n = len(arr)
    result = [-1] * n
    stack = []

    # Traverse the list from right to left
    for i in range(n-1, -1, -1):
        # Maintain stack in increasing order of ages
        while stack and arr[stack[-1]] >= arr[i]:
            stack.pop()
        
        # If stack is not empty, the top of the stack is the next younger person
        if stack:
            result[i] = arr[stack[-1]]
        
        # Push current index to the stack
        stack.append(i)
    
    return result

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    N = int(data[0])
    A = list(map(int, data[1:N+1]))
    result = birthdayParty(A)
    print(*result)

if __name__ == "__main__":
    main()
