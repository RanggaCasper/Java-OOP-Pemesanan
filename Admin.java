import java.util.Scanner;

class Admin extends User {

	private static Scanner scan = new Scanner(System.in);
	private static Cls cls = new Cls();
	private static Main main = new Main();
	private static Menu menu = new Menu();

	public Admin(){

	}

	// View Menu
	
	public static void viewMenu(){
	  	try {
	    	showMenu();
	    	int selectedMenu = chooseMenu();

	    	if (selectedMenu == 1) {
	    		viewMakanan();
	    		return;
	    	} else if (selectedMenu == 2) {
	    		viewUser();
	    		return;
	    	} else if (selectedMenu == 3) {
	    		main.login();
	    		return;
	    	} else {
	    		System.out.println("Menu tidak di temukan");
	    	}
	  	} catch (Exception e) {
	    	System.out.println("Error: Inputan yang anda masukan salah!");
	  	}
	}

	public static void viewMakanan(){
		String isContinue = "y";

	    while (isContinue.equals("y")) {
	      try {
	        showMakanan();
	        int selectedMenu = chooseMenu();

	        	if (selectedMenu == 1) {
	        		cls.cls();
	        		menu.listMenu();
	        	} else if (selectedMenu == 2) {
	        		addMakanan();
	        	} else if (selectedMenu == 3) {
	        		updateMakanan();
	        	} else if (selectedMenu == 4) {
	        		deleteMakanan();
	        	} else if (selectedMenu == 5) {	
	        		viewMenu();
	        		return;
	        	} else {
	        		System.out.println("Menu tidak di temukan");
	        	}
	      	} catch (Exception e) {
	        	System.out.println("Error: Inputan yang anda masukan salah!");
	      	}
      		System.out.print("Continue? (y): ");
	      	isContinue = scan.next();
	    }
	}

	public static void viewUser(){
		String isContinue = "y";

	    while (isContinue.equals("y")) {
	      try {
	        showUser();
	        int selectedMenu = chooseMenu();

	        	if (selectedMenu == 1) {
	        		listUser();
	        	} else if (selectedMenu == 2) {
	        		addUser();
	        	} else if (selectedMenu == 3) {
	        		updateUser();
	        	} else if (selectedMenu == 4) {
	        		deleteUser();
	        	} else if (selectedMenu == 5) {	
	        		viewMenu();
	        		return;
	        	} else {
	        		System.out.println("Menu tidak di temukan");
	        	}
	      	} catch (Exception e) {
	        	System.out.println("Error: Inputan yang anda masukan salah!");
	      	}
      		System.out.print("Continue? (y): ");
	      	isContinue = scan.next();
	    }
	}

	// End View Menu

	// Show Menu

	public static void showMenu() {
		cls.cls();
		System.out.println("==> Pemesanan Makanan dan Minuman");
		System.out.println("=================================");
		System.out.println("[1] Menu Makanan dan Minuman");
		System.out.println("[2] Menu User");
		System.out.println("[3] Logout");
		System.out.println("=================================");
	}

	public static void showMakanan(){
		cls.cls();
		System.out.println("==> Page Menu");
		System.out.println("=================================");
		System.out.println("[1] Lihat List Menu");
		System.out.println("[2] Tambah Menu");
		System.out.println("[3] Update Menu");
		System.out.println("[4] Hapus Menu");
		System.out.println("[5] Back");
		System.out.println("=================================");
	}

	public static void showUser(){
		cls.cls();
		System.out.println("==> Page User");
		System.out.println("=================================");
		System.out.println("[1] Lihat List User");
		System.out.println("[2] Tambah User");
		System.out.println("[3] Update User");
		System.out.println("[4] Hapus User");
		System.out.println("[5] Back");
		System.out.println("=================================");
	}

	// End Show Menu

	public static int chooseMenu() {
		System.out.print("choose menu : ");
		int pilihan = scan.nextInt();
		scan.nextLine();
		return pilihan;
	}

	// Method memanggil proses

	// User
	public static void listUser(){
		cls.cls();
		System.out.println("==> List User");
		System.out.println("==========================");
		for (User user : users) {
			System.out.println("ID User  : " + user.getId());
			System.out.println("Username : " + user.getUser());
			System.out.println("Password : " + user.getPassword());
			if (user.getRole() == 1) {
				System.out.println("Role     : [1] Admin");
			}else if (user.getRole() == 2) {
				System.out.println("Role     : [2] Customer");
			}
			System.out.println("=========================");
		}
	}

	public static void addUser(){
		cls.cls();
		User userAdd = new User();
		System.out.println("==> Form Tambah User");
		System.out.println("=========================");
		System.out.print("ID User : ");
		userAdd.setId(scan.nextInt());
		scan.nextLine();
		System.out.print("Username : ");
  		userAdd.setUser(scan.nextLine().toLowerCase());
  		System.out.print("Password : ");
  		userAdd.setPassword(scan.nextLine().toLowerCase());
		System.out.println("===[ Keterangan Role ]===");
		System.out.println("[1] Admin");
		System.out.println("[2] Customer");
		System.out.println("=========================");
		System.out.print("Role : ");
		userAdd.setRole(scan.nextInt());
		addUser(userAdd);
	}

	public static void updateUser(){
		cls.cls();
		listUser();
		User userEdit = new User();
		System.out.println("==> Form Update User");
		System.out.println("=========================");
		System.out.print("ID User : ");
		userEdit.setId(scan.nextInt());
		scan.nextLine();
		System.out.print("Username : ");
  		userEdit.setUser(scan.nextLine().toLowerCase());
  		System.out.print("Password : ");
  		userEdit.setPassword(scan.nextLine().toLowerCase());
		System.out.println("===[ Keterangan Role ]===");
		System.out.println("[1] Admin");
		System.out.println("[2] Customer");
		System.out.println("=========================");
		System.out.print("Role : ");
		userEdit.setRole(scan.nextInt());
		updateUser(userEdit);
	}

