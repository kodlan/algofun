package com.sbardyuk.algofun;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.List;

public class JavaDataStructures {

    public static void main(String[] args) {

        Collection<Integer> collection = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));

        System.out.println("Collection");
        System.out.println(collection);
        collection.removeIf(x -> x > 2);
        System.out.println(collection);
        collection.retainAll(Arrays.asList(0, 1));
        System.out.println(collection);

        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5));

        System.out.println("LinkedList");
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        linkedList.addFirst(-1);
        linkedList.addLast(10);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.peek());
        System.out.println(linkedList);
        System.out.println(linkedList.poll());
        System.out.println(linkedList);
        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList);
        System.out.println(linkedList.pollLast());
        System.out.println(linkedList);

        Queue<Integer> queue = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        System.out.println("Queue");
        System.out.println(queue);
        queue.offer(6);
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);

        Deque<Integer> deque = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        System.out.println("Deque");
        System.out.println(deque);
        deque.offer(-1);
        deque.offerFirst(-2);
        deque.offerLast(10);
        System.out.println(deque);
        System.out.println(deque.peek());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 1, 2, 3, 4, 0));
        System.out.println(treeSet);
        System.out.println(treeSet.descendingSet());
        treeSet.add(10);
        System.out.println(treeSet.ceiling(6));
        System.out.println(treeSet.floor(6));
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.lower(6));
        System.out.println(treeSet.higher(6));
        System.out.println(treeSet.headSet(3));
        System.out.println(treeSet.tailSet(3));
        System.out.println(treeSet.subSet(2,4));
        System.out.println(treeSet.subSet(2, true, 4, true));

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Map.of(10, -2, 1, 10, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6));
        System.out.println(treeMap);
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.lastEntry());
        System.out.println(treeMap.headMap(4));
        System.out.println(treeMap.headMap(4, true));
        System.out.println(treeMap.tailMap(4, true));
        System.out.println(treeMap.subMap(4, 6));

        System.out.println(treeMap.ceilingEntry(7));
        System.out.println(treeMap.floorEntry(7));
        System.out.println(treeMap.ceilingKey(7));
        System.out.println(treeMap.floorKey(7));

        TreeMap<Integer,Integer> reverseTreeMap = new TreeMap<>(Collections.reverseOrder());
        reverseTreeMap.putAll(treeMap);
        System.out.println(reverseTreeMap);

        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(10, 1, 20, 2, 30, 3));
        System.out.println("LinkedHashSet");
        System.out.println(set);

        Map<Integer, Integer> map = new LinkedHashMap<>(Map.of(10, 1, 1, 2, 20, 1, -1, 0));

        System.out.println(map);

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());
        System.out.println(entries);
        entries.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Arrays.asList(10, 11, 1, 2, 3, 4, 5, 6, 7));
        System.out.println(minHeap);
        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(Arrays.asList(1, 2, 3, 4, 10, 10, 1, 3));
        System.out.println(maxHeap);
        while(!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}
