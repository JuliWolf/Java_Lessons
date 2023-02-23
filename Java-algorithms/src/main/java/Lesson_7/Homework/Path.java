package Lesson_7.Homework;

import java.util.List;
import java.util.ArrayList;

public class Path {
    private int distance;
    private List<Integer> parentVertices;

    public boolean isAchieveTarget() {
        return isAchieveTarget;
    }

    private boolean isAchieveTarget;

    public void setAchieveTarget(boolean achieveTarget) {
        isAchieveTarget = achieveTarget;
    }

    public Path(int distance) {
        this.distance = distance;
        this.parentVertices = new ArrayList<>();
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List getParentVertices() {
        return parentVertices;
    }

    public void setParentVertices(List parentVertices) {
        this.parentVertices = parentVertices;
    }
}
