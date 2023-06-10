import java.util.ArrayList;

class User{

	public static ArrayList<User> users = new ArrayList<User>();

    private int id;
    private String username;
    private String password;
    private int role;

    public User(){

    }

    public User(int id,String username, String password, int role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId(){
        return id;
    }

    public String getUser(){
    	return username;
    }

    public String getPassword(){
    	return password;
    }

    public int getRole(){
    	return role;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setUser(String username){
    	this.username = username;
    }

    public void setPassword(String password){
    	this.password = password;
    }

    public void setRole(int role){
    	this.role = role;
    }
}
