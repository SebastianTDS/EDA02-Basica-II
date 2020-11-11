package unlam.pb2.eda02;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMateria {

	@Test
	public void testQueSePuedaAñadirUnDocenteAUnaMateria() {
		Docente docente1 = new Docente("Andres","Borgeat",43595674);
		Docente docente2 = new Docente("Alejandro","Goitea",46846942);
		Materia programacion = new Materia("Programacion Basica",docente1);
		
		programacion.setDocente(docente2);
		
		assertEquals(docente2, programacion.getDocente());
	}
	
	@Test
	public void testQueSePuedaAnotarUnAlumno() {
		Alumno alumno1 = new Alumno("Carlos","Perez",42359857,"Desarrollo Web");
		Docente docente1 = new Docente("Andres","Borgeat",43595674);
		Materia programacion = new Materia("Programacion Basica",docente1);
		
		programacion.anotarAlumno(alumno1);
		
		assertEquals(programacion, alumno1.getCurso(programacion).getMateria());
	}
	

}