	public static void deleteUser(){
		cls.cls();
		listUser();
		User userDel = new User();
		System.out.println("==> Delete User");
		System.out.println("=========================");
		System.out.print("ID User : ");
		userDel.setId(scan.nextInt());
		deleteUser(userDel);
	}

	// Makanan
	public static void addMakanan(){
		cls.cls();
		Menu makananAdd = new Menu();
		System.out.println("==> Form Tambah Menu");
		System.out.println("=========================");
		System.out.print("ID Menu : ");
		makananAdd.setId(scan.nextInt());
		scan.nextLine();
		System.out.print("Nama Menu : ");
  		makananAdd.setMakanan(scan.nextLine());
  		System.out.println("===[ Keterangan Jenis ]===");
		System.out.println("[1] Makanan");
		System.out.println("[2] Minuman");
		System.out.println("=========================");
		System.out.print("Jenis : ");
		String jenis = checkJenis(scan.nextInt());
		makananAdd.setJenis(jenis);
  		System.out.print("Harga Menu : ");
  		makananAdd.setHarga(scan.nextFloat());
		addMakanan(makananAdd);
	}

	public static void updateMakanan(){
		cls.cls();
		menu.listMenu();
		Menu makananEdit = new Menu();
		System.out.println("==> Form Update Menu");
		System.out.println("=========================");
		System.out.print("ID Menu : ");
		makananEdit.setId(scan.nextInt());
		scan.nextLine();
		System.out.print("Nama Menu : ");
  		makananEdit.setMakanan(scan.nextLine());
  		System.out.print("Harga Menu : ");
  		makananEdit.setHarga(scan.nextFloat());
		updateMakanan(makananEdit);
	}

	public static void deleteMakanan(){
		cls.cls();
		menu.listMenu();
		Menu makananDel = new Menu();
		System.out.println("==> Delete Menu");
		System.out.println("=========================");
		System.out.print("ID Menu : ");
		makananDel.setId(scan.nextInt());
		deleteMakanan(makananDel);
	}

	// End Method pemangil proses

	// Method untuk eksekusi Proses

	// User
	public static void addUser(User userAdd){
		for (User existingUser : users) {
	        if (existingUser.getId() == userAdd.getId()) {
	            System.out.println("Error: Member dengan ID " + userAdd.getId() + " sudah ada!");
	            return;
	        }else if (existingUser.getUser().equals(userAdd.getUser())){
	        	System.out.println("Error: Member dengan Username " + userAdd.getUser() + " sudah ada!");
	            return;
	        }
	    }
	    users.add(userAdd);
	    System.out.println("User berhasil di tambahkan kedalam ArrayList");
	}

	public static void updateUser(User userEdit) {
	    int indexID = -1;

	    for (User user : users) {
	        if (user.getId() == userEdit.getId()) {
	            indexID = users.indexOf(user);
	            break;
	        }
	    }

	    if (indexID == -1) {
	        System.out.println("Error: Member dengan ID " + userEdit.getId() + " tidak ditemukan!"); 	
	    }

	    users.set(indexID, userEdit);
	    System.out.println("User dengan ID " + userEdit.getId() + " berhasil diupdate");
	}

	public static void deleteUser(User userDel){
		users.remove(userDel.getId() -1);
		System.out.println("User dengan ID " + userDel.getId() + " berhasil dihapus");
	}

	// Makanan
	public static void addMakanan(Menu makananAdd){
		for (Menu existingMakanan : menu.menus) {
	        if (existingMakanan.getMenu().equals(makananAdd.getMenu())) {
	            System.out.println("Error: Menu dengan Nama " + makananAdd.getMenu() + " sudah ada!");
	            return;
	        }else if(existingMakanan.getId() == makananAdd.getId()){
	        	System.out.println("Error: Menu dengan ID " + makananAdd.getId() + " sudah ada!");
	        	return;
	        }
	    }
	    menu.menus.add(makananAdd);
	    System.out.println("Makanan berhasil di tambahkan kedalam ArrayList");
	}

	public static void updateMakanan(Menu makananEdit) {
	    int indexID = -1;

	    for (Menu makan : menu.menus) {
	        if (makan.getId() == makananEdit.getId()) {
	            indexID = menu.menus.indexOf(makan);
	            break;
	        }
	    }

	    if (indexID == -1) {
	        System.out.println("Error: Menu dengan ID " + makananEdit.getId() + " tidak ditemukan!"); 	
	    }

	    menu.menus.set(indexID, makananEdit);
	    System.out.println("Menu dengan ID " + makananEdit.getId() + " berhasil diupdate");
	}

	public static void deleteMakanan(Menu makananDel){
		int indexID = -1;

	    for (Menu makan : menu.menus) {
	        if (makan.getId() == makananDel.getId()) {
	            indexID = menu.menus.indexOf(makan);
	            break;
	        }
	    }

	    if (indexID == -1) {
	        System.out.println("Error: Menu dengan ID " + makananDel.getId() + " tidak ditemukan!"); 	
	    }

		menu.menus.remove(indexID);
		System.out.println("Menu dengan ID " + makananDel.getId() + " berhasil dihapus");
	}

	private static String checkJenis(int jenis){
		if (jenis == 1) {
			return "Makanan";
		}
		return "Minuman";
	}
	// End Method untuk eksekusi Proses
}
