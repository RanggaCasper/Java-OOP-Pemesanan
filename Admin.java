import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;

class Admin extends User {

	private static Scanner scan = new Scanner(System.in);
	private static Cls cls = new Cls();
	private static Main main = new Main();
	private static Menu menu = new Menu();
	private static Transfer tf = new Transfer();

	public Admin(){

	}

	// View Menu
	
	public static void viewMenu(){
		String isContinue = "y";

	    while (isContinue.equals("y")) {
		  	try {
		    	showMenu();
		    	int selectedMenu = chooseMenu();

		    	while (selectedMenu < 1 || selectedMenu > 4) {
		          System.out.println("\tMaaf, tidak ada pilihan untuk menu yang kamu pilih");
		          selectedMenu = chooseMenu();
		        }

		    	if (selectedMenu == 1) {
		    		viewMakanan();
		    		return;
		    	} else if (selectedMenu == 2) {
		    		viewUser();
		    		return;
		    	} else if (selectedMenu == 3) {
		    		showTransfer();		    		
		    	} else if (selectedMenu == 4) {
		    		main.login();
		    		return;
		    	} else {
		    		System.out.println("\tMenu tidak di temukan");
		    	}
		  	} catch (InputMismatchException e) {
		    	System.out.println("\tError: Inputan yang anda masukan salah!");
		    	scan.nextLine();
		  	}
      		System.out.print("Continue? (y): ");
	      	isContinue = scan.next();
	    }
	}

