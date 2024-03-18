package ies.jandula.dragonBall.models;

public class DragonBall 
{
	private String character;
	
	private String powerLevel;
	
	private String sagaMovie;

	private String dragonBallSeries;

	public DragonBall(String character, String powerLevel, String sagaMovie, String dragonBallSeries) 
	{
		super();
		this.character = character;
		this.powerLevel = powerLevel;
		this.sagaMovie = sagaMovie;
		this.dragonBallSeries = dragonBallSeries;
	}

	public String getCharacter()
	{
		return character;
	}

	public void setCharacter(String character)
	{
		this.character = character;
	}

	public String getPowerLevel()
	{
		return powerLevel;
	}

	public void setPowerLevel(String powerLevel) 
	{
		this.powerLevel = powerLevel;
	}

	public String getSagaMovie() 
	{
		return sagaMovie;
	}

	public void setSagaMovie(String sagaMovie) 
	{
		this.sagaMovie = sagaMovie;
	}

	public String getDragonBallSeries()
	{
		return dragonBallSeries;
	}

	public void setDragonBallSeries(String dragonBallSeries)
	{
		this.dragonBallSeries = dragonBallSeries;
	}

	@Override
	public String toString() 
	{
		return "character= " + character + ", powerLevel= " + powerLevel + ", sagaMovie= " + sagaMovie
				+ ", dragonBallSeries= " + dragonBallSeries;
	}	
	
}
