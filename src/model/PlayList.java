package model;
public class PlayList{
	private String name;
	private double time;
	private String genres;
	private Song[] songs;
	
	
	public PlayList(String name){
		this.name = name;
		time = 0;
		genres = "";
		songs = new Song[20];
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public double getTime(){
		return time;
	}
	
	public void setTime(double time){
		this.time = time;
	}
	
	public String getGenres(){
		return genres;
	}
	
	public void setGenres(String genres){
		this.genres = genres;
	}
	
	public Song[] getSongs(){
		return songs;
	}
	
	public void setSongs(Song[] songs){
		this.songs = songs;
	}
	
	/**
	*Adds a song to the songs list 
	*@param song a Song object !null
	*@return true if the operation is succesful otherwise false
	*/
	public boolean addSong(Song song){
		boolean found = false;
		for (int i = 0; i < songs.length && !found; i++){
			if (songs[i] == null){
				songs[i] = song;
				found = true;
			}
		}
		
		
		String[] prt = genres.split(", ");
		boolean genresExists = false;
		for (int i = 0; i< prt.length && !genresExists; i++){
			if (prt[i].equalsIgnoreCase(song.getGenre())){
				genresExists = true;
			}
		}
		
		if (!genresExists && found){
			genres += ", "+song.getGenre();
		}
		
		if (found){
			time += song.getTime();
		}
		
		return found;
		
	}
	
	/**
	*list songs in songs array
	*@return String with the songs list
	*/
	public String listSongs(){
		String out = "";
		out += "=======================\n";
		out += name+"\n";
		out += "=======================\n";
		out += "      Songs            \n";
		for (int i = 0; i<songs.length; i++){
			if (songs[i] != null){
				out += (i+1)+songs[i].getTitle()+"\n";
			}
		}
		
		out += "Genres: "+ genres + "\n";
		out += "duration: "+ time + "\n";
		out += "=======================\n";
		
		return out;
	}
 
}