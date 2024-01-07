package mm.recipes.controllers;

import lombok.AllArgsConstructor;
import mm.recipes.domain.Category;
import mm.recipes.domain.Recipe;
import mm.recipes.domain.UnitOfMeasure;
import mm.recipes.repositories.CategoryRepository;
import mm.recipes.repositories.UnitOfMeasureRepository;
import mm.recipes.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.Set;

@Controller
@AllArgsConstructor
public class IndexController {

    private final RecipeService recipeService;

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage(Model model) {
        Set<Recipe> recipes = recipeService.getAllRecipes();

        model.addAttribute("recipes", recipes);
        return "index";
    }
}
