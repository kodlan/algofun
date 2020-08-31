package com.sbardyuk.algofun.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        if (g.verticesNum < 1) {
            throw new IllegalArgumentException();
        }

        boolean[] visited = new boolean[g.verticesNum];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            visited[currentNode] = true;

            res.append(" -> ").append(currentNode);

            LinkedList<Integer> nodes = g.adjacencyArray[currentNode];

            for (Integer node : nodes) {
                if (! visited[node]) {
                    queue.add(node);
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
    }
}


