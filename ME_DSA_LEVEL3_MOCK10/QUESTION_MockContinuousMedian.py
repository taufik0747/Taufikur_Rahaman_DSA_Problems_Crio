def continuousMedian(arr):
    from heapq import heappush, heappop
    min_heap = []  # To store the larger half of the numbers
    max_heap = []  # To store the smaller half of the numbers, as negative to use min heap as max heap
    result = []

    for number in arr:
        if not max_heap or number < -max_heap[0]:
            heappush(max_heap, -number)
        else:
            heappush(min_heap, number)

        # Rebalance heaps
        if len(max_heap) > len(min_heap) + 1:
            heappush(min_heap, -heappop(max_heap))
        elif len(min_heap) > len(max_heap):
            heappush(max_heap, -heappop(min_heap))

        # Calculate median
        if len(max_heap) == len(min_heap):
            median = (-max_heap[0] + min_heap[0]) // 2
        else:
            median = -max_heap[0]
        
        result.append(median)

    return result

def main():
    n= int(input())
    arr = list(map(int,input().split()))
    answer = continuousMedian(arr)
    print('\n'.join(map(str, answer)))

if __name__ == "__main__":
    main()
