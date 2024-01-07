package mm.recipes.controllers;

import lombok.AllArgsConstructor;
import mm.recipes.domain.Category;
import mm.recipes.domain.UnitOfMeasure;
import mm.recipes.repositories.CategoryRepository;
import mm.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("Italian");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category Id is: " + (categoryOptional.isPresent() ? categoryOptional.get().getId() : "Not found"));
        System.out.println("UOM Id is: " + (unitOfMeasureOptional.isPresent() ? unitOfMeasureOptional.get().getId() : "Not found"));

        return "index";
    }
}
