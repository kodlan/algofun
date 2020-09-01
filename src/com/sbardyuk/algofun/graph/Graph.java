package com.sbardyuk.algofun.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private boolean isUndirected = false;
    private int verticesNum;
    private LinkedList<Integer> [] adjacencyArray;

    @SuppressWarnings("unchecked")
    public Graph(int verticesNum, boolean isUndirected) {
        this.verticesNum = verticesNum;
        this.isUndirected = isUndirected;
        this.adjacencyArray = new LinkedList[verticesNum];

        for (int i = 0; i < verticesNum; i++) {
            adjacencyArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        if (source < verticesNum && source >= 0 && destination < verticesNum && destination >= 0) {
            adjacencyArray[source].add(destination);

            if (!isUndirected) {
                adjacencyArray[destination].add(source);
            }
            return;
        }

        throw new IllegalArgumentException();
    }

    public void print() {
        for (int i = 0; i < verticesNum; i ++) {
            System.out.print("| " + i + " | => ");

            for (Integer v : adjacencyArray[i]) {
                System.out.print("[ " + v + " ] ->");
            }

            System.out.println("");
        }
    }

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
        visited[source] = true;

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();

            res.append(" -> ").append(currentNode);

            for (Integer node : g.adjacencyArray[currentNode]) {
                if (! visited[node]) {
                    stack.push(node);
                    visited[node] = true;
                }
            }
        }

        return res.toString();
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
    }
}


