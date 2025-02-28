import java.util.*;

class NumberContainers {
    private Map<Integer, Integer> indexMap; // Maps index -> number
    private Map<Integer, TreeSet<Integer>> numberMap; // Maps number -> sorted indexes

    public NumberContainers() {
        indexMap = new HashMap<>();
        numberMap = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexMap.containsKey(index)) {
            int oldNumber = indexMap.get(index);
            if (numberMap.containsKey(oldNumber)) {
                numberMap.get(oldNumber).remove(index);
                if (numberMap.get(oldNumber).isEmpty()) {
                    numberMap.remove(oldNumber);
                }
            }
        }

        indexMap.put(index, number);
        numberMap.putIfAbsent(number, new TreeSet<>());
        numberMap.get(number).add(index);
    }

    public int find(int number) {
        if (!numberMap.containsKey(number) || numberMap.get(number).isEmpty()) {
            return -1;
        }
        return numberMap.get(number).first();
    }
}
