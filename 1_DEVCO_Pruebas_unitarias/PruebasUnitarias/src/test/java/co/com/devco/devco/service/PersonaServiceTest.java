package co.com.devco.devco.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import ch.qos.logback.classic.Logger;
import co.com.devco.devco.model.Persona;
import co.com.devco.devco.service.*;


public class PersonaServiceTest {
	
	
	/*@Spy
	PersonaService personaService;*/
	
	/*@Before
	public void initmocks() {
		MockitoAnnotations.initMocks(TestClass.this);
	}*/
	
	/*@Test
	public void x() throw Exception{
		when(personaService.obteneranioactual()).thenreturn(2018);
		int anionacimiento = personaService.calcularanionacimiento(edad 30);
		assertequals()
	}*/
	
	@InjectMocks
	@Spy
	PersonaService personaService1;
	
	@Mock
	Logger logger;
	
	@Test
	 //Pruebas con test doubles
   public void CuandoEdadEs35Devuelve1983() throws Exception {
		//Arrange
				
		PersonaService personaService = spy(new PersonaService());
		
		when(personaService.obtenerAnioActual()).thenReturn(2018);
		
		int anio = personaService.calcularAnioNacimiento(35);
		
		assertTrue(anio==1983);
      
    }
	
	@Test
	 //Pruebas con test doubles
   public void personaNombreNoValido() throws Exception {	
			
	    try{
	    	//Arrange				
			PersonaService personaService = spy(new PersonaService());		
			Persona persona = spy(new Persona());
			
			when(persona.getNombre()).thenReturn("");
			when(persona.getApelido()).thenReturn("Polo");
			when(persona.getEdad()).thenReturn(36);
			
			String respuesta = personaService.presentarPersona(persona);
			
	        fail("Exceptcion No disparada");
	         
	    }catch(Exception e){
	    	//Validacion excepcion
	    	assertEquals(e.getMessage(), "el nombre de la persona es requerido"); 
	    }	          
   }
	
	@Test
	 //Pruebas con test doubles
  public void personaApellidoNoValido() throws Exception {	
			
	    try{
	    	//Arrange				
			PersonaService personaService = spy(new PersonaService());		
			Persona persona = spy(new Persona());
			
			when(persona.getNombre()).thenReturn("Luis");
			when(persona.getApelido()).thenReturn("");
			when(persona.getEdad()).thenReturn(36);
			
			String respuesta = personaService.presentarPersona(persona);		
			
	        fail("Exceptcion No disparada");
	         
	    }catch(Exception e){
	    	//Validacion excepcion
	    	assertEquals(e.getMessage(), "el apellido de la persona es requerido"); 
	    }	          
  }
	
	
	@Test
	 //Pruebas con test doubles
 public void personaEdadNoValida() throws Exception {	
			
	    try{
	    	//Arrange				
			PersonaService personaService = spy(new PersonaService());		
			Persona persona = spy(new Persona());
			
			when(persona.getNombre()).thenReturn("Luis");
			when(persona.getApelido()).thenReturn("Polo");
			when(persona.getEdad()).thenReturn(-10);
			
			String respuesta = personaService.presentarPersona(persona);		
			
	        fail("Exceptcion No disparada");
	         
	    }catch(Exception e){
	    	//Validacion excepcion
	    	assertEquals(e.getMessage(), "la edad de la persona no es valida"); 
	    }	          
 }

	
	//Event Capture
	@Test
	public void testcuandocalcularsalarioesmilentoncessalarioes() {
		PersonaService personaService = spy(PersonaService.class);
		ArgumentCaptor<Integer> salariobasicoDiacaptor = ArgumentCaptor.forClass(Integer.class);
		int resultado = personaService.calcularSalario(1000);
		//Para verificar cuantas veces llamo a un metodo.
		verify(personaService).calcularSalarioMes(salariobasicoDiacaptor.capture());
		int salarioMes = salariobasicoDiacaptor.getValue();
		verify(personaService).calcularSalarioMes(salarioMes);		
		
	}
	
	
	@Test
	public void testVerificarPersistenciaPersona() {
		PersonaService personaService = new PersonaService();		
		
		doAnswer(new Answer <Void>()  {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				Persona persona = invocation.getArgumentAt(0, Persona.class);
				persona.setEdad(40);		
				return null;
			}		
		}).when(personaService1).establecerEdad(any(Persona.class));
		
		
		personaService.guardarPersona ("Lina", "Castro");
		
	}
}
