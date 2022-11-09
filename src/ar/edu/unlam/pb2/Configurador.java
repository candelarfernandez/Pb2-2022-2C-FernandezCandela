package ar.edu.unlam.pb2;

public class Configurador extends Usuario implements Configurable{

	public Configurador(Integer dni, String nombre) {
		super(dni, nombre);
		
	}
	
	public void agregarUnUsuarioALaListaDeUsuariosValidos (Integer dni, Integer idAlarma, String codigoConfiguracionAlarma, Alarma nuevaAlarma, Usuario activador) throws CodigoAlarmaIncorrectoException {
		dni= this.getDni();
		idAlarma= nuevaAlarma.getId();
		if(codigoConfiguracionAlarma.equals(nuevaAlarma.getCodigoConfiguracion())) {
			nuevaAlarma.getUsuariosValidos().add(activador);
		}
		throw new CodigoAlarmaIncorrectoException();	
		
	}
	
	public void agregarUnSensorALaAlarma(Integer idAlarma, String codigoConfiguracionAlarma, Sensor sensor, Alarma nuevaAlarma) throws SensorDuplicadoException {
		if(nuevaAlarma.getSensores().contains(sensor)) {
			throw new SensorDuplicadoException();
		}
		else {
			nuevaAlarma.getSensores().add(sensor);
		}
	}
	
	public void activarAlarma(Sensor sensor, Integer idAlarma, String codigoConfiguracionAlarma, Alarma nuevaAlarma) {
		if(sensor.getEstado() == true) {
			codigoConfiguracionAlarma="Activado";
		}
		else {
			codigoConfiguracionAlarma="Desactivado";
		}
		
	}

}
