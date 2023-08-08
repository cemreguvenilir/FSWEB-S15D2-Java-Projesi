package model;

import java.util.*;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;


    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;

    }



    public Set<Task> getTasks(String task){
        if("ann".equals(task)){
            return annsTasks;
        } else if ("bob".equals(task)){
            return bobsTasks;
        } else if ("carol".equals(task)){
            return carolsTasks;
        } else if("all".equals(task)){
            List<Set<Task>> allTasks = new ArrayList<>();
            allTasks.add(annsTasks);
            allTasks.add(bobsTasks);
            allTasks.add(carolsTasks);
            return getUnion(allTasks);

            /**Set<Task> allTasks = new HashSet<>();
            allTasks.addAll(annsTasks);
            allTasks.addAll(bobsTasks);
            allTasks.addAll(carolsTasks);
            return allTasks;*/

        }
        return new HashSet<>();
    }
    public Set<Task> getUnion(List<Set<Task>> taskList){
        Set<Task> union = new HashSet<>();
        for (Set<Task> tasks: taskList){
            union.addAll(tasks);
        }
        return union;
    }
    public Set<Task> getIntersect(Set<Task> set1, Set<Task> set2){
        Set<Task> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);
        return intersect;
    }

    public Set<Task> getDifference(Set<Task> set1, Set<Task> set2){
        Set<Task> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }
}
