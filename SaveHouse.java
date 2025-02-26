package survivalgame;

public class SaveHouse extends NormalLocation {

	SaveHouse(Player player) {
		super(player, "Güvenli ev");
	}

	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		// kullanıcı buraya geldiğinde canını fulle diyorum
		System.out.println("İyileştin!");
		return true;
	}
	
}
