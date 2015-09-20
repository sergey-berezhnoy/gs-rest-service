package hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.dao.SpellBook;
import hello.domain.Spell;

@Component
public class HarryPotterMagicService implements MagicService {

	@Autowired
	private SpellBook spellBook;

	@Override
	public String getSpell() {
		return "Expelliarmus";
	}

	@Override
	public List<Spell> getSpellsByLevel(Integer level) {
		return spellBook.findByLevel(level);
	}

	@Override
	public Spell createOrUpdateSpell(Spell spell) {
		Spell existingSpell = spellBook.findByName(spell.getName());
		if (existingSpell != null) {
			existingSpell.setGood(spell.isGood());
			existingSpell.setLevel(spell.getLevel());
			return spellBook.save(existingSpell);
		} else {
			return spellBook.save(spell);
		}
	}

	@Override
	public Spell getSpellByName(String name) {
		return spellBook.findByName(name);
	}

}
