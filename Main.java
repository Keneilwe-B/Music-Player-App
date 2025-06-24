#package music_player_app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	private static ArrayList<Album> albums = new ArrayList<>();
	public static void main(String[] args) 
	{
		Album album  = new Album("Album 1", " J Cole");
		
		album.addSong("Love Yours", 3.40);
		album.addSong("Pride Is The Devil",4.43);
		albums.add(album);
		
		album  = new Album("Album 2 ", "Eminem");
		
		album.addSong("MockingBird", 4.43);
		album.addSong("Not Afraid", 5.87);
		albums.add(album);
		
		LinkedList<Song> PlayList1 = new LinkedList<>();
		
		albums.get(0).addToPlayList("Love Yours", PlayList1);
		albums.get(0).addToPlayList("Pride Is The Devil", PlayList1);
		
		albums.get(1).addToPlayList("MockingBird", PlayList1);
		albums.get(1).addToPlayList("Not Afraid", PlayList1);
		
		play(PlayList1);
	}
	private static void play(LinkedList<Song> PlayList) 
	{
		Scanner info = new Scanner(System.in);
		boolean quit = false,forward = true;
		ListIterator<Song> listIterator = PlayList.listIterator(); 		
		
		
		if(PlayList.size() == 0) 
		{
			System.out.println("Thi playlist has no songs ");
			
		}else 
		{
			System.out.println("Now playing : "+ listIterator.next().toString());
			printMenu();
		}
		while(!quit) 
		{
			int action = info.nextInt();
			info.nextLine();
			
			switch(action) 
			{
		
			case 0 :
				System.out.println("Playlist coomplete");
				quit = true;
				break;
			
			case 1 :
				if(!forward) 
				{
					if(listIterator.hasNext()) 
					{
						listIterator.next();
					}
					forward = true;
				}
				if(listIterator.hasNext()) 
				{
					System.out.println("Now playing : "+ listIterator.next().toString());
					
				}else 
				{
					System.out.println("No songs are available to play The playList is over");
					forward = false;
				}
				break;
				
			case 2 :
				if(forward) 
				{
					if(listIterator.hasPrevious()) 
					{
						listIterator.previous();
					}
					forward = false;
				}
				if(listIterator.hasPrevious()) 
				{
					System.out.println("Now playing: " + listIterator.previous().toString());
				
				}
				else 
				{
					System.out.println("This is the first song ");
					forward = false;
					
				}
				break;
				
				
			case 3 : 
				if(forward) 
				{
					if(listIterator.hasPrevious()) 
					{
						System.out.println("Now playing: " + listIterator.previous().toString());
						forward = false;
					}
					else 
					{
						System.out.println("We are at the start of the list");
					}
				}
				else 
				{
					if(listIterator.hasNext())
					{
						System.out.println("Now playing: " + listIterator.previous().toString());
						forward = true;
					}
					else 
					{
						System.out.println("We have reched the end of the list");
					}
				}
				break;
				
			case 4:
				printSongs(PlayList);
				break;
				
			case 5 :
				printMenu();
				break;
				
			case 6:
				if(PlayList.size() > 0) 
				{
					listIterator.remove();
					if(listIterator.hasNext()) 
					{
						System.out.println("Now playing: " + listIterator.next().toString());
					}
					else 
					{
						if(listIterator.hasPrevious())
						{
							System.out.println("Now playing: " + listIterator.previous().toString());
						}
					
					}
				}
			}
			
		}
	
	}
	
	private static void printMenu() 
	{
		System.out.println("Available options\n press");
		System.out.println("0 -> to Quit \n" + 
							"1 -> to play next song \n" +
							"2 -> to play previous song \n" +
							"3 -> to replay the current song \n" +
							"4 -> list all the songs \n" + 
							"5 -> print all the available options \n" + 
							"6 -> delete current song \n ");

	}
	
	private static void printSongs(LinkedList<Song> playList) 
	{
		Iterator<Song> iterator = playList.iterator();
		System.out.println("********************");
		
		while(iterator.hasNext()) 
		{
			System.out.println(iterator.next());
		}
		System.out.println("********************");
	}
	

}
