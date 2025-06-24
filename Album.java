#package music_player_app;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

	private String name, artist;
	private ArrayList<Song> songs;
	
	
	public Album(String name, String artist) 
	{
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	
	public Boolean addSong(String title,double duration) 
	{
		if(findSong(title) == null) 
		{
			songs.add(new Song(title  , duration));
			System.out.println(title + "successfully added to the album");
			return true;
		}
		else 
		{
			System.out.println("Song with title "+ title +" already exist in the album");
			return false;
		}
	}

	private Song findSong(String title) {
		for(Song currentSong : songs) 
		{
			if(currentSong.getTitle().equalsIgnoreCase(title)) 
			{
				return currentSong;
			}
		}
		return null;
		
	}
	public boolean addToPlayList(int trackNo , LinkedList<Song> PlayList)
	{
		
		int index = trackNo - 1; // due to indexing starting from 0 
		if(index > 0 && index <= this.songs.size()) 
		{
			PlayList.add(this.songs.get(index));
			return true;
		}
		System.out.println("Oops song with track number "+trackNo+" was not found"  );
		return false;
	}
	public boolean addToPlayList(String title , LinkedList<Song> PlayList) 
	{
		for(Song currentSong : this.songs) 
		{
			if (currentSong.getTitle().equals(title)) 
			{
				PlayList.add(currentSong);
				return true;
			}
		}
		System.out.println("No song with the provided title was found");
		return false;
	}
	
	
}
