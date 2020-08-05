
public class Country {

	private String name;
	private int population;
	private boolean warmClimate;

	public Country() {

	}

	public Country(String name, int population, boolean warmClimate) {
		super();
		this.name = name;
		this.population = population;
		this.warmClimate = warmClimate;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getpopulation() {
		return population;
	}

	public void setpopulation(int population) {
		this.population = population;
	}

	public boolean warmClimate() {
		return warmClimate;
	}

	public void setRetired(boolean warmClimate) {
		this.warmClimate = warmClimate;
	}

	@Override
	public String toString() {
		return name + "~~~" + population + "~~~" + warmClimate;
	}

	
	}


