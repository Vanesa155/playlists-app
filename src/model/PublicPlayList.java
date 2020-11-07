package model;

public class PublicPlayList extends PlayList{
	
	// should contains a number with the total calification 
	private double rate;
	
	// number of recived qualifications 
	private int attempts;
	
	public PublicPlayList(String name){
		super(name);
		rate = 0;
		attempts = 0;
	}
	
	/**
	*Adds a new rate to the playlist
	*@param rate the new rate
	*/
	public void ratePlayList(double rate){
		this.rate += rate;
		this.attempts++;
	}
	
	public double getRate(){
		return  (rate/attempts);
	}
	
	/**
	*list songs in songs array
	*@return String with the songs list
	*/
	@Override
	public String listSongs(){
		String str;
		str = "Name: "+super.getName()+"\n";
		str+= "Duration: "+super.getTime()+"\n";
		str+= "Genres: "+super.getGenres()+"\n";
		str+= "Rate: "+rate+"\n";
		
		return str;
	}
}