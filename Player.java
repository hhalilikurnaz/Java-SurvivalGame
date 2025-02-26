package survivalgame;
import java.util.Scanner;
public class Player {
	Scanner scan=new Scanner(System.in);
private int rHealthy;
	private int damage,healthy,money;
	private String name; //oyuncunun adı
	private String cName;//seçtiği karakterin adı
	 private Inventory ınv;
	
	public Player(String name) {
		
		this.name = name;
		this.ınv=new Inventory();
	}
	
	public void selectChar() {
		
		charMenu();
	}
	
	public void charMenu() {
		System.out.println("lütfen Bir Karakter Seçiniz! \n Karakter Listesi!");
		System.out.println("1-) : Samuray \t Hasar:5 \t Sağlık:21 \t Para :15");
		System.out.println("2-) : Okçu \t Hasar:7 \t Sağlık:18 \t Para :20");
		System.out.println("3-): Şovalye \t Hasar:8 \t Sağlık:24 \t Para :5");
		int choice;
		choice=scan.nextInt();
		switch(choice) {
		
		case 1:
			System.out.println("Karakteriniz : Samuray \t Hasar:5 \t Sağlık:21 \t Para :15");
			break;
		case 2:
			System.out.println("Karakteriniz : Okçu \t Hasar:7 \t Sağlık:18 \t Para :20");
			break;
		case 3:
			System.out.println(" Karakteriniz : Şovalye \t Hasar:8 \t Sağlık:24 \t Para :5");
			break;
		default :
			System.out.println("Hatalı Sayı Gridiniz Tekrardan Deneyiniz!");
			break;
			

		}
		
	
		
		
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealthy() {
		return healthy;
	}

	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return ınv;
	}

	public void setInv(Inventory inv) {
		ınv = inv;
	}

	public int getrHealthy() {
		return rHealthy;
	}

	public void setrHealthy(int rHealthy) {
		this.rHealthy = rHealthy;
	}
	
	public int getTotalDamage() {
		return this.getDamage()+this.getInv().getDamage();
		// ilk kullanıcının damagesi ek olarak mağazadan aldığı silahtaki damagayi ekliyorum
		
	}

}
