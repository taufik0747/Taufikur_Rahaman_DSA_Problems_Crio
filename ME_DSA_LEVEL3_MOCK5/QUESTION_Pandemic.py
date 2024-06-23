import heapq
import collections

def pandemic(n, bus, src, dst, k, m):
    # Create a graph from the bus list
    graph = collections.defaultdict(list)
    for u, v, w in bus:
        graph[u].append((v, w))
    
    # Priority queue to store the (cost, city, stops)
    pq = [(0, src, 0)]  # (cost, current_city, stops)
    # Dictionary to store the minimum cost to reach each city with at most some stops
    min_cost = {(src, 0): 0}
    
    while pq:
        cost, city, stops = heapq.heappop(pq)
        
        # If we reach the destination and stops is within the limit, return the cost
        if city == dst:
            return cost
        
        # If we have stops left
        if stops <= k:
            for neighbor, price in graph[city]:
                new_cost = cost + price
                # If the new_cost is less, or we haven't reached the city with stops before, push to the queue
                if new_cost < min_cost.get((neighbor, stops + 1), float('inf')):
                    min_cost[(neighbor, stops + 1)] = new_cost
                    heapq.heappush(pq, (new_cost, neighbor, stops + 1))
    
    return -1

def main():
    n = int(input())
    m = int(input())
    bus = []
    for i in range(m):
        row = list(map(int, input().strip().split(' ')))
        bus.append(row)
    [src, dst, k] = list(map(int, input().strip().split(' ')))
    print(pandemic(n, bus, src, dst, k, m))

if __name__ == "__main__":
    main()
