package model;

public class Pool{
	private User[] users;
	private Song[] songs;
	private PlayList[] playlists;
	
	public Pool(){
		users = new User[10];
		songs = new Song[30];
		playlists = new PlayList[20];
	}
	
	
	/**
	*Adds a new user to the users array
	*@param nick String !null !empty
	*@param password String !null !empty
	*@param age Integer >0
	*@return true if the operation was succesful otherwise return false
	*/
	public boolean addUser(String nick, String password,int age){
		boolean found = false;
		for (int i = 0; i< users.length && !found; i++){
			if (users[i] == null){
				users[i] = new User(nick,password,age);
				found = true;
			}
		}
		
		return found;
	}
	
	/**
	*Adds a song to the songs array 
	*@param title String !empty !null
	*@param artist String !empty !null
	*@param date String !empty !null
	*@param time double >= 0
	*@param genre String !null !empty
	*@return true if the operation was succesful otherwise return false
	*/
	public boolean addSong(String title, String artist, String date, double time, String genre){
		boolean found = false;
		
		for (int i = 0; i< songs.length && !found; i++){
			if (songs[i] == null){
				songs[i] = new Song(title,artist,date,time,genre);
				found = true;
			}
		}
		return found;
	}
	
	
	/**
	*Adds a playlist to the playlist array 
	*@param playlist the new playlist
	*@return true if the playlist was added otherwise return false
	*/
	public boolean addPlayList(PlayList playlist){
		boolean found = false;
		
		for (int i = 0; i < playlists.length && !found; i++){
			if (playlists[i] == null){
				playlists[i] = playlist;
				found = true;
			}
		}
		
		return found;
	}
	
	public Song[] getSongs(){
		return songs;
	}
	
	public void setSongs(Song[] songs){
		this.songs = songs;
	}
	
	public User[] getUsers(){
		return users;
	}
	
	public void setUsers(User[] users){
		this.users = users;
	}
	
	public PlayList[] getPlaylists(){
		return playlists;
	}
	
	public void setPlaylists(PlayList[] playlists){
		this.playlists = playlists;
	}
	
	/**
	*List the users in the users array
	*@return String with the users list
	*/
	public String listUsers(){
		String out = "************ Users***************\n";
		for (int i = 0; i < users.length; i++){
			if (users[i] != null){
				out +=  "name: "+users[i].getNick()+"\n";
				out +=  "Age: "+users[i].getAge()+"\n";
				out += "Category: "+users[i].getCategory()+"\n";
				out += "*****************************************\n";
			}
		}
		
		return out;
	}
	
	/**
	*List the songs in the songs array
	*@return String with the songs list 
	*/
	public String listSongs(){
		String out = "************** Songs ******************\n";
		for (int i = 0; i < songs.length; i++){
			if (songs[i] != null){
				out += "Title: "+songs[i].getTitle()+"\n";
				out += "Artist: "+songs[i].getArtist()+"\n";
				out += "Duration: "+songs[i].getTime()+"\n";
				out += "Genre: "+songs[i].getGenre()+"\n";
				out += "***************************************\n";
			}
		}
		return out;
	}
	
	
	/**
	*List playlists int playlists array 
	*@return String with the playlist list 
	*/
	public String listPlayList(){
		String out;
		out = "*************Playlists*******************\n";
		for (int i = 0; i<playlists.length; i++){
			out += playlists[i].listSongs();
		}
		
		return out;
	}
	
	/**
	*search a specific User 
	*@return the User asked if this is found otherwise return null
	*/
	public User searchUser(String nick){
		for (int i = 0; i < users.length; i++){
			if (users[i].getNick().equals(nick)){
				return users[i];
			}
		}
		return null;
		
	}
	
	/**
	*search a specific song 
	*@return the song asked if this is found otherwise return null 
	*/
	public Song searchSong(String title){
		for (int i = 0; i < songs.length; i++){
			if (songs[i].getTitle().equals(title)){
				return songs[i];
			}
		}
		return null;
	}
	
	/**
	*search a specific playlist 
	*@return the playlist asked if this is found otherwise return null 
	*/
	public PlayList searchPlaylist(String name){
		for (int i = 0; i < playlists.length; i++){
			if (playlists[i].getName().equals(name)){
				return playlists[i];
			}
		}
		return null;
	}
	
}