import java.util.Scanner;
import java.util.InputMismatchException;

class Customer extends Pesanan {

	private static Menu menu = new Menu();
	private static Scanner scan = new Scanner(System.in);
	private static Cls cls = new Cls();
	private static Main main = new Main();
	private String customer;

	public void setCustomer(String username){
		this.customer = username;
	}

	public void viewMenu(){
		String isContinue = "y";

	    while (isContinue.equals("y")) {
	      try {
	        showMenu();
	        int selectedMenu = chooseMenu();

		        while (selectedMenu < 1 || selectedMenu > 3) {
		          System.out.println("Maaf, tidak ada pilihan untuk menu yang kamu pilih");
		          selectedMenu = chooseMenu();
		        }

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
	      	} catch (InputMismatchException e) {
	        	System.out.println("Error: Inputan salah, inputan harus berupa angka!");
	        	scan.nextLine();
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

	        	while (selectedMenu < 1 || selectedMenu > 4) {
		          System.out.println("Maaf, tidak ada pilihan untuk menu yang kamu pilih");
		          selectedMenu = chooseMenu();
		        }

	        	if (selectedMenu == 1) {
	        		listPesanan();
	        	} else if (selectedMenu == 2) {
	        		pesan();
	        	} else if (selectedMenu == 3) {
	        		bayarPesanan();
	        	} else if (selectedMenu == 4) {
	        		viewMenu();
	        	}
	      	} catch (InputMismatchException e) {
	        	System.out.println("Error: Inputan salah, inputan harus berupa angka!");
	        	scan.nextLine();
	      	}
	      	System.out.print("Continue? (y): ");
	      	isContinue = scan.next();
	    }
	}

	// Show
	public void showMenu() {
		cls.cls();
		System.out.println("Hai, "+customer);
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
		System.out.println("[3] Bayar Pesanan");
		System.out.println("[4] Back");
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
            		sendMakanan(customer, idMakanan, jumlahPesan);
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

	    boolean pesananDitemukan = false;
	    float totalHarga = 0;

	    for (int i = 0; i < pemesan.size(); i++) {
	        String pemesanData = pemesan.get(i);
	        if (pemesanData.equals(customer)) {
	            pesananDitemukan = true;
	            System.out.println("Pesanan " + customer);
	            System.out.println("Makanan yang dipesan :");

	            for (int j = 0; j < pesanans.size(); j++) {
	                String pemesanPesanan = pemesan.get(j);
	                if (pemesanPesanan.equals(customer)) {
	                    int idMakanan = pesanans.get(j);
	                    int jumlahPesan = getJumlahPesan(idMakanan);

	                    for (Menu listMakanan : menu.menus) {
	                        if (listMakanan.getId() == idMakanan) {
	                            System.out.println("ID Menu        : " + listMakanan.getId());
	                            System.out.println("Harga " + listMakanan.getJenis() + "  : Rp. " + listMakanan.getHarga() + " / " + listMakanan.getJenis());
	                            System.out.println("Nama " + listMakanan.getJenis() + "   : " + listMakanan.getMenu());
	                            System.out.println("Jumlah Pesanan : " + jumlahPesan);
	                            float totalHargaMakanan = listMakanan.getHarga() * jumlahPesan;
	                            System.out.println("Total Harga " + listMakanan.getJenis() + " adalah Rp. " + totalHargaMakanan);
	                            System.out.println("==========================");
	                            totalHarga += totalHargaMakanan;
	                            break;
	                        }
	                    }
	                }
	            }

	            System.out.println("Total Harga yang harus dibayar adalah Rp. " + totalHarga);
	            break;
	        }
	    }

	    if (!pesananDitemukan) {
	        System.out.println("Tidak ada pesanan.");
	    }
	}


    public void bayarPesanan(){
    	if (checkPesanan(customer)) {
    		listPesanan();
	    	System.out.println("===========================");
	    	System.out.println("===[ Keterangan Metode ]===");
	    	System.out.println("[1] Tunai");
	    	System.out.println("[2] Tranfer (Biaya Service Rp. 500)");
	    	System.out.println("===========================");
	    	System.out.print("Metode Pembayaran : ");
	    	int metode = scan.nextInt();
	    	if (metode == 1) {
	    		bayarPesanan("Tunai");
	    	}else{
	    		bayarPesanan("Tranfer");
	    	}	
    	}else{
    		System.out.println("Maaf, kamu belum memiliki pesanan.");
    	}
    }

    public void bayarPesanan(String metode) {
	    if (metode.equals("Tunai")) {
	        System.out.println("===========================");
	        System.out.print("Jumlah Uang : ");
	        float uang = scan.nextFloat();
	        float jumlahHarga = getJumlahHarga(customer);
	        if (uang < jumlahHarga) {
	            System.out.println("Maaf, uang anda kurang Rp. " + (jumlahHarga - uang));
	        } else {
	            System.out.println("===========================");
	            System.out.println("Terimakasi telah berbelanja");
	            System.out.println("Kembalian : Rp. " + (uang - jumlahHarga));
	            for (int i = pesanans.size() - 1; i >= 0; i--) {
	                if (pemesan.get(i).equals(customer)) {
	                    pesanans.remove(i);
	                }
	            }
	            for (int i = pesananJumlah.size() - 1; i >= 0; i--) {
	                if (pemesan.get(i).equals(customer)) {
	                    pesananJumlah.remove(i);
	                }
	            }
	            for (int i = pemesan.size() - 1; i >= 0; i--) {
	                if (pemesan.get(i).equals(customer)) {
	                    pemesan.remove(i);
	                }
	            }
	        }
	    } else {
	        System.out.println("===========================");
	        System.out.println("Silahkan Tranfer");
	        System.out.println("- Dana");
	        System.out.println("083189944777");
	        System.out.println("===========================");
	        System.out.println("Biaya Service Rp. 500");
	        System.out.println("Nominal Pembayaran Rp. " + (getJumlahHarga(customer) + 500));
	        System.out.println("===========================");
	    }
	}
}
