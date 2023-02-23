package Lesson_7.Homework;

import Lesson_7.lesson.Vertex;

import java.util.*;

public class GraphImpl implements Graph {
    private final int INFINITY = 100000000;
    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;

    private int visitedVertexCount;
    private int currentVertexIndex;
    private int distToCurrentVertex;

    private List<Path> shortestPaths;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
        shortestPaths = new ArrayList<>();

        setDefaultValues();
    }

    private void setDefaultValues () {
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                adjMatrix[i][j] = INFINITY;
            }
        }
    }


    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int width) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = width;

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
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    sb.append(" -> ").append(adjMatrix[i][j]).append(" ").append(vertexList.get(j));
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
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
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
        System.out.println();
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !vertexList.get(i).isVisited() ) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }

        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.remove();
            }
        }
        System.out.println();
    }
    
    @Override
    public void findShortestWay(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }

        if (endIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + endIndex);
        }

        Vertex startVertex = vertexList.get(startIndex);

        startVertex.setVisited(true);
        visitedVertexCount++;
        for (int i = 0; i < vertexList.size(); i++) {
            int tempDist = adjMatrix[startIndex][i];
            Path path = new Path(tempDist);
            path.getParentVertices().add(startIndex);

            if (i == endIndex) {
                path.setAchieveTarget(true);
            }

            shortestPaths.add(path);
        }

        while (visitedVertexCount < getSize()) {
            int indexMin = getMin();
            int minDist = shortestPaths.get(indexMin).getDistance();

            if (minDist == INFINITY) {
                currentVertexIndex = indexMin++;
                distToCurrentVertex = shortestPaths.get(currentVertexIndex).getDistance();
            } else {
                currentVertexIndex = indexMin;
                distToCurrentVertex = minDist;
            }

            vertexList.get(currentVertexIndex).setVisited(true);
            visitedVertexCount++;
            updateShortestPaths(startIndex);
        }

        displayPaths();
    }

    public int getMin () {
        int minDist = INFINITY;
        int indexMin = 0;
        for (int i = 1; i < getSize(); i++) {
            int distance = shortestPaths.get(i).getDistance();
            if (!vertexList.get(i).isVisited() && distance < minDist) {
                minDist = distance;
                indexMin = i;
            }
        }
        return indexMin;
    }

    public void updateShortestPaths (int startIndex) {
        int vertexIndex = startIndex + 1;

        while (vertexIndex < getSize()) {
            if (vertexList.get(vertexIndex).isVisited()) {
                vertexIndex++;
                continue;
            }

            int currentToVertex = adjMatrix[currentVertexIndex][vertexIndex];

            int startToVertex = distToCurrentVertex + currentToVertex;

            int shortPathDistance = shortestPaths.get(vertexIndex).getDistance();

            if (startToVertex < shortPathDistance) {
                Path path = shortestPaths.get(vertexIndex);
                List<Integer> newParents = new ArrayList<>(shortestPaths.get(currentVertexIndex).getParentVertices());
                newParents.add(currentVertexIndex);
                path.setParentVertices(newParents);
                path.setDistance(startToVertex);
            }
            vertexIndex++;
        }
    }

    private void displayPaths() {
        for (int i = 0; i < getSize(); i++) {
            Path path = shortestPaths.get(i);
            if (!path.isAchieveTarget()) {
                continue;
            }

            System.out.print(vertexList.get(i).getLabel() + " = ");

            if (path.getDistance() == INFINITY) {
                System.out.println("0");
            } else {
                String result = shortestPaths.get(i).getDistance() + " (";
                List<Integer> parents = shortestPaths.get(i).getParentVertices();
                for (int j = 0; j < parents.size(); j++) {
                    result += vertexList.get(parents.get(j)).getLabel() + " -> ";
                }
                System.out.println(result + vertexList.get(i).getLabel() + ")");
            }
        }
    }

    public void clean () {
        visitedVertexCount = 0;

        for (int i = 0; i < getSize(); i++) {
            vertexList.get(i).setVisited(false);
        }

        shortestPaths = new ArrayList<>();
    }
}
