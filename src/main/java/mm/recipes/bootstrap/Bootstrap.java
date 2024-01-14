package mm.recipes.bootstrap;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mm.recipes.domain.*;
import mm.recipes.repositories.CategoryRepository;
import mm.recipes.repositories.IngredientRepository;
import mm.recipes.repositories.RecipeRepository;
import mm.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        log.info("Loading units of measure...");
        Optional<UnitOfMeasure> eachUnitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Each");
        if (eachUnitOfMeasureOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM not found: Each");
        }
        UnitOfMeasure each = eachUnitOfMeasureOptional.get();

        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if (teaspoonUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM not found: Teaspoon");
        }
        UnitOfMeasure teaspoon = teaspoonUomOptional.get();

        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if (tablespoonUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM not found: Tablespoon");
        }
        UnitOfMeasure tablespoon = tablespoonUomOptional.get();

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if (cupUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM not found: Cup");
        }
        UnitOfMeasure cup = cupUomOptional.get();

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");
        if (ounceUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM not found: Ounce");
        }
        UnitOfMeasure ounce = ounceUomOptional.get();

        Optional<UnitOfMeasure> poundUomOptional = unitOfMeasureRepository.findByDescription("Pound");
        if (poundUomOptional.isEmpty()) {
            throw new RuntimeException("Expected UOM not found: Pound");
        }
        UnitOfMeasure pound = poundUomOptional.get();

        log.info("Loading categories...");

        Optional<Category> dessertCategoryOptional = categoryRepository.findByDescription("Dessert");
        if (dessertCategoryOptional.isEmpty()) {
            throw new RuntimeException("Expected Category not found: Dessert");
        }
        Category dessertCategory = dessertCategoryOptional.get();

        Optional<Category> snacksAndAppetizersCategoryOptional = categoryRepository.findByDescription("Snacks and Appetizers");
        if (snacksAndAppetizersCategoryOptional.isEmpty()) {
            throw new RuntimeException("Expected Category not found: Snacks and Appetizers");
        }
        Category snacksAndAppetizers = snacksAndAppetizersCategoryOptional.get();

        log.info("Loading recipes...");
        Recipe browniesRecipe = new Recipe();
        browniesRecipe.setDescription("Caramel Brownies");
        browniesRecipe.setPrepTime(20);
        browniesRecipe.setCookTime(35);
        browniesRecipe.setServings(12);
        browniesRecipe.setSource("https://www.simplyrecipes.com/caramel-swirl-brownie-recipe-5112069");
        browniesRecipe.setUrl("https://www.simplyrecipes.com/caramel-swirl-brownie-recipe-5112069");
        browniesRecipe.setDifficulty(Difficulty.MODERATE);
        browniesRecipe.setDirections("Make the caramel sauce:\n" +
                "I use this caramel recipe. It comes together in about 10 minutes. Once finished, let cool to room temperature and then place in the fridge to fully chill before making the brownie batter.\n" +
                "\n" +
                "Prepare the pan:\n" +
                "Preheat the oven to 325°F degrees. Coat an 8 x 8 square metal baking pan with cooking spray.\n" +
                "\n" +
                "Make a parchment sling by lining the pan with parchment paper and leaving an inch overhang on either side. This will make it easier to remove the brownies from the pan. Spray parchment and set aside.\n" +
                "\n" + "Prep dry ingredients:\n" +
                "In a small bowl whisk flour and cocoa to break up any cocoa clumps and set aside.\n" +
                "\n" +
                "Melt butter and chocolate:\n" +
                "In a large pot (4 quart), set over medium low heat, add the butter and chocolate. Stir until both are melted and fully combined. Remove from heat.\n" +
                 "\n" +
                "Add sugar, salt, and vanilla:\n" +
                "To the pot with the chocolate and butter add the granulated sugar, brown sugar, salt, and vanilla. The batter will look grainy.\n" +
                "\n" +
                "Add eggs:\n" +
                "Add eggs one at a time and stir vigorously after each addition until fully incorporated. The batter will become smooth and shiny. \n" +
                "\n" +
                "Finish batter:\n" +
                "Add flour and cocoa mixture to the batter. Use a spatula to stir it all together. The batter will be thick, and shiny like frosting.\n" +
                "\n" +
                "Transfer the batter and add the caramel:\n" +
                "Scrape batter into the prepared baking dish. Smooth the top with your spatula, if necessary. Measure out about 1/3 cup of caramel sauce into a dish. Your caramel should be able to drizzle off the end of your spoon in thick ribbons. If it’s too cool and thick to drizzle then zap it in the microwave for a few seconds until it is.\n" +
                "\n" +
                "Using a spoon create nine dollops of caramel evenly over the top of the brownie. I prefer to dip my spoon slightly below the surface of the brownie when adding the caramel just to incorporated it a little better. \n" +
                "\n" +
                "Swirl in caramel:\n" +
                "Use a knife swirl the caramel into “S” shapes throughout the batter. The batter is thick, so you are just swirling the very top layer. Leave some pockets of caramel. Sprinkle with flake salt, if using.\n" +
                "\n" +
                "Bake:\n" +
                "Bake for 35-40 minutes or until the brownies reach an internal temperature of 210°F. A toothpick won’t come out clean because of the caramel that melts into the batter and the fudgy nature of these brownies.\n" +
                "\n" +
                "When baked, the center stays very soft but shouldn’t be wet to the touch. The caramel will look melted and not very visible, but don’t worry, it will firm up as it cools.\n" +
                "\n" +
                "If you have a glass baking dish, you may need to add 10 to 15 minute to the cook time.\n" +
                "Drizzle with more caramel and enjoy:\n" +
                "Let brownies cool in the pan on a wire cooling rack to until room temperature. Drizzle with 3 to 4 tablespoons of additional caramel and another light sprinkle of sea salt. Serve.\n");

        Notes notes = new Notes();
        notes.setRecipeNotes(
                "Caramel Brownies are the perfect make ahead dessert. The caramel sauce can be made up to two weeks in advance and stored in the fridge.\n" +
                        "\n" +
                        "To store the brownies: Keep them covered on your counter for 3 or 4 days or up to one week in the refrigerator. \n" +
                        "To freeze the brownies: The brownies can be frozen for up to three months, but the texture of the caramel may not be as creamy as before freezing."
        );
        browniesRecipe.setNotes(notes);

        browniesRecipe.addIngredient(new Ingredient("Caramel Sauce", new BigDecimal("0.3"), cup));
        browniesRecipe.addIngredient(new Ingredient("All-purpose flour", new BigDecimal("1.25"), cup));
        browniesRecipe.addIngredient(new Ingredient("Dutch processed cocoa powder", new BigDecimal("0.25"), cup));
        browniesRecipe.addIngredient(new Ingredient("Unsalted butter", new BigDecimal("0.75"), cup));
        browniesRecipe.addIngredient(new Ingredient("Unsweetened chocolate, chopped", new BigDecimal("3"), ounce));
        browniesRecipe.addIngredient(new Ingredient("Granulated sugar", new BigDecimal("1.25"), cup));
        browniesRecipe.addIngredient(new Ingredient("Brown sugar", new BigDecimal("0.25"), cup));
        browniesRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal("1"), teaspoon));
        browniesRecipe.addIngredient(new Ingredient("Vanilla extract", new BigDecimal("2"), teaspoon));
        browniesRecipe.addIngredient(new Ingredient("Eggs", new BigDecimal("3"), each));
        browniesRecipe.addIngredient(new Ingredient("Flake salt, optional", new BigDecimal("0.5"), teaspoon));

        browniesRecipe.getCategories().add(dessertCategory);

        recipes.add(browniesRecipe);

        Recipe shrimpButterRecipe = new Recipe();
        shrimpButterRecipe.setDescription("Shrimp Butter");
        shrimpButterRecipe.setPrepTime(35);
        shrimpButterRecipe.setCookTime(10);
        shrimpButterRecipe.setServings(20);
        shrimpButterRecipe.setSource("https://www.simplyrecipes.com/shrimp-butter-recipe-6888965");
        shrimpButterRecipe.setUrl("https://www.simplyrecipes.com/shrimp-butter-recipe-6888965");
        shrimpButterRecipe.setDifficulty(Difficulty.EASY);
        shrimpButterRecipe.setDirections("Soak the onion:\n" +
                "In a small bowl, add the chopped onion and cover with cold water and an ice cube. Allow onion to sit in water for at least 5 minutes to let the flavor mellow. Afterward, drain from water, pat dry with a paper towel, and set aside.\n" +
                "\n" +
                "Poach the shrimp:\n" +
                "Meanwhile, fill a medium bowl with ice water for shocking the cooked shrimp. Set aside. \n" +
                "\n" +
                "Fill a medium saucepan with salted water and bring to a boil over high heat. Lower the heat to a simmer and add the shrimp. Cook until shrimp are completely pink and firm to the touch, 5-7 minutes.  \n" +
                "\n" +
                "Transfer to the bowl of ice water and let sit until cool enough to handle. Peel and, if necessary, devein. Then pat dry and transfer to a cutting board. \n" +
                "\n" +
                "Chop the shrimp:\n" +
                "Chop the shrimp very finely until it’s nearly a paste.  \n" +
                "\n" +
                "Beat the butter: \n" +
                "In a large bowl, beat the butter with a wooden spoon until smooth.\n" +
                "\n" +
                "Add the remaining ingredients:\n" +
                "Add the chopped shrimp and remaining 1 teaspoon salt, lemon zest and juice, Worcestershire sauce, herbs, pepper, and celery seed.\n" +
                "\n" +
                "Mash with the back of a fork (or continue using the wooden spoon) until all of the ingredients are well distributed. \n" +
                "\n" +
                "Serve:\n" +
                "Serve immediately with saltines (or any light, crisp cracker), or refrigerate in an airtight container for up to 1 week. Let come to room temperature at least 30 minutes before serving; when pliable, re-beat until spreadable and creamy.  \n" +
                "\n" +
                "Shrimp butter can be made ahead and frozen for up to 1 month. To store, spoon the butter onto a sheet of plastic wrap and roll into a log."
        );

        Notes shrimpButterNotes = new Notes();
        shrimpButterNotes.setRecipeNotes("Be sure to pat the shrimp dry; if they are wet, they won’t mix into the butter properly.");
        shrimpButterRecipe.setNotes(shrimpButterNotes);

        shrimpButterRecipe.addIngredient(new Ingredient("Small white onion, finely minced", new BigDecimal("0.5"), cup));
        shrimpButterRecipe.addIngredient(new Ingredient("Large shrimp, shell on", new BigDecimal("1.5"), pound));
        shrimpButterRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal("2"), teaspoon));
        shrimpButterRecipe.addIngredient(new Ingredient("Unsalted butter", new BigDecimal("1"), pound));
        shrimpButterRecipe.addIngredient(new Ingredient("Lemon zest", new BigDecimal("2"), teaspoon));
        shrimpButterRecipe.addIngredient(new Ingredient("Lemon juice", new BigDecimal("2"), tablespoon));
        shrimpButterRecipe.addIngredient(new Ingredient("Worcestershire sauce", new BigDecimal("1"), tablespoon));
        shrimpButterRecipe.addIngredient(new Ingredient("Finely chopped fresh parsley", new BigDecimal("0.25"), cup));
        shrimpButterRecipe.addIngredient(new Ingredient("Finely chopped fresh dill", new BigDecimal("0.25"), cup));
        shrimpButterRecipe.addIngredient(new Ingredient("Freshly ground black pepper", new BigDecimal("0.5"), teaspoon));
        shrimpButterRecipe.addIngredient(new Ingredient("Celery seed", new BigDecimal("0.5"), teaspoon));

        shrimpButterRecipe.getCategories().add(snacksAndAppetizers);

        recipes.add(shrimpButterRecipe);

        return recipes;
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
