package Heap;

import java.util.*;

class MedianFinder {
    List<Integer> list;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> pq = new PriorityQueue<>( new Comparator<Integer>() {
        public int compare(Integer lhs, Integer rhs) {
            return compare(rhs, lhs);
        }
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();


    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNumBinarySearch(int num) {
            if(list.size() == 0){
                list.add(num);
            }
            else{
                int index = binarySearchItr(list, num);

                int i = list.size() - 1;
                while(i >= index){
                        //int temp = list.get(i + 1);
                        if(i + 1 == list.size())
                            list.add(i + 1, list.get(i));
                        else
                            list.set(i + 1, list.get(i));
                        i--;
                }
                if(index == list.size())
                    list.add(index, num);
                else
                    list.set(index, num);

            }



    }

    public void addNumHeaps(int num) {
        int n = maxHeap.size() + minHeap.size();
        if(n == 0){
            minHeap.add(num);
        }
        else{
            if(num >= minHeap.peek()){
                minHeap.add(num);
                if(minHeap.size()> n / 2 + 1){
                    maxHeap.add(minHeap.poll());
                }
            }
            else{
                maxHeap.add(num);
                if(maxHeap.size()> (n + 1) / 2){
                    minHeap.add(maxHeap.poll());

                }
            }
        }
    }

    int binarySearchItr(List<Integer> list, int x)
    {
        int l = 0, r = list.size() - 1;
        int m = -1;
        while (l <= r) {
             m = l + (r - l) / 2;

            // Check if x is present at mid
            if (list.get(m) == x)
                return m;

            // If x greater, ignore left half
            if (list.get(m) < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return l > m ? l : m;
    }

    public double findMedianHeap() {
        int length = maxHeap.size() + minHeap.size();
        if(length % 2 != 0)
            return minHeap.peek();
        else
            return (double)(minHeap.peek() + maxHeap.poll()) / 2;
    }

    public double findMedian() {
        int length = list.size();
        int middleIndex = length / 2;
        if(length % 2 != 0)
            return list.get(middleIndex);
        else
            return (double)(list.get(middleIndex) + list.get(middleIndex - 1)) / 2;
    }
}

public class FindMedianInDataStream {


    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( new Comparator<Integer>() {
            public int compare(Integer lhs, Integer rhs) {
                return compare(rhs, lhs);
            }
        });

        MedianFinder obj = new MedianFinder();
        obj.addNumHeaps(-1);
        System.out.println(obj.findMedianHeap());
        obj.addNumHeaps(-2);
        System.out.println(obj.findMedianHeap());
        obj.addNumHeaps(-3);
        System.out.println(obj.findMedianHeap());
        obj.addNumHeaps(-4);
        System.out.println(obj.findMedianHeap());
        obj.addNumHeaps(-5);
        System.out.println(obj.findMedianHeap());
        obj.addNumHeaps(15);


    }
}

