package com.bigelmo.algorithms.lesson7;

public class Main {
    public static void main(String[] args) {
        testGraph();
//        testDfs();
//        testBfs();
    }

    private static void testGraph() {

        Graph graph = new GraphImpl(10);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орёл");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 184);
        graph.addEdge("Москва", "Рязань", 201);
        graph.addEdge("Москва", "Калуга", 160);
        graph.addEdge("Тула", "Липецк", 295);
        graph.addEdge("Рязань", "Тамбов", 291);
        graph.addEdge("Калуга", "Орёл", 210);
        graph.addEdge("Тамбов", "Саратов", 384);
        graph.addEdge("Орёл", "Курск", 172);
        graph.addEdge("Липецк", "Воронеж", 134);
        graph.addEdge("Саратов", "Воронеж", 516);
        graph.addEdge("Курск", "Воронеж", 222);

        graph.findShortestWay("Москва", "Воронеж");
    }

    private static void testDfs() {
        Graph graph = new GraphImpl(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
    }

    private static void testBfs() {
        Graph graph = new GraphImpl(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "H");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");

        graph.bfs("A");
    }
}
