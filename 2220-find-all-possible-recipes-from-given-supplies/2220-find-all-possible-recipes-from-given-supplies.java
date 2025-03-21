import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> result = new ArrayList<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        boolean run = true;

        while (run) {
            run = false;
            for (int i = 0; i < recipes.length; i++) {
                if (available.contains(recipes[i]))
                    continue;
                boolean isSuple = true;

                for (String ingredient : ingredients.get(i)) {
                    if (!available.contains(ingredient)) {
                        isSuple = false;
                        break;
                    }
                }

                if (isSuple) {
                    available.add(recipes[i]);
                    result.add(recipes[i]);
                    run = true;
                }
            }
        }
        return result;
    }
}
