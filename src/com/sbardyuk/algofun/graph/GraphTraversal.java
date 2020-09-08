package com.sbardyuk.algofun.graph;

import java.util.*;

public class GraphTraversal {

    public static String bfsTraversal(Graph g, int source) {
        StringBuilder res = new StringBuilder();

        boolean[] visited = new boolean[g.verticesNum];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            res.append(" -> ").append(currentNode);

            for (Integer node : g.adjacencyArray[currentNode]) {
                if (! visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }

        return res.toString();
    }

    public static String dfsTraversal(Graph g, int source) {
        StringBuilder res = new StringBuilder();

        boolean[] visited = new boolean[g.verticesNum];

        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            visited[currentNode] = true;

            res.append(" -> ").append(currentNode);

            for (Integer node : g.adjacencyArray[currentNode]) { // if we want this dfs to march dfs with recursion this should iterate in reverse order!!!
                if (! visited[node]) {
                    stack.push(node);
                }
            }
        }

        return res.toString();
    }

    /****** DFS Recursive implementation!!! ***/
    public static String dfsTraversalRecursive(Graph g, int source) {
        StringBuilder sb = new StringBuilder();

        boolean[] visited = new boolean[g.verticesNum];
        dfsRecursive(g, source, visited, sb);

        return sb.toString();
    }

    private static void dfsRecursive(Graph g, int current, boolean[] visited, StringBuilder sb) {
        visited[current] = true;

        sb.append(" -> ").append(current);

        for (int dest : g.adjacencyArray[current]) {
            if (!visited[dest])
                dfsRecursive(g, dest, visited, sb);
        }
    }
    /*********/

    private static boolean hasCycleRecursive(Graph g, int currentNode, boolean[] visited, int parent) {
        visited[currentNode] = true;

        for (Integer v : g.adjacencyArray[currentNode]) {
            if (! visited[v]) {
                if (hasCycleRecursive(g, v, visited, currentNode)) {
                    return true;
                }
            } else if (parent != v) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycle(Graph g) {
        boolean[] visited = new boolean[g.verticesNum];

        for (int i = 0; i < g.verticesNum; i++) {
            if (! visited[i]) {
                if (hasCycleRecursive(g, i, visited, -1)) {
                    return true;
                }

            }
        }
        return  false;

    }

    public static void main(String[] args) {
        Graph g = new Graph(5, false);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);

        g.print();

        System.out.println(bfsTraversal(g, 0));
        System.out.println(dfsTraversal(g, 0));
        System.out.println(dfsTraversalRecursive(g, 0));
        System.out.println(hasCycle(g));


        g = new Graph(5, false);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.addEdge(0,4);
        g.addEdge(1,4);
        g.addEdge(2,4);
        g.addEdge(3,4);

        g.print();

        System.out.println(bfsTraversal(g, 0));
        System.out.println(dfsTraversal(g, 0));
        System.out.println(dfsTraversalRecursive(g, 0));
        System.out.println(hasCycle(g));
    }
}
