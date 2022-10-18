package dencka.kim.medium.stacks;

import java.util.*;

class MinMaxStackConstruction {
    static class MinMaxStack {
        List<Map<String, Integer>> minMax = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();

        public int peek() {
            return stack.get(stack.size() - 1);
        }

        public int pop() {
            minMax.remove(minMax.size() - 1);
            return stack.remove(stack.size() - 1);
        }

        public void push(Integer number) {
            stack.add(number);
            Map<String, Integer> newMinMax = new HashMap<>();
            if (minMax.isEmpty()) {
                newMinMax.put("max", number);
                newMinMax.put("min", number);
                minMax.add(newMinMax);
            } else {
                Map<String, Integer> prev = minMax.get(minMax.size() - 1);
                newMinMax.put("max", Math.max(prev.get("max"), number));
                newMinMax.put("min", Math.min(prev.get("min"), number));
                minMax.add(newMinMax);
            }
        }

        public int getMin() {
            return minMax.get(minMax.size() - 1).get("min");
        }

        public int getMax() {
            return minMax.get(minMax.size() - 1).get("max");
        }
    }
}
