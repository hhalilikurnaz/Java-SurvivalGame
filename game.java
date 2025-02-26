package survivalgame;
import java.util.Scanner;


public class game {
	Player player;
	Location location;
	Scanner scan=new Scanner(System.in);
	
	
	public void logın() {
		System.out.println(	"*** Macera Oyununa Hoşgeldiniz***");
		System.out.println("Oyuna başlamadan Önce isminizi giriniz!");
		String playerName=scan.nextLine();
		player = new Player(playerName);
		player.selectChar();
		start();
		
		
	}
	
	public void start() {
		while(true)
		{
			System.out.println();
			System.out.println("============");
			System.out.println();
			System.out.println("Lütfen Bir Yer Seçiniz!");
			System.out.println("1-)Güvenli Ev \t Size ait güvenli bir ev");
			System.out.println("2-) Mağara \t Karşınıza zombi çıkabilir!");
			System.out.println("3-) Orman \t Karşınıza belki vampir çıkabilir!");
			System.out.println("4-) Nehir \t Karşınıza belki ayı veya ayılar çıkabilir!");
			System.out.println("5-) Mağaza \t Silah veya Zırh alabilirsiniz!");
			int selLoc=scan.nextInt();
			while(selLoc <0 || selLoc >5)
			{
				System.out.print("Lütfen geçerli bir yer seçiniz!");
				selLoc=scan.nextInt();
				
			}
			
		switch(selLoc) {
		
		case 1:
			location = new SaveHouse(player);
			break;
		case 2:
			location=new Cave(player);
			break;
		case 3:
			location=new Forest(player);
			break;
		case 4:
			location=new River(player);
			break;
			
		case 5:
			location=new ToolStore(player);
			break;
		default:
			System.out.println("Geçersiz İşlem Yaptınız!");
			break;
			
			
		
		}
		
		
		if(!location.getLocation())
		// getlocationdan dönen değer eğer false ise oyun bitiyor yani
			{
			System.out.println("Game Over");
			break;
			
		}else
		{
			
		}
		
		location.getLocation();	

		
		
		}
	
	
	
	
	
	
	
	
	
	
	
	}
	
	

}
