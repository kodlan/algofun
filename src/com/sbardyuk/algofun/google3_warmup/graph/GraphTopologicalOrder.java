package com.sbardyuk.algofun.google3_warmup.graph;

import java.util.*;

public class GraphTopologicalOrder {

    private static List<Integer> topoSort(Graph g) {
        List<Integer> sortOrder = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : g.inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        while(!queue.isEmpty()) {
            int source = queue.poll();

            sortOrder.add(source);

            for (Integer child : g.adjMap.get(source)) {
                int childInDegree = g.inDegree.get(child) - 1;
                g.inDegree.put(child, childInDegree);
                if (childInDegree == 0) {
                    queue.add(child);
                }
            }
        }

        if (sortOrder.size() != g.adjMap.size()) return Collections.emptyList();

        return sortOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = topoSort(new Graph(new int[][] {
                        { 3, 2 },
                        { 3, 0 },
                        { 2, 0 },
                        { 2, 1 } }, true));
        System.out.println(result);
    }
}
