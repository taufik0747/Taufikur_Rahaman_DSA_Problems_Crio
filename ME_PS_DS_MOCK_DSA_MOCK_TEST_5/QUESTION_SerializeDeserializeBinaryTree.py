from queue import Queue

class Node:
    def __init__(self, value):
        self.key = value
        self.left = None
        self.right = None

def insert_value(root, value, q):
    node = Node(value)
    if root is None:
        root = node
    elif q.queue[0].left is None:
        q.queue[0].left = node
    else:
        q.queue[0].right = node
        q.get()
    q.put(node)
    return root

def create_tree(arr):
    root = None
    q = Queue()
    for value in arr:
        root = insert_value(root, value, q)
    return root

def level_order(root):
    ans = []
    if root is None:
        return ans
    n = Queue()
    n.put(root)
    while not n.empty():
        node = n.get()
        ans.append(node.key if node else None)
        if node:
            n.put(node.left)
            n.put(node.right)
    return ans

class Solution:

    def serialize(self, root):
        # Level order traversal with 'None' placeholders for missing children
        if not root:
            return []
        result = []
        queue = Queue()
        queue.put(root)
        while not queue.empty():
            node = queue.get()
            if node:
                result.append(node.key)
                queue.put(node.left)
                queue.put(node.right)
            else:
                result.append(None)
        # Remove trailing 'None' values
        while result and result[-1] is None:
            result.pop()
        return result

    def deserialize(self, data):
        if not data:
            return None
        root = Node(data[0])
        queue = Queue()
        queue.put(root)
        i = 1
        while not queue.empty() and i < len(data):
            node = queue.get()
            if i < len(data) and data[i] is not None:
                node.left = Node(data[i])
                queue.put(node.left)
            i += 1
            if i < len(data) and data[i] is not None:
                node.right = Node(data[i])
                queue.put(node.right)
            i += 1
        return root


def main():
    n = int(input())
    arr = list(map(int, input().split()))
    root = create_tree(arr)

    ser = Solution()
    deser = Solution()
    ans = deser.deserialize(ser.serialize(root))

    root_lvl = level_order(root)
    ans_lvl = level_order(ans)

    if root_lvl == ans_lvl:
        print("1")
    else:
        print("0")

if __name__ == "__main__":
    main()
