package ui;

import model.*;
import java.util.Scanner;
public class Menu{
	private Pool pool;
	private Scanner sc;
	
	public Menu(){
		pool = new Pool();
		sc = new Scanner(System.in);
	}
	
	
	/**
	*controls the ui flow
	*/
	public void start(){
		System.out.println(logo());
		menu();
	}
	
	/**
	*gets String with the logo
	*@return String with the logo
	*/
	private String logo(){
		String out = "";
		out +="	(((((((((((((((((((((((((((((((((((((((((((((((((\n";
		out +="	((((((((((((((((/((((((((((((((((((((((((((((((((\n";
		out +="	(((/  .(((((((*  .((((((*        (((((/      /(((\n";
		out +="	(((/   .((((((.  .(((((   ,((((((((((*  .((((((((\n";
		out +="	(((/    /((((/   .((((/  ,(((((((((((.  /((((((((\n";
		out +="	(((/     ((((*   .((((*  ,(((((((((((/   ((((((((\n";
		out +="	(((/  *  *(((     ((((*  ,((((((((((((,  .(((((((\n";
		out +="	(((/  /.  ((*     ((((*  *(((((((((((((,   ((((((\n";
		out +="	(((/  //  ,(  .   ((((*  *((((((((((((((/   /((((\n";
		out +="	(((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((\n";
		out +="	(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((\n";
		out +="	(((/  .((    ((   /((((  .(((((((((((((((((.  /((\n";
		out +="	(((/  .((.  .((.  *((((,  *((((((((((((((((   /((\n";
		out +="	(((/  .((((((((.  *(((((   *((((/,/(((((((/   (((\n";
		out +="	(((/  .((((((((.  *((((((.        *((   .   .((((\n";
		out +="	(((((((((((((((/*/((((((((((///(((((((////(((((((\n";
		out +="	(((((((((((((((((((((((((((((((((((((((((((((((((\n";
		return out;
	}
	
	/**
	*controls menu 
	*/
	private void menu(){
		boolean finished = false;
		
		do{
			System.out.println(showMenu());
			finished = manageOptions();
		}while (!finished);
	}
	
	/**
	*gets the menu options 
	*@return String with options
	*/
	private String showMenu(){
		String out;
		out = "================================================\n";
		out +="         WellCome to the main menu              \n";
		out +="================================================\n";
		out +="1. Register new User \n";
		out +="2. List Users\n";
		out +="3. Create song\n";
		out +="4. List songs\n";
		out +="5. create Playlist \n";
		out +="6. Add songs to playlist \n";
		out +="7. Add Users to playlist \n";
		out +="8. Rate Playlist \n";
		out +="9. List Playlist \n";
		out +="10. Exit \n";
		
		return out;
	}
	
	
	/**
	*controls choice related to the options
	*@return true if the program have finished, otherwise returns false
	*/
	private boolean manageOptions(){
		int choice = Integer.parseInt(sc.nextLine());
		
		switch (choice){
			case 1: addUser(); break;
			case 2: listUsers(); break;
			case 3: addSong(); break;
			case 4: listSongs(); break;
			case 5: createPlaylist(); break;
			case 6: addSongToPlaylist(); break;
			case 7: addUserToPlaylist(); break;
			case 8: ratePlaylist(); break;
			case 9: listPlaylists(); break;
			case 10: System.out.println("Thankyou for beeing here"); return true;
		}
		return false;
	}
	
	private void addUser(){
		System.out.println("Please type your nick name in a single word");
		String name = sc.nextLine();
		System.out.println("please type your age");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("please type your password");
		String pw = sc.nextLine();
		boolean added = pool.addUser(name,pw,age);
		
		if (added){
			System.out.println("User added succeful");
		}else{
			System.out.println("you can't add more users");
		}
	}
	
