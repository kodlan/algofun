package com.sbardyuk.algofun.patterns.topologocal_sort;

import java.util.*;

public class TopologicalSort {

    static class Graph {
        int vertices;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        public Graph(int vertices, int [][] edges) {
            this.vertices = vertices;
            for (int i = 0; i < vertices; i++) {
                inDegree.put(i, 0);
                graph.put(i, new ArrayList<>());
            }

            for (int i = 0; i < edges.length; i++) {
                int parent = edges[i][0], child = edges[i][1];
                graph.get(parent).add(child);
                inDegree.put(child, inDegree.get(child) + 1);
            }
        }
    }

    public static List<Integer> sort(Graph graph) {
        List<Integer> sortedOrder = new ArrayList<>();

        // Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : graph.inDegree.entrySet()) {
            if (entry.getValue() == 0) sources.add(entry.getKey());
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.graph.get(vertex); // get the node's children to decrement their in-degrees
            for (int child : children) {
                graph.inDegree.put(child, graph.inDegree.get(child) - 1);
                if (graph.inDegree.get(child) == 0)
                    sources.add(child);
            }
        }

        if (sortedOrder.size() != graph.vertices) // topological sort is not possible as the graph has a cycle
            return new ArrayList<>();

        return sortedOrder;
    }

    static class GraphMy {
        int vertices;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();

        public GraphMy(int vertices, int [][] edges) {
            this.vertices = vertices;

            for (int i = 0; i < vertices; i ++) {
                in.put(i, 0);
                graph.put(i, new ArrayList<>());
            }

            for (int [] edge : edges) {
                int parent = edge[0];
                int child = edge[1];
                in.put(child, in.getOrDefault(child, 0) + 1);
                graph.get(parent).add(child);
            }
        }
    }

    static List<Integer> topologicalSortMy(GraphMy graph) {
        List<Integer> sortedOrder = new ArrayList<>();

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : graph.in.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        while (!sources.isEmpty()) {

            int source = sources.poll();

            sortedOrder.add(source);

            for (Integer child : graph.graph.get(source)) {
                int inForChild = graph.in.get(child);
                inForChild --;
                graph.in.put(child, inForChild);

                if (inForChild == 0) {
                    sources.add(child);
                }
            }
        }

        if (sortedOrder.size() != graph.vertices) {
            return new ArrayList<> ();
        }

        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = sort(new Graph(4,
                new int[][] {
                        new int[] { 3, 2 },
                        new int[] { 3, 0 },
                        new int[] { 2, 0 },
                        new int[] { 2, 1 } }));
        System.out.println(result);

        result = TopologicalSort.sort(new Graph(5,
                new int[][] {
                        new int[] { 4, 2 },
                        new int[] { 4, 3 },
                        new int[] { 2, 0 },
                        new int[] { 2, 1 },
                        new int[] { 3, 1 } }));
        System.out.println(result);

        result = TopologicalSort.sort(new Graph(7,
                new int[][] {
                        new int[] { 6, 4 },
                        new int[] { 6, 2 },
                        new int[] { 5, 3 },
                        new int[] { 5, 4 },
                        new int[] { 3, 0 },
                        new int[] { 3, 1 },
                        new int[] { 3, 2 },
                        new int[] { 4, 1 } }));
        System.out.println(result);


        result = topologicalSortMy(new GraphMy(4,
                new int[][] {
                        new int[] { 3, 2 },
                        new int[] { 3, 0 },
                        new int[] { 2, 0 },
                        new int[] { 2, 1 } }));
        System.out.println(result);

        result = topologicalSortMy(new GraphMy(5,
                new int[][] {
                        new int[] { 4, 2 },
                        new int[] { 4, 3 },
                        new int[] { 2, 0 },
                        new int[] { 2, 1 },
                        new int[] { 3, 1 } }));
        System.out.println(result);

        result = topologicalSortMy(new GraphMy(7,
                new int[][] {
                        new int[] { 6, 4 },
                        new int[] { 6, 2 },
                        new int[] { 5, 3 },
                        new int[] { 5, 4 },
                        new int[] { 3, 0 },
                        new int[] { 3, 1 },
                        new int[] { 3, 2 },
                        new int[] { 4, 1 } }));
        System.out.println(result);
    }
}
