import java.util.Scanner;
import java.util.InputMismatchException;

class Customer extends Pesanan {

	private static Menu menu = new Menu();
	private static Scanner scan = new Scanner(System.in);
	private static Cls cls = new Cls();
	private static Main main = new Main();
	private String customer;
	private static Transfer tf = new Transfer();

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
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████   PEMESANAN MAKANAN DAN MINUMAN   ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ▀▀▀▀▀▀▀");
		System.out.println("██████ Hai, "+customer);
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
		System.out.println("██████                                   ███████");
		System.out.println();
		System.out.println("\t[1] Lihat Harga");
		System.out.println("\t[2] Pesan Makanan dan Minuman");
		System.out.println("\t[3] Logout\n");
		System.out.println("██████                                   ███████");
		System.out.println("████████████████████████████████████████████████");
	}

	public void showHarga(){
		cls.cls();
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████  PAGE PESAN MAKANAN DAN MINUMAN   ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");
		System.out.println("\t[1] Lihat Pesanan");
		System.out.println("\t[2] Pesan");
		System.out.println("\t[3] Bayar Pesanan");
		System.out.println("\t[4] Back\n");
		System.out.println("██████                                   ███████");
		System.out.println("████████████████████████████████████████████████");
	}

	public static int chooseMenu() {
		System.out.print("██████ Choose Menu : ");
		int pilihan = scan.nextInt();
		return pilihan;
	}

	public void pesan(){
		cls.cls();
		menu.listMenu();
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████           PAGE PEMESANAN          ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");
		String isContinue = "y";

		while (isContinue.equals("y")) {
		    System.out.print("\tMasukan ID Menu : ");
		    int idMakanan = scan.nextInt();
		    System.out.print("\tJumlah Pesanan ID Menu " + idMakanan + " : ");
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
		    	System.out.println("\tMaaf, Menu dengan ID " + idMakanan + " tidak ditemukan.");
		    }
		    
		    System.out.print("\tTambah Pesanan? (y) : ");
		    isContinue = scan.next();
		}
	}

	public void listPesanan() {
	    cls.cls();
	    System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████          LIST PESANAN ANDA        ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");

	    boolean pesananDitemukan = false;
	    float totalHarga = 0;

	    for (int i = 0; i < pemesan.size(); i++) {
	        String pemesanData = pemesan.get(i);
	        if (pemesanData.equals(customer)) {
	            pesananDitemukan = true;
	            System.out.println("\tPesanan milik " + customer);
	            System.out.println("------------------------------------------------");
	            System.out.println("Menu yang dipesan :");
	            for (int j = 0; j < pesanans.size(); j++) {
	                String pemesanPesanan = pemesan.get(j);
	                if (pemesanPesanan.equals(customer)) {
	                    int idMakanan = pesanans.get(j);
	                    int jumlahPesan = getJumlahPesan(customer, idMakanan);

	                    for (Menu listMakanan : menu.menus) {
	                        if (listMakanan.getId() == idMakanan) {
	                            System.out.println("\tID Menu        : " + listMakanan.getId());
	                            System.out.println("\tHarga " + listMakanan.getJenis() + "  : Rp. " + listMakanan.getHarga() + " / " + listMakanan.getJenis());
	                            System.out.println("\tNama " + listMakanan.getJenis() + "   : " + listMakanan.getMenu());
	                            System.out.println("\tJumlah Pesanan : " + jumlahPesan);
	                            float totalHargaMakanan = listMakanan.getHarga() * jumlahPesan;
	                            System.out.println("\tTotal Harga " + listMakanan.getJenis() + " Rp. " + totalHargaMakanan);
	                            System.out.println("------------------------------------------------");
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
	        System.out.println("\tTidak ada pesanan.\n");
	        System.out.println("██████                                   ███████");
	        System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
	    }
	}


    public void bayarPesanan(){
    	if (checkPesanan(customer)) {
    		listPesanan();
    		System.out.println();
	    	System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
			System.out.println("██████          KETERANGAN METODE        ███████");
			System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████\n");
	    	System.out.println("\t[1] Tunai");
	    	System.out.println("\t[2] Tranfer (Biaya Service Rp. 500)\n");
	    	System.out.println("████████████████████████████████████████████████\n");
	    	System.out.print("\tMetode Pembayaran : ");
	    	int metode = scan.nextInt();
	    	while (metode < 1 || metode > 2) {
	          System.out.println("\tMaaf, tidak ada pilihan untuk pembayaran yang kamu pilih");
	          System.out.print("\tMetode Pembayaran : ");
	          metode = scan.nextInt();
	        }
	    	if (metode == 1) {
	    		bayarPesanan("Tunai");
	    	}else if(metode == 2){
	    		bayarPesanan("Transfer");
	    	}
    	}else{
    		System.out.println("\tMaaf, kamu belum memiliki pesanan.");
    	}
    }

    public void bayarPesanan(String metode) {
	    if (metode.equals("Tunai")) {
	        System.out.print("\tJumlah Uang : ");
	        float uang = scan.nextFloat();
	        float jumlahHarga = getJumlahHarga(customer);
	        if (uang < jumlahHarga) {
	            System.out.println("Maaf, uang anda kurang Rp. " + (jumlahHarga - uang));
	        } else {
	        	System.out.println("------------------------------------------------");
	            System.out.println("\tTerimakasi telah berbelanja");
	            System.out.println("\tKembalian : Rp. " + (uang - jumlahHarga));
	            hapusPesanan(customer);
	        }
	    } else if (metode.equals("Transfer")) {
	        System.out.println("██████                                   ███████");
	        System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
	        System.out.println("\tSilahkan Tranfer");
	        System.out.println("\t- Dana");
	        System.out.println("\t083189944777");
	        System.out.println("██████                                   ███████");
	        System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
	        System.out.println("\tBiaya Service Rp. 500");
	        System.out.println("\tNominal Pembayaran Rp. " + (getJumlahHarga(customer) + 500));
	        System.out.println("██████                                   ███████");
	        System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
	        showTransfer();
	    }
	}

	public void showTransfer() {
	    boolean transferFound = false;

	    for (Transfer transferData : tf.transfers) {
	        if (transferData.getCustomer().equals(customer)) {
	            if (transferData.getStatus()) {
	                hapusPesanan(customer);
	                tf.hapusTransfer(customer);
	                System.out.println("Terima kasih telah berbelanja.");
	            } else {
	                System.out.println("Pesanan sedang menunggu admin untuk konfirmasi pembayaran.");
	            }
	            transferFound = true;
	            break;
	        }
	    }

	    if (!transferFound) {
	        int transferId = tf.transfers.size() + 1;
	        Transfer masukanTransfer = new Transfer(transferId, customer, getJumlahHarga(customer), false);
	        tf.transfers.add(masukanTransfer);
	        System.out.println("Pesanan sudah dimasukkan ke dalam List Pembayaran.");
	    }
	}
}
