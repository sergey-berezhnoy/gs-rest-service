package hello.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import hello.domain.Spell;

public interface SpellBook extends MongoRepository<Spell, String>{

	public List<Spell> findByLevel(Integer level);
	public Spell findByName(String name);
}