	public static void viewMakanan(){
		String isContinue = "y";

	    while (isContinue.equals("y")) {
	      try {
	        showMakanan();
	        int selectedMenu = chooseMenu();

	        	while (selectedMenu < 1 || selectedMenu > 5) {
		          System.out.println("\tMaaf, tidak ada pilihan untuk menu yang kamu pilih");
		          selectedMenu = chooseMenu();
		        }

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
	        	}
	      	} catch (InputMismatchException e) {
	        	System.out.println("\tError: Inputan salah, inputan harus berupa angka!");
	        	scan.nextLine();
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

	        	while (selectedMenu < 1 || selectedMenu > 5) {
		          System.out.println("\tMaaf, tidak ada pilihan untuk menu yang kamu pilih");
		          selectedMenu = chooseMenu();
		        }

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
	        		System.out.println("\tMenu tidak di temukan");
	        	}
	      	} catch (InputMismatchException e) {
	        	System.out.println("\tError: Inputan salah, inputan harus berupa angka!");
	        	scan.nextLine();
	      	}
      		System.out.print("Continue? (y): ");
	      	isContinue = scan.next();
	    }
	}

	// End View Menu

	// Show Menu

	public static void showMenu() {
		cls.cls();
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████   PEMESANAN MAKANAN DAN MINUMAN   ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");
		System.out.println("\t[1] Menu Makanan dan Minuman");
		System.out.println("\t[2] Menu User");
		System.out.println("\t[3] Konfirmasi Pembayaran");
		System.out.println("\t[4] Logout\n");
		System.out.println("██████                                   ███████");
		System.out.println("████████████████████████████████████████████████");
	}

	public static void showMakanan(){
		cls.cls();
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████     MENU MAKANAN DAN MINUMAN      ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");
		System.out.println("\t[1] Lihat List Menu");
		System.out.println("\t[2] Tambah Menu");
		System.out.println("\t[3] Update Menu");
		System.out.println("\t[4] Hapus Menu");
		System.out.println("\t[5] Back\n");
		System.out.println("██████                                   ███████");
		System.out.println("████████████████████████████████████████████████");
	}

	public static void showUser(){
		cls.cls();
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████             MENU USER             ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");
		System.out.println("\t[1] Lihat List User");
		System.out.println("\t[2] Tambah User");
		System.out.println("\t[3] Update User");
		System.out.println("\t[4] Hapus User");
		System.out.println("\t[5] Back\n");
		System.out.println("████████████████████████████████████████████████");
	}

	public static void showTransfer(){
		cls.cls();
		tf.showTransfer();
	}

	// End Show Menu

	public static int chooseMenu() {
		System.out.print("██████ Choose Menu : ");
		int pilihan = scan.nextInt();
		scan.nextLine();
		return pilihan;
	}

	// Method memanggil proses

	// User
	public static void listUser(){
		cls.cls();
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████             LIST USER             ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");
		for (User user : users) {
			System.out.println("\tID User  : " + user.getId());
			System.out.println("\tUsername : " + user.getUser());
			System.out.println("\tPassword : " + user.getPassword());
			if (user.getRole() == 1) {
				System.out.println("\tRole     : [1] Admin");
			}else if (user.getRole() == 2) {
				System.out.println("\tRole     : [2] Customer");
			}
			System.out.println("------------------------------------------------");
		}
	}

	public static void addUser(){
		cls.cls();
		User userAdd = new User();
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████          FORM TAMBAH USER         ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");
		System.out.print("\tID User : ");
		userAdd.setId(scan.nextInt());
		scan.nextLine();
		System.out.print("\tUsername : ");
  		userAdd.setUser(scan.nextLine().toLowerCase());
  		System.out.print("\tPassword : ");
  		userAdd.setPassword(scan.nextLine().toLowerCase());
  		System.out.println();
		System.out.println("████████████████ KETERANGAN ROLE ███████████████\n");
		System.out.println("\t[1] Admin");
		System.out.println("\t[2] Customer\n");
		System.out.println("████████████████████████████████████████████████\n");
		System.out.print("\tRole : ");
		int role = scan.nextInt();
		while (role < 1 || role > 2) {
          	System.out.println("\tMaaf, tidak ditemukan role untuk inputan "+role);
          	System.out.print("\tRole : ");
          	role = scan.nextInt();
        }
		userAdd.setRole(role);
		addUser(userAdd);
	}

	public static void updateUser(){
		cls.cls();
		listUser();
		User userEdit = new User();
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████          FORM UPDATE USER         ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");
		System.out.print("\tID User : ");
		userEdit.setId(scan.nextInt());
		scan.nextLine();
		System.out.print("\tUsername : ");
  		userEdit.setUser(scan.nextLine().toLowerCase());
  		System.out.print("\tPassword : ");
  		userEdit.setPassword(scan.nextLine().toLowerCase());
  		System.out.println();
		System.out.println("████████████████ KETERANGAN ROLE ███████████████\n");
		System.out.println("\t[1] Admin");
		System.out.println("\t[2] Customer\n");
		System.out.println("████████████████████████████████████████████████\n");
		System.out.print("\tRole : ");
		int role = scan.nextInt();
		while (role < 1 || role > 2) {
          	System.out.println("\tMaaf, tidak ditemukan role untuk inputan "+role);
          	System.out.print("\tRole : ");
          	role = scan.nextInt();
        }
		userEdit.setRole(role);
		updateUser(userEdit);
	}

	public static void deleteUser(){
		cls.cls();
		listUser();
		User userDel = new User();
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████             HAPUS USER            ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");
		System.out.print("\tID User : ");
		userDel.setId(scan.nextInt());
		deleteUser(userDel);
	}

	// Makanan
	public static void addMakanan(){
		cls.cls();
		Menu makananAdd = new Menu();
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████          FORM TAMBAH USER         ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");
		System.out.print("\tID Menu : ");
		makananAdd.setId(scan.nextInt());
		scan.nextLine();
		System.out.print("\tNama Menu : ");
  		makananAdd.setMakanan(scan.nextLine());
  		System.out.println();
  		System.out.println("███████████████ KETERANGAN JENIS ███████████████\n");
		System.out.println("\t[1] Makanan");
		System.out.println("\t[2] Minuman\n");
		System.out.println("████████████████████████████████████████████████\n");
		System.out.print("\tJenis : ");
		String jenis = scan.nextLine();
		while (!jenis.equals("1") && !jenis.equals("2") ) {
          	System.out.println("\tMaaf, tidak ditemukan jenis untuk inputan "+jenis);
          	System.out.print("\tJenis : ");
          	jenis = scan.nextLine();
        }
        String cekJenis = checkJenis(jenis);
		makananAdd.setJenis(cekJenis);
  		System.out.print("\tHarga "+checkJenis(jenis)+" : ");
  		makananAdd.setHarga(scan.nextFloat());
		addMakanan(makananAdd);
	}

	public static void updateMakanan(){
		cls.cls();
		menu.listMenu();
		Menu makananEdit = new Menu();
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████          FORM UPDATE MENU         ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");
		System.out.print("\tID Menu : ");
		makananEdit.setId(scan.nextInt());
		scan.nextLine();
		System.out.print("\tNama Menu : ");
		makananEdit.setMakanan(scan.nextLine());
		System.out.println();
		System.out.println("███████████████ KETERANGAN JENIS ███████████████\n");
		System.out.println("\t[1] Makanan");
		System.out.println("\t[2] Minuman\n");
		System.out.println("████████████████████████████████████████████████\n");
		System.out.print("\tJenis : ");
		String jenis = scan.nextLine();
		while (!jenis.equals("1") && !jenis.equals("2") ) {
          	System.out.println("\tMaaf, tidak ditemukan jenis untuk inputan "+jenis);
          	System.out.print("\tJenis : ");
          	jenis = scan.nextLine();
        }
        String cekJenis = checkJenis(jenis);
		makananEdit.setJenis(cekJenis);
  		System.out.print("\tHarga Menu : ");
  		makananEdit.setHarga(scan.nextFloat());
		updateMakanan(makananEdit);
	}

	public static void deleteMakanan(){
		cls.cls();
		menu.listMenu();
		Menu makananDel = new Menu();
		String isContinue = "y";
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████     HAPUS MAKANAN DAN MINUMAN     ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");
		System.out.print("\tID Menu : ");
		makananDel.setId(scan.nextInt());
		deleteMakanan(makananDel);
	}

	// End Method pemangil proses

	// Method untuk eksekusi Proses

	// User
	public static void addUser(User userAdd){
		for (User existingUser : users) {
	        if (existingUser.getId() == userAdd.getId()) {
	            System.out.println("\tError: Member dengan ID " + userAdd.getId() + " sudah ada!");
	            return;
	        }else if (existingUser.getUser().equals(userAdd.getUser())){
	        	System.out.println("\tError: Member dengan Username " + userAdd.getUser() + " sudah ada!");
	            return;
	        }
	    }
	    users.add(userAdd);
	    System.out.println("\tUser berhasil di tambahkan.\n");
	    System.out.println("████████████████████████████████████████████████\n");
	}

	public static void updateUser(User userEdit) {
		String isContinue = "y";
		while (isContinue.equals("y")){
			try {
				int indexID = -1;

			    for (User user : users) {
			        if (user.getId() == userEdit.getId()) {
			            indexID = users.indexOf(user);
			            break;
			        }
			    }

			    users.set(indexID, userEdit);
			    System.out.println("\tUser dengan ID " + userEdit.getId() + " berhasil diupdate");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("\tError: User dengan ID " + userEdit.getId() + " tidak ditemukan!"); 	
			}
			System.out.print("Continue? (y): ");
	      	isContinue = scan.next();
	      	if (isContinue.equals("y")){
	      		viewUser();
	      	}else{
	      		System.exit(0);
	      	}
		}
	}

	public static void deleteUser(User userDel){
		String isContinue = "y";
		while (isContinue.equals("y")){
			try {
				int indexID = -1;

			    for (User user : users) {
			        if (user.getId() == userDel.getId()) {
			            indexID = users.indexOf(user);
			            break;
			        }
			    }

			    users.remove(indexID);
				System.out.println("\tUser dengan ID " + userDel.getId() + " berhasil dihapus");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("\tError: User dengan ID " + userDel.getId() + " tidak ditemukan!"); 	
			}
			System.out.print("Continue? (y): ");
	      	isContinue = scan.next();
	      	if (isContinue.equals("y")){
	      		viewUser();
	      	}else{
	      		System.exit(0);
	      	}
		}
	}

	// Makanan
	public static void addMakanan(Menu makananAdd){
		for (Menu existingMakanan : menu.menus) {
	        if (existingMakanan.getMenu().equals(makananAdd.getMenu())) {
	            System.out.println("\tError: Menu dengan Nama " + makananAdd.getMenu() + " sudah ada!");
	            return;
	        }else if(existingMakanan.getId() == makananAdd.getId()){
	        	System.out.println("\tError: Menu dengan ID " + makananAdd.getId() + " sudah ada!");
	        	return;
	        }
	    }
	    menu.menus.add(makananAdd);
	    System.out.println("\tMakanan berhasil di tambahkan.\n");
	    System.out.println("████████████████████████████████████████████████");
	}

	public static void updateMakanan(Menu makananEdit) {
		String isContinue = "y";
		while (isContinue.equals("y")){
			try {
			    int indexID = -1;

			    for (Menu makan : menu.menus) {
			        if (makan.getId() == makananEdit.getId()) {
			            indexID = menu.menus.indexOf(makan);
			            break;
			        }
			    }

			    menu.menus.set(indexID, makananEdit);
			    System.out.println("\tMenu dengan ID " + makananEdit.getId() + " berhasil diupdate");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("\tError: Menu dengan ID " + makananEdit.getId() + " tidak ditemukan!"); 	
			}
			System.out.print("Continue? (y): ");
	      	isContinue = scan.next();
	      	if (isContinue.equals("y")){
	      		viewMakanan();
	      	}else{
	      		System.exit(0);
	      	}
		}
	}

	public static void deleteMakanan(Menu makananDel){
		String isContinue = "y";
		while (isContinue.equals("y")){
			try {
				int indexID = -1;

			    for (Menu makan : menu.menus) {
			        if (makan.getId() == makananDel.getId()) {
			            indexID = menu.menus.indexOf(makan);
			            break;
			        }
			    }

			    menu.menus.remove(indexID);
				System.out.println("\tMenu dengan ID " + makananDel.getId() + " berhasil dihapus");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("\tError: Menu dengan ID " + makananDel.getId() + " tidak ditemukan!"); 	
			}
			System.out.print("Continue? (y): ");
	      	isContinue = scan.next();
	      	if (isContinue.equals("y")){
	      		viewMakanan();
	      	}else{
	      		System.exit(0);
	      	}
		}
	}

	private static String checkJenis(String jenis){
		if (jenis.equals("1")) {
			return "Makanan";
		}
		return "Minuman";
	}
	// End Method untuk eksekusi Proses
}
