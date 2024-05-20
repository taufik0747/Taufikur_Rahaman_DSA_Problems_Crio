from typing import List


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.next = None

def constructBinaryTreeFromPostorderAndInorderTraversal(postorder: List[int], inorder: List[int]) -> TreeNode:
    # Dictionary to quickly find the root index in inorder traversal
    inorder_index_map = {value: idx for idx, value in enumerate(inorder)}
    
    # Helper function to recursively form the tree
    def buildTree(post_start, post_end, in_start, in_end):
        if post_start > post_end or in_start > in_end:
            return None
        
        # The last element in postorder slice is the root
        root_val = postorder[post_end]
        root = TreeNode(root_val)
        
        # Root index in inorder traversal
        in_root_idx = inorder_index_map[root_val]
        
        # Numbers of elements in the left subtree
        left_size = in_root_idx - in_start
        
        # Recursively build the left and right subtree
        root.left = buildTree(post_start, post_start + left_size - 1, in_start, in_root_idx - 1)
        root.right = buildTree(post_start + left_size, post_end - 1, in_root_idx + 1, in_end)
        
        return root
    
    # Initialize the recursive function
    return buildTree(0, len(postorder) - 1, 0, len(inorder) - 1)


