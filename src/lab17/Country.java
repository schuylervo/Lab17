package lab17;

public class Country {


	private String name;
	private int population;
	
	public Country( ) {
		
	}
	
	public Country(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}
	
	public String getName( ) {
		return name;
	}
	
	public void setName( ) {
		this.name = name;
	}
	
	public int getPopulation( ) {
		return population;
	}
	
	public void setPopulation( ) {
		this.population = population;
	}
	
	@Override
	public String toString() {
		return name + "," + population;
	}

	
}
