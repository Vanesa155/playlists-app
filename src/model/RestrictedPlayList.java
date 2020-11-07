package model;

public class RestrictedPlayList extends PlayList{
	
	// max Size should be 5
	private User[] users;
	
	public RestrictedPlayList(String name){
		super(name);
		this.users = new User[5];
	}
	
	public User[] getUsers(){
		return users;
	}
	
	public void setUsers(User[] users){
		this.users = users;
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
				out += "      Songs            \n";
				for (int j = 0; j<super.getSongs().length; j++){
					if (super.getSongs()[j] != null){
						out += (j+1)+super.getSongs()[j].getTitle()+"\n";
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
	public boolean addSong(Song song){
		
				boolean found = false;
				for (int j = 0; j < super.getSongs().length && !found; j++){
					if (super.getSongs()[j] == null){
						super.getSongs()[j] = song;
						found = true;
					}
				}
		
				String[] prt = super.getGenres().split(", ");
				boolean genresExists = false;
				for (int j = 0; j< prt.length && !genresExists; j++){
					if (prt[j].equalsIgnoreCase(song.getGenre())){
						genresExists = true;
					}
				}
		
				if (!genresExists && found){
					super.setGenres(super.getGenres()+", "+song.getGenre());
				}
		
				super.setTime(super.getTime()+song.getTime());
		
				return found;
	}
	
	/**
	*Adds a new user to the playlist's owners
	*@param User object referd to the new owner
	*@return true if the operation was succesful otherwise returns false
	*/
	public boolean addUser(User user){
		boolean found = false;
		
		for (int i = 0; i < users.length && !found; i++){
			if (users[i] == null){
				users[i] = user;
				found = true;
			}
		}
		
		return found;
	}
	
}