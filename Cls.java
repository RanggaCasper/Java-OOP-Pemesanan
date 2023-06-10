class Cls{

	public static void cls(){
		try{
			Thread.sleep(250);
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}catch(Exception E){
			System.out.println("Tidak bisa clear screen");
		}
	}
}