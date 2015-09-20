package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.domain.Spell;
import hello.service.MagicService;

@RestController
public class SpellController {
	
    @Autowired
    private MagicService magicService;

    @RequestMapping(value = "/spell", method = RequestMethod.GET)
    public List<Spell> readSpells(@RequestParam(value="level", defaultValue="1") Integer level) {
        return magicService.getSpellsByLevel(level);
    }
    
    @RequestMapping(value = "/spell/{name}", method = RequestMethod.GET)
    public Spell readSpell(@PathVariable(value="name") String name) {
        return magicService.getSpellByName(name);
    }
    
    @RequestMapping(value = "/spell", method = RequestMethod.POST)
    public Spell writeSpell(@RequestBody Spell spell) {
        return magicService.createOrUpdateSpell(spell);
    }

}
