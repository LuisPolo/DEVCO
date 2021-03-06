package co.com.devco.devco.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.com.devco.devco.model.EtapaVida;
import co.com.devco.devco.model.Persona;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

public class PersonaService {

    private Logger logger;

    //Pruebas con excepciones
    //Pruebas parametrizadas
    public String presentarPersona(Persona persona) throws Exception {

        if (persona == null) {
            throw new Exception("persona no valida");
        }
        if (StringUtils.isEmpty(persona.getNombre())) {
            throw new Exception("el nombre de la persona es requerido");
        }
        if (StringUtils.isEmpty(persona.getApelido())) {
            throw new Exception("el apellido de la persona es requerido");
        }
        if (persona.getEdad() <= 0) {
            throw new Exception("la edad de la persona no es valida");
        }
        return "Hola, soy " + persona.getNombre() + " " + persona.getApelido() + " de edad: " + persona.getEdad();
    }

    protected int obtenerAnioActual() {
        return LocalDate.now().getYear();
    }

    //Pruebas con test doubles
    public int calcularAnioNacimiento(int edad) throws Exception {
        int anioActual = obtenerAnioActual();

        if (edad > anioActual) {
            throw new Exception("la edad es invalida por favor verifique");
        }

        if (edad < 0) {
            throw new Exception("la edad es invalida por favor verifique");
        }

        return anioActual - edad;
    }

    public List<String> consultarMovientos(String idTransaccion) {
        List lista = new ArrayList<String>();
        if (idTransaccion.equals("123"))
            lista.add("123");
        return lista;
    }

    //Pruebas con powermock - estaticos
    public String[] obtenerActividadesPorEdad(int edad) {
        EtapaVida etapaAux = EtapaService.obtenerEtapaDeVida(edad);
        if (etapaAux != null) {
            return ActividadService.obtenerActividades(etapaAux);
        } else {
            return null;
        }
    }

    //Event Captor
    public int calcularSalario(int salarioBasicoDia) {
        int salarioBasicoMes = calcularSalarioMes(salarioBasicoDia);
        int salarioAnual = calcularSalarioAnual(salarioBasicoMes);
        return salarioAnual;
    }

    protected int calcularSalarioMes(int salarioBasicoDia) {
        return salarioBasicoDia * 30;
    }

    protected int calcularSalarioAnual(int salarioBasicoMes) {
        return salarioBasicoMes * 12;
    }


    //Dynamic response
    public void guardarPersona(String nombre, String apellido) {
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setApelido(apellido);
        establecerEdad(persona);
        logger.info("la edad de la persona es {}", persona.getEdad());
    }

    public void establecerEdad(Persona persona) {
        persona.setEdad(30);
    }

}
