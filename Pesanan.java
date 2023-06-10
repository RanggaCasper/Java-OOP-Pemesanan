import java.util.ArrayList;

abstract class Pesanan{

	protected ArrayList<Integer> pesanans = new ArrayList<>();
    protected ArrayList<Integer> pesananJumlah = new ArrayList<>();
    private Menu menu = new Menu();

    protected int makanan;
    protected int jumlahPesan;

    public void sendMakanan(int makanan, int jumlahPesan) {
        float totalHarga = 0;
        if (isMakananExists(makanan)) {
            System.out.println("Maaf, menu dengan ID " + makanan + " sudah ada di List Pesanan");
        } else {
            pesanans.add(makanan);
            pesananJumlah.add(jumlahPesan);
            for (Menu listMakanan : menu.menus) {
                if (listMakanan.getId() == makanan) {
                    totalHarga += listMakanan.getHarga() * jumlahPesan;
                    break;
                }
            }
            System.out.println("Menu dengan ID " + makanan + " berhasil ditambahkan ke List Pesanan");
        }
    }

    private boolean isMakananExists(int makanan) {
        for (Integer idMakanan : pesanans) {        
            if (idMakanan == makanan) {
                return true;
            }
        }
        return false;
    }

    public abstract void showMenu();
    public abstract void showHarga();
    public abstract void pesan();
    public abstract void listPesanan();
}