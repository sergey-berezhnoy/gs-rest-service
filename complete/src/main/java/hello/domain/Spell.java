package hello.domain;

import org.springframework.data.annotation.Id;

public class Spell {
	public Spell(String name, int level, boolean good) {
		this.setGood(good);
		this.name = name;
		this.level = level;
	}
	public Spell(){}
	@Id
	private String id;
	private String name;
	private boolean good;
	private int level;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public boolean isGood() {
		return good;
	}
	public void setGood(boolean good) {
		this.good = good;
	}

}
