package unlam.pb2.eda02;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCursada {

	@Test
	public void testQueSePuedaAñadirUnaEvaluacion() {
		Alumno alumno1 = new Alumno("Tomas", "Rodriguez", 48263465, "Desarrollo Web");
		Docente docente1 = new Docente("Juan", "Monteagudo", 49523826);
		Materia programacion = new Materia("Programacion Basica", docente1);
		Cursada curso1 = new Cursada(programacion, alumno1);
		
		Evaluacion eva1 = new Evaluacion("Evaluacion 1", false);
		Evaluacion eva2 = new Evaluacion("Evaluacion 2", false);
		Evaluacion eva3 = new Evaluacion("Evaluacion 3", false);
		Evaluacion eva4 = new Evaluacion("Evaluacion 4", false);
		
		curso1.añadirEvaluacion(eva1);
		curso1.añadirEvaluacion(eva2);
		curso1.añadirEvaluacion(eva3);
		curso1.añadirEvaluacion(eva4);

		assertEquals(4, curso1.getEvaluaciones().size());
	
	}

}
