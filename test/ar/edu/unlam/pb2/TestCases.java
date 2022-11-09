package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	@Test
	public void queSePuedaRegistrarUnaAlarmaEnLaCentral() {
		Central centralAlarma = new Central("Nueva Central");
		Alarma nuevaAlarma = new Alarma(1, "activado", "a-1", "primera alarma");
		Usuario administrador = new Administrador(1, "candela");
		((Administrador) administrador).agregarAlarma(nuevaAlarma, centralAlarma);
		assertEquals(1, centralAlarma.getAlarmas().size());
	}
	@Test
	public void queSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma() throws CodigoAlarmaIncorrecto {
		Central centralAlarma = new Central("Nueva Central");
		Alarma nuevaAlarma = new Alarma(1, "activado", "a-1", "primera alarma");
		Usuario administrador = new Administrador(1, "candela");
		Usuario configurador = new Configurador(1, "candela");
		((Administrador) administrador).agregarUsuario(configurador, centralAlarma, nuevaAlarma);	
		assertEquals(1, nuevaAlarma.getUsuariosValidos().size());
		
	}
	@Test (expected = CodigoAlarmaIncorrecto.class)
	public void alAgregarUnUsuarioAUnaAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSeLanceCodigoAlarmaIncorrectoException() throws CodigoAlarmaIncorrecto {
		Central centralAlarma = new Central("Nueva Central");
		Alarma nuevaAlarma = new Alarma(1, "activado", "invalido", "primera alarma");
		Usuario administrador = new Administrador(1, "candela");
		Usuario configurador = new Configurador(1, "candela");
		((Administrador) administrador).agregarUsuario(configurador, centralAlarma, nuevaAlarma);	
	}
	@Test (expected = SensorDuplicadoException.class)
	public void alAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnSensorDuplicadoException() throws SensorDuplicadoException {
		Central centralAlarma = new Central("Nueva Central");
		Alarma nuevaAlarma = new Alarma(1, "activado", "invalido", "primera alarma");
		Usuario administrador = new Administrador(1, "candela");
		Usuario configurador = new Configurador(1, "candela");
		Sensor sensor = new Sensor(1, true);
		Sensor sensor1 = new Sensor(1, true);
		
		((Administrador) administrador).agregarSensorALaAlarma( sensor, nuevaAlarma);
		((Administrador) administrador).agregarSensorALaAlarma( sensor1, nuevaAlarma);
		
	}
	@Test
	public void queNoSepuedaActivarUnaAlarmaSiHayAlMenosUnSensorDesactivado() throws SensorDuplicadoException {
		Central centralAlarma = new Central("Nueva Central");
		Alarma nuevaAlarma = new Alarma(1, "activado", "invalido", "primera alarma");
		Usuario administrador = new Administrador(1, "candela");
		Usuario configurador = new Configurador(1, "candela");
		Sensor sensor1 = new Sensor(2, false);
		Integer idAlarma= nuevaAlarma.getId();
		String codigoActivacionAlarma= nuevaAlarma.getCodigoActivacion();
		
		((Administrador) administrador).agregarSensorALaAlarma( sensor1, nuevaAlarma);
		
		assertEquals(true, ((Administrador) administrador).activarSensorAAlarma(  sensor1, idAlarma, codigoActivacionAlarma, configurador));
	}
	@Test
	public void queParaUnaAlarmaDeterminadaSePuedaObtenerUnaColeccionOrdenadaDeAccionEsDeTipoConfiguracionOrdenadasPorIdDeAccion() {
		
	}
		
	

}
