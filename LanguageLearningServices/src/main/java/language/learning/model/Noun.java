package language.learning.model;

import java.io.Serializable;

public class Noun implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6952727842451731748L;
	private String inGerman;
	private Level level;

	public Noun(String inGerman, Level level) {
		super();
		this.inGerman = inGerman;
		this.level = level;
	}

	public String getInGerman() {
		return inGerman;
	}

	public void setInGerman(String inGerman) {
		this.inGerman = inGerman;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}
