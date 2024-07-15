package com.coderscampus.assignment9.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.FileService;

@RestController
public class FileController {
	@Autowired
	FileService fileService;

	@GetMapping("/gluten-free")
	List<Recipe> glutenFreeRecipes() throws IOException {
		return fileService.readFile().stream().filter(x -> x.getGlutenFree().equals(true)).toList();
	}

	@GetMapping("/vegan")
	List<Recipe> veganRecipes() throws IOException {
		return fileService.readFile().stream().filter(x -> x.getVegan().equals(true)).toList();
	}

	@GetMapping("/vegan-and-gluten-free")
	List<Recipe> veganAndGlutenFreeRecipes() throws IOException {
//		List<Recipe> filterRecipe = new ArrayList<Recipe>();
//		List<Recipe> allRecipe = fileService.readFile();
//		for (Recipe recipe: allRecipe) {
//			if(recipe.getVegan() == true && recipe.getGlutenFree() == true ) {
//				filterRecipe.add(recipe);
//			}
//		}
		return fileService.readFile().stream()
				.filter(x -> x.getVegetarian().equals(true) && x.getGlutenFree().equals(true)).toList();
	}

	@GetMapping("/vegetarian")
	List<Recipe> vegetarianRecipes() throws IOException {
//		List<Recipe> filterRecipe = new ArrayList<Recipe>();
//		List<Recipe> allRecipe = fileService.readFile();
//		for (Recipe recipe: allRecipe) {
//			if(recipe.getVegetarian() == true) {
//				filterRecipe.add(recipe);
//			}
//		}
		return fileService.readFile().stream().filter(x -> x.getVegetarian().equals(true)).toList();
	}

	@GetMapping("/all-recipes")
	List<Recipe> allRecipes() throws IOException {
		return fileService.readFile();
	}
}
