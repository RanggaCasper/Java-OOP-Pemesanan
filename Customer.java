import java.util.Scanner;

class Customer extends Pesanan {

	private static Menu menu = new Menu();
	private static Scanner scan = new Scanner(System.in);
	private static Cls cls = new Cls();
	private static Main main = new Main();

	public void viewMenu(){
		String isContinue = "y";

	    while (isContinue.equals("y")) {
	      try {
	        showMenu();
	        int selectedMenu = chooseMenu();
	        	if (selectedMenu == 1) {
	        		cls.cls();
	        		menu.listMenu();
	        	} else if (selectedMenu == 2) {
	        		viewHarga();
	        		return;
	        	} else if (selectedMenu == 3) {
	        		main.login();
	        		return;
	        	}
	      	} catch (Exception e) {
	        	System.out.println("Error: Inputan Salah!");
	      	}
	      	System.out.print("Continue? (y): ");
	      	isContinue = scan.next();
	    }
	}

	public void viewHarga(){
		String isContinue = "y";

	    while (isContinue.equals("y")) {
	      try {
	        showHarga();
	        int selectedMenu = chooseMenu();

	        	if (selectedMenu == 1) {
	        		listPesanan();
	        	} else if (selectedMenu == 2) {
	        		pesan();
	        	} else if (selectedMenu == 3) {
	        		viewMenu();
	        	}
	      	} catch (Exception e) {
	        	System.out.println("Error: Inputan Salah!");
	      	}
	      	System.out.print("Continue? (y): ");
	      	isContinue = scan.next();
	    }
	}

	// Show
	public void showMenu() {
		cls.cls();
		System.out.println("Pemesanan Makanan dan Minuman");
		System.out.println("==================================");
		System.out.println("[1] Lihat Harga Makanan dan Minuman");
		System.out.println("[2] Pesan Makanan dan Minuman");
		System.out.println("[3] Logout");
		System.out.println("==================================");
	}

	public void showHarga(){
		cls.cls();
		System.out.println("Mulai Pesan Makanan dan Minuman");
		System.out.println("==================================");
		System.out.println("[1] Lihat Pesanan");
		System.out.println("[2] Pesan");
		System.out.println("[3] Back");
		System.out.println("==================================");
	}

	public static int chooseMenu() {
		System.out.print("choose menu : ");
		int pilihan = scan.nextInt();
		return pilihan;
	}

	public void pesan(){
		cls.cls();
		menu.listMenu();
		System.out.println("Page Pemesanan");
		System.out.println("==========================");
		String isContinue = "y";

		while (isContinue.equals("y")) {
		    System.out.print("Masukan ID Menu : ");
		    int idMakanan = scan.nextInt();
		    System.out.print("Jumlah Pesanan ID Menu " + idMakanan + " : ");
		    int jumlahPesan = scan.nextInt();
		    boolean menuFound = false;

		    for (Menu listMakanan : menu.menus) {
            	if (listMakanan.getId() == idMakanan) {
            		sendMakanan(idMakanan, jumlahPesan);
            		menuFound = true;
            		break;
            	}
		    }

		    if (!menuFound) {
		    	System.out.println("Maaf, Menu dengan ID " + idMakanan + " tidak ditemukan.");
		    }
		    
		    System.out.print("Tambah Pesanan? (y) : ");
		    isContinue = scan.next();
		}
	}

	public void listPesanan() {
		cls.cls();
	    System.out.println("==> List Pesanan");
	    System.out.println("==========================");
	    if (pesanans.isEmpty()) {
	        System.out.println("Tidak ada pesanan.");
	    } else {
	        System.out.println("Makanan yang dipesan :");
	        float totalHarga = 0;
	        for (Integer idMakanan : pesanans) {
	            int jumlahPesan = getJumlahPesan(idMakanan);
	            for (Menu listMakanan : menu.menus) {
	                if (listMakanan.getId() == idMakanan) {
	                    System.out.println("ID Menu        : " + listMakanan.getId());
	                    System.out.println("Harga "+listMakanan.getJenis()+"  : Rp. " + listMakanan.getHarga() + " / "+listMakanan.getJenis());
	                    System.out.println("Nama "+listMakanan.getJenis()+"   : " + listMakanan.getMenu());
	                    System.out.println("Jumlah Pesanan : " + jumlahPesan);
	                    float totalHargaMakanan = listMakanan.getHarga() * jumlahPesan;
	                    System.out.println("Total Harga Makanan ID Menu " + listMakanan.getId() + " adalah Rp. " + totalHargaMakanan);
	                    System.out.println("==========================");
	                    totalHarga += totalHargaMakanan;
	                    break;
	                }
	            }
	        }
	        System.out.println("Total Harga yang harus dibayar adalah Rp. " + totalHarga);
	    }
	}

	private int getJumlahPesan(int idMakanan) {
        int jumlahPesan = 0;
        for (int i = 0; i < pesanans.size(); i++) {
            if (pesanans.get(i) == idMakanan) {
                jumlahPesan += pesananJumlah.get(i);
            }
        }
        return jumlahPesan;
    }
}