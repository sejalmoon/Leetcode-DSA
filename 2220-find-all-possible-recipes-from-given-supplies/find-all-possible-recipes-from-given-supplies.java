class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> visited = new HashMap<>();
        Map<String, List<String>> recipeIngredients = new HashMap<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));

        for(int i = 0; i<recipes.length; i++){
            recipeIngredients.put(recipes[i], ingredients.get(i));
        }

        for(String s:recipes){
            canMake(s, ans, recipeIngredients, visited, available);
        }

        return ans;
    }

    private boolean canMake(String s, List<String> ans, Map<String, List<String>> recipeIngredients, Map<String, Integer> visited, Set<String> available){
        if(visited.containsKey(s)){
            return visited.get(s) == 1;
        }

        if(available.contains(s)){
            return true;
        }

        if(!recipeIngredients.containsKey(s)){
            return false;
        }

        visited.put(s,0);

        for(String ingredient:recipeIngredients.get(s)){
            if(!canMake(ingredient, ans, recipeIngredients, visited, available)){
                visited.put(s,-1);
                return false;
            }
        }

        visited.put(s,1);
        ans.add(s);
        return true;

    }
}