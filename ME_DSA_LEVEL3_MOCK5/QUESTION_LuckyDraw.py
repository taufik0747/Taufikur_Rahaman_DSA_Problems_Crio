import random

def quickselect(arr, low, high, k):
    if low == high:
        return arr[low]
    
    pivot_index = random.randint(low, high)
    pivot_index = partition(arr, low, high, pivot_index)
    
    if k == pivot_index:
        return arr[k]
    elif k < pivot_index:
        return quickselect(arr, low, pivot_index - 1, k)
    else:
        return quickselect(arr, pivot_index + 1, high, k)

def partition(arr, low, high, pivot_index):
    pivot_value = arr[pivot_index]
    arr[pivot_index], arr[high] = arr[high], arr[pivot_index]
    store_index = low
    
    for i in range(low, high):
        if arr[i] < pivot_value:
            arr[i], arr[store_index] = arr[store_index], arr[i]
            store_index += 1
    
    arr[store_index], arr[high] = arr[high], arr[store_index]
    return store_index

def luckyDraw(tokens, x):
    n = len(tokens)
    return quickselect(tokens, 0, n - 1, x - 1)

if __name__ == '__main__':
    n = int(input())
    tokens = input().split()
    tokens = [int(i) for i in tokens]
    x = int(input())
    result = luckyDraw(tokens, x)
    print(result)
