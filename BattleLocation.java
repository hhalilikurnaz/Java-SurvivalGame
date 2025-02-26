package survivalgame;

public abstract class BattleLocation extends Location{
	protected String award;
	
	protected obstacle obstacle;
	BattleLocation(Player player,String name,obstacle obstacle,String award) {
		super(player);
this.name=name;
this.obstacle=obstacle;
this.award=award;

	
	
	}
	public boolean getLocation() {
		int obsNumber=obstacle.count();
		System.out.println("Şuan "+this.getName()+"'sın"+"\n Dikkatli ol \n Burada "+obsNumber+"tane"+obstacle.getName()+"yaşıyor");
		System.out.println("<S>avaş veya <K>aç");
		String selCase=scan.next();
		selCase=selCase.toUpperCase();
		if(selCase.equals("s"))
		{
			if(combat(obsNumber)) {
				System.out.println(this.getName()+"bölgesindeki"+"Tüm Düşmanları temizlediniz!");
				if(this.award.equals("Food") && player.getInv().isFood()==false) {
					System.out.println(this.award+"Kazandınız");
					player.getInv().setFood(true);
					
					
				}else if(this.award.equals("Water") && this.player.getInv().isWater()==false) {
					System.out.println(this.award+"Kazandınız \t Kana Kana İç");
					this.player.getInv().setWater(true);
				}
				else if(this.award.equals("Firewood") && this.player.getInv().isFirewood()==false) {
					System.out.println(this.award+"Kazandınz \n Yak Gitsin");
					player.getInv().setFirewood(true);
				}
				
					
				
				return true;
			}else
			{
				System.out.println("Öldünüz!");
				return false;
			}
		}
		
		return true;
	}
	
	public boolean combat(int obsNumber) {
		for(int i=0;i<obsNumber;i++) {
			int defOBsHealth=obstacle.getHealth();
			
			playerStats();
			enemyStats();
			while(player.getHealthy()>0 && obstacle.getHealth()>0)
			{
				System.out.println("<V>ur veya <K>aç");
				String selCase=scan.next();
				selCase=selCase.toUpperCase();
				if(selCase.equals("V")) {
					System.out.println("Sen Vurdun!");
					obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
					afterHit();
					if(obstacle.getHealth()>0) {
						System.out.println();
						System.out.println("Canavar Size Vurdu'");
					player.setHealthy(player.getHealthy()-(obstacle.getDamage()-player.getInv().getArmor()));
					afterHit();
						
						
					}
				//	System.out.println("Oyuncu Canı"+this.player.getHealthy());
					
				}else
				{
					break;
				}
			}
			if(obstacle.getHealth()<=0 && player.getHealthy()>0) {
				System.out.println("Tüm Düşmanları Yendiniz!");
				player.setMoney(player.getMoney()+obstacle.getAward());
				System.out.println("Güncel Paranız :"+this.player.getMoney());
				obstacle.setHealth(defOBsHealth);
				
				
			}
			else
			{
				return false;
			}
			
		}
		return true;
		
	}
	
	public void playerStats() {
		System.out.println("Oyuncu Değerleri \n---------");
		System.out.println("Can :"+this.player.getrHealthy());
		System.out.println("Hasar :"+this.player.getTotalDamage());
		System.out.println("Para :"+this.player.getMoney());
		if(this.player.getInv().getDamage()>0)
		// playerın ınventorysındeki damagesi 0 dan büyükse silahı vardır diyor onu yazdır diyor
			{
			System.out.println("Silah :"+this.player.getInv().getwName());
		}
	if(this.player.getInv().getArmor()>0)
	{
		System.out.println("Zırh:"+this.player.getInv().getaName());
		
	}
	}
	public void enemyStats() {
		System.out.println(obstacle.getName()+"Verileri");
		System.out.println("Can :"+obstacle.getHealth());
		System.out.println("Hasar :"+obstacle.getDamage());
		System.out.println("Ödül:"+this.obstacle.getAward());
	}

}
