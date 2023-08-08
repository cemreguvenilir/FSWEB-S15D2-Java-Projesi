package model;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Task task1 = new Task("A", "desc1", "ann", Priority.HIGH, Status.IN_QUEUE);
        Task task2 = new Task("B", "desc2", "bob", Priority.MED, Status.ASSIGNED);
        Task task3 = new Task("C", "desc3", "carol", Priority.LOW, Status.IN_PROGRESS);
        Task task4 = new Task("D", "desc4", "bob", Priority.HIGH, Status.IN_QUEUE);
        Task task5 = new Task("E", "desc5", "ann", Priority.HIGH, Status.IN_QUEUE);
        Task task6 = new Task("F", "desc6", "", Priority.MED, Status.IN_QUEUE);
        Task task7 = new Task("E", "desc5", "ann", Priority.MED, Status.IN_QUEUE);

       Set<Task> totalTasks = new HashSet<>();
       totalTasks.add(task1);
       totalTasks.add(task2);
       totalTasks.add(task3);
       totalTasks.add(task4);
       totalTasks.add(task5);
       totalTasks.add(task6);

        Set<Task> annTasks = new LinkedHashSet<>();
        annTasks.add(task1);
        annTasks.add(task5);

        Set<Task> bobsTasks = new LinkedHashSet<>();
        bobsTasks.add(task2);
        bobsTasks.add(task4);


        Set<Task> carolsTasks = new LinkedHashSet<>();
        carolsTasks.add(task3);
        carolsTasks.add(task7);

        TaskData taskData = new TaskData(annTasks, bobsTasks, carolsTasks);
        //List<Set<Task>> tasks = new ArrayList<>();
        //tasks.add(annTasks);
        //tasks.add(bobsTasks);
        //tasks.add(carolsTasks);

        //System.out.println(taskData.getUnion(tasks));
        System.out.println(taskData.getTasks("all"));
        System.out.println(taskData.getTasks("ann"));

        //atanmamış
        System.out.println(taskData.getDifference(totalTasks, taskData.getTasks("all")));

        //birden fazla çalışana atanmış tasklar
        System.out.println("ann+carol" + taskData.getIntersect(annTasks, carolsTasks));

    }
}