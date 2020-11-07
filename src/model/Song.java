package model;
public class Song{
	private String title;
	private String artist;
	private String date;
	private double time;
	private MusicalGenre genre;
	
	
	public Song(String title, String artist, String date, double time, String genre){
		this.title = title;
		this.artist = artist;
		this.date = date;
		this.time = time;
		this.genre = MusicalGenre.valueOf(genre);
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getArtist(){
		return artist;
	}
	
	public void setArtist(String artist){
		this.artist = artist;
	}
	
	public String getDate(){
		return date;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	public double getTime(){
		return time;
	}
	
	public void setTime(double time){
		this.time = time;
	}
	
	public String getGenre(){
		return genre+"";
	}
	
	public void setGenre(String genre){
		this.genre = MusicalGenre.valueOf(genre);
	}
}