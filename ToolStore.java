package survivalgame;

public class ToolStore extends NormalLocation {

	ToolStore(Player player) {
		super(player, "Mağaza");
	}

	public boolean getLocation() {
		System.out.println(" Para : "+getPlayer().getMoney());
		System.out.println("1-) Silahlar");
		System.out.println("2-)Zırhlar");
		System.out.println("3-)Çıkış");
		System.out.println("Seçiminiz :");
		int selTool;
		//selectTool eşya seçimi kısaltımı.
		int selItemID;
		// selectItem
		selTool=scan.nextInt();
	switch(selTool) {
	case 1:
	selItemID= 	weaponMenu();
	 buyWeapon(selItemID);
	 break;
	 
	case 2:
		selItemID=armorMenu();
		buyArmor(selItemID);
		
		break;
	
	default:
		break;
	}
	return true;
	}
	
	public int armorMenu() {
		System.out.println("1-)Hafif Price : 25 \t Damage : 2");
		System.out.println("2-) Orta Price : 35 \t Damage : 3");
		System.out.println("3-) Ağır Price : 45 \t Damage : 7");
		System.out.println("Çıkış!");
		System.out.println("Armor Seçiniz");
		int selArmorID=scan.nextInt();
		return selArmorID;
		
		
	}
	public void buyArmor(int itemID) {
		
		int avoid=0;
		int price=0;
		String aName=null;
		switch(itemID) {
		case 1:
			avoid=1;
			aName="Hafif Zırh";
			price=15;
					break;
		case 2:
			avoid=3;
			aName="Orta Zırh";
			price=15;
					break;
		case 3:
			avoid=5;
			aName="Ağır Zırh";
			price=40;
					break;
		case 4:
			System.out.println("Çıkış Yapılıyor!");
					break;
			
		default:
			System.out.println("Hatalı tuşlama Yaptınız");
			break;
		}
		if(price>0) {
			if(player.getMoney()>price) {
				player.getInv().setArmor(avoid);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney()-price);
				System.out.println(aName+"satın aldığınız kalkan"+"\n engellenen hasar"+player.getInv().getArmor());
			}
		}
		
	}
	


	public int weaponMenu() {
		System.out.println("1-) Pistol \t Price : 25 \t Damage : 2");
		System.out.println("2-) Sword \t Price : 35 \t Damage : 3");
		System.out.println("3-) Shoutgun \t Price : 45 \t Damage : 7");
		System.out.println("4-)Çıkış!");
		System.out.println("Silah Seçiminiz :");
		 int selWeapon;
		 int selWeaponID=scan.nextInt();
		 return selWeaponID;
	}
	
	public void buyWeapon(int itemID) {
		int damage =0,price=0;
		String wName=null;
		if(itemID >0 && itemID <4) {
			switch(itemID) {
			case 1:
				damage=2;
				wName="Pistol";
				price=25;
				break;
			case 2:
				damage=3;
				wName="Sword";
				price=35;
				break;
			case 3:
				damage=7;
				wName="Shoutgun";
				price=45;
				break;
			case 4:
				System.out.println("Çıkış Yapılıyor");
				break;
				default :
					System.out.println("Geçersiz İşlem!");
					break;
					
			}
		if(price>0) {
			if(player.getMoney()>price)
			{
				player.getInv().setDamage(damage);
				//aldığım ürünü inventore ekledim damagesini değiştirdim
				player.getInv().setwName(wName);
				player.setMoney(player.getMoney()-price);
				System.out.println(wName+"Silah Satın Aldınız "+ "\t önceki hasar"+player.getDamage()+"\t yeni hasar"+player.getTotalDamage());
System.out.println("Kalan Para ="+player.getMoney());
			}
			else
			{
				System.out.println("Yetersiz Bakiye");
			}
		}
			
		}else
		{
			System.out.println("Geçersiz İşlem!");
		}
	}
}
