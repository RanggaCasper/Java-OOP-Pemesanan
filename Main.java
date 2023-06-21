import java.util.Scanner;
import java.util.ArrayList;

class Main{

	private static Scanner scan = new Scanner(System.in);
	private static User user = new User();
	private static Admin admin = new Admin();
	private static Customer customer = new Customer();
    private static Cls cls = new Cls();
    private static Menu menu = new Menu();

	public static void main(String[] args) {
		initUser();
  		login();
  	}

  	private static int isValidLogin(String username, String password) {
        for (User userLogin : user.users) {
            if (userLogin.getUser().equals(username) && userLogin.getPassword().equals(password)) {
              	if (userLogin.getRole() == 1) {
              		return 1; // role admin return 1
              	}else{
              		return 2; // role customer return 2
              	}
            }
        }
        return 0;
    }

    public static void login(){
        cls.cls();
        System.out.println("\t██╗░░░░░░█████╗░░██████╗░██╗███╗░░██╗");
        System.out.println("\t██║░░░░░██╔══██╗██╔════╝░██║████╗░██║");
        System.out.println("\t██║░░░░░██║░░██║██║░░██╗░██║██╔██╗██║");
        System.out.println("\t██║░░░░░██║░░██║██║░░╚██╗██║██║╚████║");
        System.out.println("\t███████╗╚█████╔╝╚██████╔╝██║██║░╚███║");
        System.out.println("\t╚══════╝░╚════╝░░╚═════╝░╚═╝╚═╝░░╚══╝\n");
        System.out.println("\t         Start your Session\n");
        System.out.print("\tUsername : ");
        String username = scan.nextLine().toLowerCase();
        System.out.print("\tPassword : ");
        String password = scan.nextLine().toLowerCase();
        customer.setCustomer(username);
        int valid = isValidLogin(username,password);
        
        if (valid == 1) {
            admin.viewMenu();
            return;
        }else if (valid == 2) {
            customer.viewMenu();
            return;
        }else{
            System.out.println("Maaf Username atau Password yang anda masukan salah!!");
            cls.cls();
            login();
        }
    }

    private static void initUser(){
    	// 1 = admin
    	// 2 = customer
    	User user1 = new User(1,"admin","admin",1);
    	User user2 = new User(2,"c","c",2);
    	User user3 = new User(3,"rangga","rangga",1);
        User user4 = new User(4,"a","a",2);

        Menu menu1 = new Menu(1,"Nasi Goreng","Makanan",10000);
        Menu menu2 = new Menu(2,"Ayam Geprek","Makanan",10000);
        Menu menu3 = new Menu(3,"Sate Kaming","Makanan",15000);
        Menu menu4 = new Menu(4,"Es Teh","Minuman",3000);
        Menu menu5 = new Menu(5,"Teh Poci","Minuman",4000);

    	user.users.add(user1);
    	user.users.add(user2);
    	user.users.add(user3);
        user.users.add(user4);

        menu.menus.add(menu1);
        menu.menus.add(menu2);
        menu.menus.add(menu3);
        menu.menus.add(menu4);
        menu.menus.add(menu5);
    }
}