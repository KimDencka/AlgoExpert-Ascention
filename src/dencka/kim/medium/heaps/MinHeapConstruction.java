package dencka.kim.medium.heaps;

import java.util.*;

class MinHeapConstruction {
    static class MinHeap {
        List<Integer> heap = new ArrayList<>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int firstParent = (array.size() - 2) / 2;
            for (int cur = firstParent; cur >= 0; cur--) {
                siftDown(cur, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentId, int endIdx, List<Integer> heap) {
            int childOne = currentId * 2 + 1;
            while (childOne <= endIdx) {
                int childTwo = currentId * 2 + 2 <= endIdx ? currentId * 2 + 2 : -1;
                int idToSwap;
                if (childTwo != -1 && heap.get(childTwo) < heap.get(childOne)) {
                    idToSwap = childTwo;
                } else {
                    idToSwap = childOne;
                }
                if (heap.get(idToSwap) < heap.get(currentId)) {
                    swap(currentId, idToSwap, heap);
                    currentId = idToSwap;
                    childOne = currentId * 2 + 1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentId, List<Integer> heap) {
            int parentId = (currentId - 1) / 2;
            while (currentId > 0 && heap.get(currentId) < heap.get(parentId)) {
                swap(currentId, parentId, heap);
                currentId = parentId;
                parentId = (currentId - 1) / 2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            swap(0, heap.size() - 1, heap);
            int removed = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return removed;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        public void swap(int i, int j, List<Integer> heap) {
            Integer temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }
}
