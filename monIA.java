import moteur.*;


public class monIA implements Joueur {

	@Override
	public Coup prochainCoup(Coup[] arg0) {
		return arg0[0];
	}

	
}
