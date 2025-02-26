package survivalgame;

public  abstract class NormalLocation  extends Location{

	NormalLocation(Player player,String name) {
		super(player);
this.name=name;
	}
	public boolean getLocation() {
		
		return true;
		// direkt doğru döndürsün çünkü ben mağazada yada evde ölmücem savaştığım yerlerde ölceğim için
		
	}

	
	
	
}
