package Lesson_7.Homework;

public class Main {
    public static void main(String[] args) {
        testGraph();
    }

    private static void testGraph() {

        Graph graph = new GraphImpl(7);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");

        graph.addEdge("Москва", "Тула", 5);
        graph.addEdge("Москва", "Рязань", 3);
        graph.addEdge("Тула", "Липецк", 4);
        graph.addEdge("Липецк", "Воронеж", 6);
        graph.addEdge("Липецк", "Саратов", 1);
        graph.addEdge("Рязань", "Тамбов", 2);
        graph.addEdge("Тамбов", "Саратов", 4);
        graph.addEdge("Саратов", "Воронеж", 8);

        System.out.println("Size of graph is " + graph.getSize());
//        graph.display();

        graph.findShortestWay("Москва", "Воронеж");
        graph.clean();
        graph.findShortestWay("Тула", "Воронеж");
        graph.clean();
        graph.findShortestWay("Липецк", "Саратов");
        graph.clean();
        graph.findShortestWay("Липецк", "Воронеж");
        graph.clean();
        graph.findShortestWay("Рязань", "Саратов");
    }
}
