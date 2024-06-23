import java.util.*;

class Solution {
    private class SegmentTree {
        int n;
        int[] tree;

        public SegmentTree(int size) {
            n = size;
            tree = new int[4 * size];
        }

        public void update(int idx, int val) {
            updateUtil(0, 0, n - 1, idx, val);
        }

        private void updateUtil(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] += val;
            } else {
                int mid = (start + end) / 2;
                if (idx <= mid) {
                    updateUtil(2 * node + 1, start, mid, idx, val);
                } else {
                    updateUtil(2 * node + 2, mid + 1, end, idx, val);
                }
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        public int query(int L, int R) {
            return queryUtil(0, 0, n - 1, L, R);
        }

        private int queryUtil(int node, int start, int end, int L, int R) {
            if (R < start || L > end) {
                return 0;
            }
            if (L <= start && end <= R) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            return queryUtil(2 * node + 1, start, mid, L, R) + queryUtil(2 * node + 2, mid + 1, end, L, R);
        }
    }

    public ArrayList<Integer> countOfSmallerNumberAfterSelf(int[] nums) {
        int offset = 100000; // Max offset to handle negative values
        int size = 2 * offset + 1;
        SegmentTree segTree = new SegmentTree(size);
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int shiftedIndex = nums[i] + offset;
            result.add(segTree.query(0, shiftedIndex - 1));
            segTree.update(shiftedIndex, 1);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 2, 6, 1};
        ArrayList<Integer> result = solution.countOfSmallerNumberAfterSelf(nums);
        System.out.println(result);
    }
}
