package com.sbardyuk.algofun.google3_warmup.graph;

import java.util.*;

public class GraphTraversal {

    private static String bfsTraversal(Graph g, int root) {
        StringBuilder sb = new StringBuilder();

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int v = queue.poll();

            if (!visited.contains(v)) {
                visited.add(v);

                sb.append(" ").append(v).append(" -> ");

                queue.addAll(g.adjMap.get(v));
            }
        }

        return sb.toString();
    }

    private static String dfsTraversal(Graph g, int root) {
        StringBuilder sb = new StringBuilder();

        Set<Integer> visited = new HashSet<>();

        Stack<Integer> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            int v = stack.pop();

            if (!visited.contains(v)) {
                visited.add(v);

                sb.append(" ").append(v).append(" -> ");

                g.adjMap.get(v).forEach(stack::push);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        Graph g = new Graph(new int[][] { {0, 1}, {0, 2}, {1, 3}, {1, 4} }, false);

        System.out.println("g2:");
        g.print();

        System.out.println();
        System.out.println("BFS:");
        System.out.println(bfsTraversal(g, 0));
        System.out.println(dfsTraversal(g, 0));

    }
}
