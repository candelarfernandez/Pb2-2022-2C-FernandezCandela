package ar.edu.unlam.pb2;

public class Activador extends Usuario implements Activable{

	public Activador(Integer dni, String nombre) {
		super(dni, nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean activarDesactivarAlarma(Alarma alarmaa, String codgioActivacionAlarma) {
		// TODO Auto-generated method stub
		return null;
	}

}
