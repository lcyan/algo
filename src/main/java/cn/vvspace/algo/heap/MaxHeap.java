package cn.vvspace.algo.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

    private final List<Integer> maxHeap;

    public MaxHeap(List<Integer> nums) {
        this.maxHeap = new ArrayList<>(nums);
        for (int i = this.parent(size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /* 从节点 i 开始，从顶至底堆化 */
    public void siftDown(int i) {
        while (true) {
            int left = left(i), right = right(i), mi = i;

            if (left < size() && maxHeap.get(left) > maxHeap.get(mi)) {
                mi = left;
            }

            if (right < size() && maxHeap.get(right) > maxHeap.get(mi)) {
                mi = right;
            }

            if (mi == i) {
                break;
            }

            swap(i, mi);
            i = mi;
        }
    }

    public void push(int val) {
        maxHeap.add(val);
        siftUp(size() - 1);
    }

    public int peek() {
        return maxHeap.get(0);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        swap(0, size() - 1);
        int val = maxHeap.remove(size() - 1);
        siftDown(0);
        return val;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void siftUp(int i) {
        while (true) {
            int p = parent(i);
            if (p < 0 || maxHeap.get(i) <= maxHeap.get(p)) {
                break;
            }
            swap(p, i);
            i = p;
        }
    }

    public int size() {
        return maxHeap.size();
    }

    private void swap(int i, int mi) {
        int tmp = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(mi));
        maxHeap.set(mi, tmp);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
}
