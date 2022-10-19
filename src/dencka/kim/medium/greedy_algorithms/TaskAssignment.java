package dencka.kim.medium.greedy_algorithms;

import java.util.*;

class TaskAssignment {
    public static void main(String[] args) {
        var tasks = new ArrayList<>(Arrays.asList(1, 3, 5, 3, 1, 4));
        System.out.println(taskAssignment(3, tasks));
    }

    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            int el = tasks.get(i);
            if (!map.containsKey(el)) map.put(el, new Stack<>());
            map.get(el).push(i);
        }
        Collections.sort(tasks);
        int l = 0, r = k * 2 - 1;
        while (l < r) {
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(map.get(tasks.get(l++)).pop());
            cur.add(map.get(tasks.get(r--)).pop());
            result.add(cur);
        }
        return result;
    }
}
