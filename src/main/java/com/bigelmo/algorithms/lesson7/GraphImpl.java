package com.bigelmo.algorithms.lesson7;

import java.util.*;

public class GraphImpl implements Graph{

    private final List<Vertex> vertexList;
    private final boolean[][] adjMatrix;
    private final int[][] adjMatrixWeighed;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new boolean[maxVertexCount][maxVertexCount];
        this.adjMatrixWeighed = new int[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = true; ////////////!!!!
//        adjMatrix[endIndex][startIndex] = true; ////////////!!!!

        return true;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int distance) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrixWeighed[startIndex][endIndex] = distance;
        adjMatrixWeighed[endIndex][startIndex] = distance;

        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (String other : others) {
           result &= addEdge(startLabel, other);
        }

        return result;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public void findShortestWay(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(endLabel);
        if (startIndex == -1) {
            System.out.println("Label not found: " + startLabel);
        }
        if (finishIndex == -1) {
            System.out.println("Label not found: " + endLabel);
        }
        System.out.println("Available routes from " + startLabel + " to " + endLabel + ":");

        List<Vertex> roadMap = new ArrayList<>();
        int distance = 0;

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                if (vertex.equals(vertexList.get(finishIndex))) {
                    System.out.println(stack);
                    if (distance == 0) {
                        roadMap.addAll(stack);
                        roadMap.add(vertex);
                        distance = getDistance(roadMap);
                    } else {
                        List<Vertex> temp = new ArrayList<>(stack);
                        temp.add(vertex);
                        if (getDistance(temp) < distance) {
                            roadMap = temp;
                            distance = getDistance(roadMap);
                        }
                    }
                    stack.pop();
                } else {
                    visitVertex(stack, vertex);
                }
            } else {
                stack.pop();
            }
        }
        System.out.println("Shortest route is: ");
        System.out.println(roadMap);
        System.out.println();
        System.out.println("Distance: " + distance);
    }

    private int getDistance(List<Vertex> roadMap) {
        int result = 0;
        for (int i = 0; i < roadMap.size() - 1; i++) {
            int a = indexOf(roadMap.get(i).getLabel());
            int b = indexOf(roadMap.get(i+1).getLabel());
            result += adjMatrixWeighed[a][b];
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j]) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);

        for (int i = 0; i < getSize(); i++) {
            if (adjMatrixWeighed[currentIndex][i] > 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
//        System.out.println(vertex.getLabel() + " ");
        stack.push(vertex);
        vertex.setIsVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setIsVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
    }
}
