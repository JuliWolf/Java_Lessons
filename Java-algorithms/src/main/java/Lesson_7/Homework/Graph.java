package Lesson_7.Homework;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, int width);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

    void findShortestWay(String startLabel, String endLabel);

    void clean();

}
