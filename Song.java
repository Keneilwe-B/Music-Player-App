#package music_player_app;

public class Song {
	
	String title ;
	double duration;

	public Song(String title  , double duration) 
	{
		this.title  = title ; // For the title  of the song 
		this.duration = duration; // For the duration of the song 
	}
	
	public String getTitle () 
	{
		return title ;
	}
	
	public double getDuration() 
	{
		return duration;
	}
	
	@Override 
	 public String toString()
	 {
		 return "Song: "+ title  + '\'' + ", duration " + duration;  
	 }
}
