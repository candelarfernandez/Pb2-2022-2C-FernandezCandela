package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Set;

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
		
		assertEquals(true, ((Administrador) administrador).activarSensorAAlarma(sensor1, idAlarma, codigoActivacionAlarma, configurador, nuevaAlarma, centralAlarma));
	}
	@Test
	public void queParaUnaAlarmaDeterminadaSePuedaObtenerUnaColeccionOrdenadaDeAccionEsDeTipoConfiguracionOrdenadasPorIdDeAccion() {
		Central centralAlarma = new Central("Nueva Central");
		Alarma nuevaAlarma = new Alarma(1, "activado", "invalido", "primera alarma");
		Usuario administrador = new Administrador(1, "candela");
		Usuario configurador = new Configurador(1, "candela");
		Accion accion1 = new Accion(3, nuevaAlarma, administrador,"20220405",TipoOperacion.CONFIGURACION);
		Accion accion2 = new Accion(1, nuevaAlarma, administrador,"20220405",TipoOperacion.CONFIGURACION);
		Accion accion3 = new Accion(4, nuevaAlarma, administrador,"20220405",TipoOperacion.CONFIGURACION);
		Accion accion4 = new Accion(2, nuevaAlarma, administrador,"20220405",TipoOperacion.CONFIGURACION);
		Set<Accion> listaAcciones = nuevaAlarma.getAccionesRealizadas();
		nuevaAlarma.agregarAccion(accion1);
		nuevaAlarma.agregarAccion(accion2);
		nuevaAlarma.agregarAccion(accion3);
		nuevaAlarma.agregarAccion(accion4);
		for (Accion accion : listaAcciones) {
			assertEquals((Integer)1, accion.getId());
			break;
		}
	}
		
	

}
