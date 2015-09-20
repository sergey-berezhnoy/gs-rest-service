package hello.service;

import java.util.List;

import hello.domain.Spell;

public interface MagicService {
	public String getSpell();
	public List<Spell> getSpellsByLevel(Integer level);
	public Spell getSpellByName(String name);
	public Spell createOrUpdateSpell(Spell spell);

}
