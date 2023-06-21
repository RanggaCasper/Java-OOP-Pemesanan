import java.util.ArrayList;

abstract class Pesanan{

	protected ArrayList<Integer> pesanans = new ArrayList<>();
    protected ArrayList<Integer> pesananJumlah = new ArrayList<>();
    protected ArrayList<String> pemesan = new ArrayList<>();
    private Menu menu = new Menu();

    protected int makanan;
    protected int jumlahPesan;
    protected String iniPemesan;

    public void sendMakanan(String iniPemesan, int makanan, int jumlahPesan) {
        float totalHarga = 0;
        if (isMakananExists(iniPemesan, makanan)) {
            System.out.println("Maaf, menu dengan ID " + makanan + " sudah ada di List Pesanan");
        } else {
            pemesan.add(iniPemesan);
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

    private boolean isMakananExists(String customer, int makanan) {
        for (int i = 0; i < pemesan.size(); i++) {
            if (pemesan.get(i).equals(customer) && pesanans.get(i) == makanan) {
                return true;
            }
        }
        return false;
    }


    protected boolean checkPesanan(String customer) {
        for (String cekPemesan : pemesan) {
            if (cekPemesan.equals(customer)) {
                return true;
            }
        }
        return false;
    }


    protected int getJumlahPesan(String customer, int idMakanan) {
        int jumlahPesan = 0;
        for (int i = 0; i < pemesan.size(); i++) {
            if (pemesan.get(i).equals(customer) && pesanans.get(i) == idMakanan) {
                jumlahPesan += pesananJumlah.get(i);
            }
        }
        return jumlahPesan;
    }

    protected float getJumlahHarga(String customer){
        boolean pesananDitemukan = false;
        float totalHarga = 0;
        for (int i = 0; i < pemesan.size(); i++) {
            if (pemesan.get(i).equals(customer)) {
                pesananDitemukan = true;
                for (int j = 0; j < pesanans.size(); j++) {
                    if (pemesan.get(j).equals(customer)) {
                        int idMakanan = pesanans.get(j);
                        int jumlahPesan = getJumlahPesan(customer, idMakanan);
                        for (Menu listMakanan : menu.menus) {
                            if (listMakanan.getId() == idMakanan) {
                                float totalHargaMakanan = listMakanan.getHarga() * jumlahPesan;
                                totalHarga += totalHargaMakanan;
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }
        return totalHarga;
    }

    protected void hapusPesanan(String customer){
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

    public abstract void showTransfer();
}