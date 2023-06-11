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

    protected boolean checkPesanan(){
        if (pesanans.isEmpty()) {
            return false;
        }
        return true;
    }

    protected int getJumlahPesan(int idMakanan) {
        int jumlahPesan = 0;
        for (int i = 0; i < pesanans.size(); i++) {
            if (pesanans.get(i) == idMakanan) {
                jumlahPesan += pesananJumlah.get(i);
            }
        }
        return jumlahPesan;
    }

    protected float getJumlahHarga(){
        float totalHarga = 0;
        for (Integer idMakanan : pesanans) {
            int jumlahPesan = getJumlahPesan(idMakanan);
            for (Menu listMakanan : menu.menus) {
                if (listMakanan.getId() == idMakanan) {
                    float totalHargaMakanan = listMakanan.getHarga() * jumlahPesan;
                    totalHarga += totalHargaMakanan;
                    break;
                }
            }
        }
        return totalHarga;
    }

    public abstract void showMenu();
    public abstract void showHarga();
    public abstract void pesan();
    public abstract void listPesanan();
}