package model;

public class PrivatePlayList extends PlayList{
	private User user;
	
	public PrivatePlayList(String name, User user){
		super(name);
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
	
	private void setUser(User user){
		this.user = user;
	}
	
	
	/**
	*list songs in songs array
	*@return String with the songs list
	*/
	@Override
	public String listSongs(){
		String out = "";
		out += "=======================\n";
		out += super.getName()+"\n";
		out += "=======================\n";
		out += "Owner"+user.getNick()+"\n";
		out += "=======================\n";
		out += "      Songs            \n";
		for (int i = 0; i<super.getSongs().length; i++){
			if (super.getSongs()[i] != null){
				out += (i+1)+super.getSongs()[i].getTitle()+"\n";
			}
		}
		
		out += "Genres: "+ super.getGenres() + "\n";
		out += "duration: "+ super.getTime() + "\n";
		out += "=======================\n";
		
		return out;
		
	}
	
	/**
	*Adds a song to the songs list 
	*@param song a Song object !null
	*@return true if the operation is succesful otherwise false
	*/
	@Override
	public boolean addSongs(Song song){
		if (user.getNick().equals(nick) && user.getPassword().equals(password)){
			boolean found = false;
		for (int i = 0; i < super.getSongs().length && !found; i++){
			if (super.getSongs()[i] == null){
				super.getSongs()[i] = song;
				found = true;
			}
		}
		
		String[] prt = super.getGenres().split(", ");
		boolean genresExists = false;
		for (int i = 0; i< prt.length && !genresExists; i++){
			if (prt[i].equalsIgnoreCase(song.getGenre())){
				genresExists = true;
			}
		}
		
		if (!genresExists){
			super.setGenres(super.getGenres()+", "+song.getGenre());
		}
		
		super.setTime(super.getTime()+song.getTime());
		
		return true;
		}else{
			return false;
		}
	}
	
	
}