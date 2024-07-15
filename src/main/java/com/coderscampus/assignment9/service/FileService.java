package com.coderscampus.assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.coderscampus.assignment9.domain.Recipe;

public class FileService {
	private String fileName;

	public FileService(String fileName) throws IOException {
		this.fileName = fileName;
	}

	@SuppressWarnings("null")
	public List<Recipe> readFile() throws IOException {
		List<Recipe> recipeList = new ArrayList<Recipe>();
		Reader in = new FileReader(fileName);
		@SuppressWarnings("deprecation")
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().withFirstRecordAsHeader()
				.withEscape('\\').parse(in);
		for (CSVRecord record : records) {
			Integer cookingMinutes = Integer.parseInt(record.get(0));
			Boolean dairyFree = Boolean.parseBoolean(record.get(1));
			Boolean glutenFree = Boolean.parseBoolean(record.get(2));
			String instructions = record.get(3);
			Double preparationMinutes = Double.parseDouble(record.get(4));
			Double pricePerServing = Double.parseDouble(record.get(5));
			Integer readyInMinutes = Integer.parseInt(record.get(6));
			Integer servings = Integer.parseInt(record.get(7));
			Double spoonacularScore = Double.parseDouble(record.get(8));
			String title = record.get(9);
			Boolean vegan = Boolean.parseBoolean(record.get(2));
			Boolean vegetarian = Boolean.parseBoolean(record.get(2));

			Recipe recipe = new Recipe(cookingMinutes, dairyFree, glutenFree, instructions, preparationMinutes,
					pricePerServing, readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian);
			recipeList.add(recipe);
			System.out.println(recipe.toString());
		}
		return recipeList;
	}
}
