package com.sbardyuk.algofun.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphShortestPath {

    private static int findMin(Graph g, int source, int destination) {
        boolean[] visited = new boolean [g.verticesNum];
        int [] distanses = new int[g.verticesNum];
        for (int i = 0; i < g.verticesNum; i++) {
            distanses[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        visited[source] = true;
        distanses[0] = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            int currDist = distanses[node];

            for (Integer v : g.adjacencyArray[node]) {

                // TODO: uncomment this
//                if (v == destination) {
//                    return currDist + 1;
//                }

                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                    distanses[v] = currDist + 1;
                }
            }
        }

        // just for test
        for (int i = 0; i < g.verticesNum; i++) {
            System.out.println("d[" + i + "] = " + distanses[i]);
        }
        return distanses[destination];


        // return -1;
    }


    public static void main(String[] args) {
        Graph g = new Graph(6, true);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 5);
        g.addEdge(2, 4);
        g.addEdge(5, 4);

        System.out.println("min = " + findMin(g, 0, 4));

    }

}
