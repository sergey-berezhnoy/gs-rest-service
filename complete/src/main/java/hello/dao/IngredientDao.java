package hello.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import hello.domain.Ingredient;

public interface IngredientDao extends MongoRepository<Ingredient, String> {
	public List<Ingredient> findByName(String name);

	public Ingredient getByName(String name);

	public List<Ingredient> findByRecipeIsTrue();

	public List<Ingredient> findByRecipeIsFalse();

	public List<Ingredient> findByPriceLessThan(int price);

	public List<Ingredient> findByPriceGreaterThan(int price);

}
