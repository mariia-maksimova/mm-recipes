package mm.recipes.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mm.recipes.domain.Recipe;
import mm.recipes.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@AllArgsConstructor
@Slf4j
public class IndexController {

    private final RecipeService recipeService;

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage(Model model) {
        log.debug("Getting index page");
        Set<Recipe> recipes = recipeService.getAllRecipes();

        model.addAttribute("recipes", recipes);
        return "index";
    }
}
