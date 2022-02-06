package com.sbardyuk.algofun.google3_warmup.graph;

import java.util.*;

/**
 * Lazy Prims alg.
 * Time Complexity: O(ElogE)
 */
public class GraphPrims {

    static class GraphEdge implements Comparable<GraphEdge> {

        int from, to, cost;

        public GraphEdge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(GraphEdge o) {
            return cost - o.cost;
        }
    }

    static class Graph {
        Map<Integer, List<GraphEdge>> vertexToEdgeMap = new HashMap<>();

        public Graph(int n) {
            for (int i = 0; i < n; i ++) {
                vertexToEdgeMap.put(i, new ArrayList<>());
            }
        }

        public void addDirectedEdge(int from, int to, int cost) {
            vertexToEdgeMap.get(from).add(new GraphEdge(from, to, cost));
        }

        public void addUndirectedEdge(int from, int to, int cost) {
            addDirectedEdge(from, to, cost);
            addDirectedEdge(to, from, cost);
        }
    }

    private static class Prim {
        private final Graph g;

        private final PriorityQueue<GraphEdge> pq = new PriorityQueue<>();
        private final Set<Integer> visited = new HashSet<>();
        private final int expectedEdgeCount;

        private final List<GraphEdge> minSpanningTreeEdges = new ArrayList<>();
        private boolean minSpanningTreeExists = false;
        private int minSpanningTreeCost = 0;

        public Prim(Graph g) {
            this.g = g;
            expectedEdgeCount = g.vertexToEdgeMap.size() - 1;
        }

        public void prims() {
            addEdges(0);

            while (!pq.isEmpty() && minSpanningTreeEdges.size() != expectedEdgeCount) {
                GraphEdge edge = pq.poll();

                if (!visited.contains(edge.to)) {

                    minSpanningTreeEdges.add(edge);
                    minSpanningTreeCost += edge.cost;

                    addEdges(edge.to);
                }
            }

            minSpanningTreeExists = (minSpanningTreeEdges.size() == expectedEdgeCount);
        }

        private void addEdges(int vertex) {
            visited.add(vertex);

            for (GraphEdge e : g.vertexToEdgeMap.get(vertex)) {
                if (!visited.contains(e.to)) {
                    pq.offer(e);
                }
            }
        }

        public int getMinSpanningTreeCost() {
            return minSpanningTreeCost;
        }

        public boolean isMinSpanningTreeExists() {
            return minSpanningTreeExists;
        }

        public List<GraphEdge> getMinSpanningTreeEdges() {
            return minSpanningTreeEdges;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addUndirectedEdge( 0, 1, 5);
        g.addUndirectedEdge( 1, 2, 4);
        g.addUndirectedEdge( 2, 9, 2);
        g.addUndirectedEdge( 0, 4, 1);
        g.addUndirectedEdge( 0, 3, 4);
        g.addUndirectedEdge( 1, 3, 2);
        g.addUndirectedEdge( 2, 7, 4);
        g.addUndirectedEdge( 2, 8, 1);
        g.addUndirectedEdge( 9, 8, 0);
        g.addUndirectedEdge( 4, 5, 1);
        g.addUndirectedEdge( 5, 6, 7);
        g.addUndirectedEdge( 6, 8, 4);
        g.addUndirectedEdge( 4, 3, 2);
        g.addUndirectedEdge( 5, 3, 5);
        g.addUndirectedEdge( 3, 6, 11);
        g.addUndirectedEdge( 6, 7, 1);
        g.addUndirectedEdge( 3, 7, 2);
        g.addUndirectedEdge( 7, 8, 6);

        Prim prim = new Prim(g);
        prim.prims();

        if (prim.isMinSpanningTreeExists()) {
            System.out.println(prim.getMinSpanningTreeCost());
        }
    }
}
