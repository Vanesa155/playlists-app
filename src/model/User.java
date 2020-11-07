package model;

public class User{
	
	//should be a single word
	private String nick;
	
	private String password;
	private UserCategory category;
	private int sharedSongs;
	private int age;
	
	public User(String nick, String password, int age){
		this.nick = nick;
		this.password = password;
		this.category = UserCategory.NEWBIE;
		sharedSongs = 0;
		this.age = age;
		
	}
	
	public String getNick(){
		return nick;
	}
	
	public void setNick(String nick){
		this.nick = nick;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	} 
	
	public String getCategory(){
		return category+"";
	}
	
	public void setCategory(String category){
		this.category = UserCategory.valueOf(category);
	}
	
	/**
	*share a new song
	*/
	public void shareSong(){
		sharedSongs++;
		if (sharedSongs<= 3){
			this.category = UserCategory.NEWBIE;
		}else if (sharedSongs <= 10){
			this.category = UserCategory.LITTLE;
		}else if (sharedSongs<= 30){
			this.category = UserCategory.MILDCONTRIBUTOR;
		}else{
			category = UserCategory.STARCONTRIBUTOR;
		}
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getSharedSongs(){
		return sharedSongs;
	}
	
	public void setSharedSongs(int value){
		this.sharedSongs = sharedSongs;
	}
	
	
}