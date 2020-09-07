package com.sbardyuk.algofun.graph;

import java.util.LinkedList;

public class Graph {
    private boolean isUndirected = false;
    int verticesNum;
    LinkedList<Integer> [] adjacencyArray;

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
}