	/**
	*Adds a new user
	*/
	private void listUsers(){
		System.out.println(pool.listUsers());
	}
	
	
	/**
	*Adds a new song
	*/
	private void addSong(){
		System.out.println("Please type the song's title");
		String title = sc.nextLine();
		System.out.println("Please type the artist's name");
		String artist = sc.nextLine();
		System.out.println("Please type the date in DD/MM/AAAA format");
		String date = sc.nextLine();
		System.out.println("Please type the song's durations");
		double time = Double.parseDouble(sc.nextLine());
		System.out.println("Please type the genre: ROCK, HIPHOP, CLASSIC, REGGAE, SALSA, METAL");
		String genre = sc.nextLine();
		
		boolean added = pool.addSong(title,artist,date,time,genre);
		
		if (added){
			System.out.println("The song has been added succesfully");
		}else{
			System.out.println("You can't add more songs");
		}
		
		
	}
	
	/**
	*list all songs
	*/
	private void listSongs(){
		System.out.println(pool.listSongs());
	}
	
	/**
	*creates a new playlist
	*/
	private void createPlaylist(){
		System.out.println("your playlist is: 1. private, 2. restricted, 3. public");
		int choice = Integer.parseInt(sc.nextLine());
		
		switch (choice){
			case 1: createPrivatePlayList(); break;
			case 2: createRestrictedPlayList(); break;
			case 3: createPublicPlayList(); break;
			default: System.out.println("Invalid choice");
		}
	}
	
	
	/**
	*creates a private playlist
	*/
	private void createPrivatePlayList(){
		System.out.println("Type the playlist's name");
		String name = sc.nextLine();
		System.out.println("Please type the owner's name");
		User user = pool.searchUser(sc.nextLine());
		if (user != null){
			if (pool.addPlayList(new PrivatePlayList(name,user))){
				System.out.println("PlayList Added succesful");
			}else{
				System.out.println("You can't add more playlists");
			}
		}else{
			System.out.println("The nickName isn't registered ");
		}
	}
	
	/**
	*creates a restricted playlist
	*/
	private void createRestrictedPlayList(){
		System.out.println("Type the name of the playlist");
		String name = sc.nextLine();
		PlayList playlist = new RestrictedPlayList(name);
		if (pool.addPlayList(playlist)){
			System.out.println("Playlist added succesfully");
		}else{
			System.out.println("You can't add more playlist");
		}
	}
	
	/**
	*creates a public playlist
	*/
	private void createPublicPlayList(){
		System.out.println("Please type the playlist's name");
		String name = sc.nextLine();
		PlayList playlist = new PublicPlayList(name);
	}
	
	/**
	*adds a song to one specific playlist
	*/
	private void addSongToPlaylist(){
		System.out.println("Type the playlist's name");
		PlayList playlist = pool.searchPlaylist(sc.nextLine());
		
		if (playlist != null){
			System.out.println("Please type the song's name");
			Song song = pool.searchSong(sc.nextLine());
			if (song != null){
				if (playlist.addSong(song)){
					System.out.println("Song added succesful");
				}else{
					System.out.println("You can't add more songs to this playlist");
				}
			}else{
				System.out.println("The song isn't registered");
			}
		}else{
			System.out.println("The playlist doesn't exist");
		}
	}
	
	/**
	*adds a user to specific playlist
	*/
	private void addUserToPlaylist(){
		System.out.println("Type the playlist's name");
		RestrictedPlayList playlist = (RestrictedPlayList)pool.searchPlaylist(sc.nextLine());
		
		if (playlist != null && playlist instanceof RestrictedPlayList){
			System.out.println("Type the User's name");
			User user = pool.searchUser(sc.nextLine());
			if (user != null){
				if (playlist.addUser(user)){
					System.out.println("Operation done succesfully");
				}else{
					System.out.println("The Operation can't be done");
				}
			} else{
				System.out.println("The user doesn't exist");
			}
		}else{
			System.out.println("The operation can't be done");
		}
	}
	
	/**
	*rate a specific playlist
	*/
	private void ratePlaylist(){
		System.out.println("Please type the playList's name");
		PublicPlayList playlist = (PublicPlayList)pool.searchPlaylist(sc.nextLine());
		
		if (playlist != null && playlist instanceof  PublicPlayList){
			System.out.println("Type the playlist rate");
			playlist.ratePlayList(Double.parseDouble(sc.nextLine()));
		}else{
			System.out.println("Operation can't be done");
		}
	}
	
	/**
	*list playlists
	*/
	private void listPlaylists(){
		System.out.println(pool.listPlayList());
	}
	
	
}
