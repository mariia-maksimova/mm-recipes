package mm.recipes.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mm.recipes.domain.Recipe;
import mm.recipes.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class RecipeService {
    private final RecipeRepository recipeRepository;
    public Set<Recipe> getAllRecipes() {
        log.debug("Getting all recipes");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }
}
