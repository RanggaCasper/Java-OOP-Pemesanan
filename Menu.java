import java.util.ArrayList;

class Menu{

	public static ArrayList<Menu> menus = new ArrayList<Menu>();

	private int id;
	private String nama;
	private String jenis;
	private float harga;

	public Menu(){

	}

	public Menu(int id, String nama, String jenis, float harga){
		this.id = id;
		this.nama = nama;
		this.jenis = jenis;
		this.harga = harga;
	}

	public int getId(){
		return id;
	}

	public String getMenu(){
		return nama;
	}

	public String getJenis(){
		return jenis;
	}

	public float getHarga(){
		return harga;
	}

	public void setId(int id){
		this.id = id;
	}

	public void setMakanan(String nama){
		this.nama = nama;
	}

	public void setJenis(String jenis){
		this.jenis = jenis;
	}

	public void setHarga(float harga){
		this.harga = harga;
	}

	public void listMenu(){
		System.out.println("██████▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀███████");
		System.out.println("██████             LIST MENU             ███████");
		System.out.println("██████▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄███████");
		System.out.println("██████                                   ███████");
		for (Menu dataMenu : menus) {
			System.out.println("\tID Menu : " + dataMenu.getId());
			System.out.println("\tNama    : " + dataMenu.getMenu());
			System.out.println("\tJenis   : " + dataMenu.getJenis());
			System.out.println("\tHarga   : Rp. " + dataMenu.getHarga());
			System.out.println("------------------------------------------------");
		}
	}
}