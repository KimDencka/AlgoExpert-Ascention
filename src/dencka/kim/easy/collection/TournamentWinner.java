package dencka.kim.easy.collection;

import java.util.*;

class TournamentWinner {
    public static void main(String[] args) {
        List<List<String>> competitions =
                List.of(List.of("HTML", "C#"),
                        List.of("C#", "Python"),
                        List.of("Python", "HTML"));

        List<Integer> results = List.of(0, 0, 1);

        System.out.println(tournamentWinner(competitions, results));
    }

    public static String tournamentWinner(
            List<List<String>> competitions,
            List<Integer> results
    ) {
        HashMap<String, Integer> map = new HashMap<>();
        String res = "";
        int max = 0;
        for (int i = 0; i < competitions.size(); i++) {
            int compResult = results.get(i);
            String winner = competitions.get(i).get(compResult == 0 ? 1 : 0);
            int oldScore = map.getOrDefault(winner, 0);
            int newScore = oldScore + 3;
            if (max < newScore) {
                max = newScore;
                res = winner;
            }
            map.put(winner, newScore);
        }
        return res;

//        Map<String, Integer> map = new HashMap<>();
//        int i = 0;
//        for (List<String> comp : competitions) {
//            if (results.get(i) == 0) {
//                if (map.containsKey(comp.get(1))) {
//                    map.put(comp.get(1), map.get(comp.get(1)) + 3);
//                } else {
//                    map.put(comp.get(1), 3);
//                }
//            } else {
//                if (map.containsKey(comp.get(0))) {
//                    map.put(comp.get(0), map.get(comp.get(0)) + 3);
//                } else {
//                    map.put(comp.get(0), 3);
//                }
//            }
//            i++;
//        }
//        return Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
}
