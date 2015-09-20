package hello.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import hello.domain.IngredientList;

public interface IngredientListDao extends MongoRepository<IngredientList, String> {

	public List<IngredientList> findByName(String name);

	public IngredientList getByName(String name);
}
