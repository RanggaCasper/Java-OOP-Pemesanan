import java.util.ArrayList;
import java.util.Scanner;

class Transfer extends Pesanan {

	public static ArrayList<Transfer> transfers = new ArrayList<Transfer>();
	private int id;
	private String customer;
	private float pembayaran;
	private boolean status;
	private static int nextTransferId = 1;
	private Scanner scan = new Scanner(System.in);

	public Transfer(){

	}

	public Transfer(int id, String customer, float pembayaran, boolean status){
		this.id = id;
		this.customer = customer;
		this.pembayaran = pembayaran;
		this.status = status;
	}

	public boolean getStatus(){
		return status;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public String getCustomer(){
		return customer;
	}

	public void setPembayaran(float pembayaran){
		this.pembayaran = pembayaran;
	}

	public void listTransfer(){
		for (Transfer transferCek : transfers ) {
			System.out.println("ID Pembayaran     : "+transferCek.id);
			System.out.println("Nama Customer     : "+transferCek.customer);
			System.out.println("Jumlah Pembayaran : "+transferCek.pembayaran);
			System.out.println("Status Pembayaran : "+transferCek.status);
			System.out.println("------------------------------------------------");
		}
	}

	// Revisi, penambahan method baru untuk menambahkan data baru kedalam arraylist
	public void sendTransfer(String customer, float pembayaran) {
        boolean transferFound = false;

        for (int i = 0; i < transfers.size(); i++) {
            Transfer transfer = transfers.get(i);
            if (transfer.getCustomer().equals(customer)) {
                transfer.setPembayaran(pembayaran);
                transfer.setStatus(false);
                transfers.set(i, transfer);
                transferFound = true;
                break;
            }
        }

        if (!transferFound) {
            int transferId = nextTransferId++;
            Transfer newTransfer = new Transfer(transferId, customer, pembayaran, false);
            transfers.add(newTransfer);
        }
    }

	public boolean checkTransfer(String customer) {
        for (Transfer cekTransfer : transfers) {
            if (cekTransfer.customer.equals(customer)) {
                return true;
            }
        }
        return false;
    }

	public void showTransfer(){
		if (transfers.isEmpty()) {
			System.out.println("Tidak ada Pembayaran");
		}else{
			konfirmasiTransfer();
		}
	}

	public void konfirmasiTransfer(){
		listTransfer();
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████       KONFIRMASI PEMBAYARAN       ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████\n");
		System.out.print("\tID Pembayaran : ");
		id = scan.nextInt();
		konfirmasiTransfer(id);
	}

	public void konfirmasiTransfer(int id) {
	    boolean transferFound = false;

	    for (int i = 0; i < transfers.size(); i++) {
	        Transfer transfer = transfers.get(i);
	        if (transfer.id == id) {
	            transferFound = true;
	            transfer.setStatus(true);
	            transfers.set(i, transfer);
	            System.out.println("\tPembayaran dengan ID " + id + " berhasil dikonfirmasi.");
	            break;
	        }
	    }

	    if (!transferFound) {
	        System.out.println("\tPembayaran dengan ID " + id + " tidak ditemukan.");
	    }
	}

	public void hapusTransfer(String customer){
		int indexID = -1;

	    for (Transfer dataTransfer : transfers) {
	        if (dataTransfer.customer.equals(customer)) {
	            indexID = transfers.indexOf(dataTransfer);
	            break;
	        }
	    }
	    transfers.remove(indexID);
	}
}
