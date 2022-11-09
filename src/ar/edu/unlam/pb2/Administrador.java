package ar.edu.unlam.pb2;

public class Administrador extends Usuario {

	public Administrador(Integer dni, String nombre) {
		super(dni, nombre);
		// TODO Auto-generated constructor stub
	}
	
	public Boolean agregarAlarma(Alarma alarma, Central central) {
		central.getAlarmas().add(alarma);
		return true;

		
	}

	public Boolean agregarUsuario(Usuario configurador, Central centralAlarma, Alarma nuevaAlarma) throws CodigoAlarmaIncorrecto {
	   if(nuevaAlarma.getCodigoConfiguracion() == "invalido") {
		   throw new CodigoAlarmaIncorrecto();
	   }
	   nuevaAlarma.getUsuariosValidos().add(configurador);
		return true;
	}

	public void agregarSensorALaAlarma(Sensor sensor,
			Alarma nuevaAlarma) throws SensorDuplicadoException {
		if(nuevaAlarma.getSensores().contains(sensor)) {
			throw new SensorDuplicadoException();
		}
		nuevaAlarma.getSensores().add(sensor);
		
	}

	public Boolean activarSensorAAlarma(Sensor sensor, Integer idAlarma, String codigoActivacionAlarma, Usuario configurador) {
		if(sensor.getEstado() == false) {
			codigoActivacionAlarma="Desactivado";
			return true;
		}
		codigoActivacionAlarma="Activado";
		return false;
		
	}


}
