package com.sbardyuk.algofun.google3_warmup.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private int verticies = 0;
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    private boolean isUnidirected = false;

    public Graph(boolean isUnidirected) {
        this.isUnidirected = isUnidirected;
    }

    public Graph(int [][] graph, boolean isUnidirected) {
        this.isUnidirected = isUnidirected;

        for (int [] edge : graph) {
            addEdge(edge[0], edge[1]);
            if (!isUnidirected) {
                addEdge(edge[1], edge[0]);
            }
        }
        verticies = adjMap.size();
    }

    public void addEdge(int from, int to) {
        addEdgeInternal(from, to);
        if (!isUnidirected) {
            addEdgeInternal(to, from);
        }
    }

    private void addEdgeInternal(int from, int to) {
        List<Integer> list = adjMap.getOrDefault(from, new ArrayList<>());
        if (!list.contains(to)) {
            list.add(to);
            adjMap.put(from, list);
        }

        verticies = adjMap.size();
    }

    public void print() {
        for (Map.Entry<Integer, List<Integer>> entry : adjMap.entrySet()) {
            System.out.print("| " + entry.getKey() + " | => ");

            for (Integer v : entry.getValue()) {
                System.out.print("[ " + v + " ] ->");
            }

            System.out.println("");
        }
    }
}
