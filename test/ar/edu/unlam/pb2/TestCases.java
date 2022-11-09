package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases {

	@Test
	public void queSePuedaRegistrarUnaAlarmaEnLaCentral() {
		Central centralAlarma = new Central("Nueva Central");
		Alarma nuevaAlarma = new Alarma(1, true, true, "primera alarma");
		
		
	}
	@Test
	public void queSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma() {
		
	}
	@Test
	public void alAgregarUnUsuarioAUnaAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSeLanceCodigoAlamraIncorrectoException() {
		
	}
	@Test
	public void alAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnSensorDuplicadoException() {
		
	}
	@Test
	public void queNoSepuedaActivarUnaAlarmaSiHayAlMenosUnSensorDesactivado() {
		
	}
	@Test
	public void queParaUnaAlarmaDeterminadaSePuedaObtenerUnaColeccionOrdenadaDeAccionEsDeTipoConfiguracionOrdenadasPorIdDeAccion() {
		
	}
		
	

}
