package ies.jandula.dragonBall.models;

/**
 * @author Juan Jurado
 */
public class DragonBall 
{
	/** Atributo - character */
	private String character;
	
	/** Atributo - powerLevel */
	private String powerLevel;
	
	/** Atributo - sagaMovie */
	private String sagaMovie;
	
	/** Atributo - dragonBallSeries */
	private String dragonBallSeries;

	/**
	 * @param character
	 * @param powerLevel
	 * @param sagaMovie
	 * @param dragonBallSeries
	 */
	public DragonBall(String character, String powerLevel, String sagaMovie, String dragonBallSeries) 
	{
		super();
		this.character = character;
		this.powerLevel = powerLevel;
		this.sagaMovie = sagaMovie;
		this.dragonBallSeries = dragonBallSeries;
	}

	/**
	 * @return character
	 */
	public String getCharacter()
	{
		return character;
	}

	/**
	 * @param character
	 */
	public void setCharacter(String character)
	{
		this.character = character;
	}

	/**
	 * @return powerLevel
	 */
	public String getPowerLevel()
	{
		return powerLevel;
	}

	/**
	 * @param powerLevel
	 */
	public void setPowerLevel(String powerLevel) 
	{
		this.powerLevel = powerLevel;
	}

	/**
	 * @return sagaMovie
	 */
	public String getSagaMovie() 
	{
		return sagaMovie;
	}

	/**
	 * @param sagaMovie
	 */
	public void setSagaMovie(String sagaMovie) 
	{
		this.sagaMovie = sagaMovie;
	}

	/**
	 * @return dragonBallSeries
	 */
	public String getDragonBallSeries()
	{
		return dragonBallSeries;
	}

	/**
	 * @param dragonBallSeries
	 */
	public void setDragonBallSeries(String dragonBallSeries)
	{
		this.dragonBallSeries = dragonBallSeries;
	}

	/**
	 * @toString
	 */
	@Override
	public String toString() 
	{
		return "character= " + character + ", powerLevel= " + powerLevel + ", sagaMovie= " + sagaMovie
				+ ", dragonBallSeries= " + dragonBallSeries;
	}	
	
}
