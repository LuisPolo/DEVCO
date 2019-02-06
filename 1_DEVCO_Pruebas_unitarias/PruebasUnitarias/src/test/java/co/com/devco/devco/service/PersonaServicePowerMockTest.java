package co.com.devco.devco.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
//import static org.mockito.Mockito.spy;
//import static org.mockito.Mockito.when;
import static org.mockito.Mockito.spy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import co.com.devco.devco.model.EtapaVida;


@RunWith(PowerMockRunner.class)
@PrepareForTest({EtapaService.class, ActividadService.class})
public class PersonaServicePowerMockTest {
	
	@Before
	public void initMocks() {
		PowerMockito.mockStatic(ActividadService.class, EtapaService.class);
		
	}
	
	@Test
	 //Pruebas con test doubles
   public void etapadeVidaDevuelveADOLESCENCIA() throws Exception {
		//Arrange	
		String [] actividadesAdolescencia = {"Estudia en universidad", "Sale de compras", "Apuesta"};
		PowerMockito.when(EtapaService.obtenerEtapaDeVida(anyInt())).thenReturn(EtapaVida.ADOLESCENCIA);
		PowerMockito.when(ActividadService.obtenerActividades(EtapaVida.ADOLESCENCIA)).thenReturn(actividadesAdolescencia);
		
		PersonaService personaService = spy(new PersonaService());		
		String [] resultado = personaService.obtenerActividadesPorEdad(50);
		
		//Assert.assertTrue(resultado.length > 0);
		assertTrue(actividadesAdolescencia.equals(resultado));
		//assertThat(personaService.obtenerActividadesPorEdad(40), equalTo(EtapaVida.ADOLESCENCIA));
	
   }

}
