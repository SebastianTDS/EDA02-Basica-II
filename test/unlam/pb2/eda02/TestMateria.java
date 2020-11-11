package unlam.pb2.eda02;

import static org.junit.Assert.*;

import org.junit.Test;

import unlam.pb2.eda02.Cursada.EstadoCursada;

public class TestMateria {

	@Test
	public void testQueSePuedaAnadirUnDocenteAUnaMateria() {
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
	
	@Test
	public void testQueSePuedaAprobarMateria() {
		Docente alejandro = new Docente("Alejandro", "Goitea", 3520156);
		Alumno jorge = new Alumno("Jorge", "Pereyra", 3520100, "Desarrollo Web");

		Materia pb1 = new Materia("Basica 1", alejandro);
		Materia pb2 = new Materia("Basica 2", alejandro);

		alejandro.cargarMateria(pb1);
		alejandro.cargarMateria(pb2);

		pb1.anotarAlumno(jorge);

		alejandro.subirEvaluacion("Examen 1 de herencia", pb1, false);
		alejandro.subirEvaluacion("Examen 2 de polimorfismo", pb1, false);
		jorge.realizarEvaluacion("Examen 1 de herencia", pb1);
		jorge.realizarEvaluacion("Examen 2 de polimorfismo", pb1);
		
		assertTrue(alejandro.corregirEvaluacion(pb1, jorge, "Examen 1 de herencia", 6));
		assertTrue(alejandro.corregirEvaluacion(pb1, jorge, "Examen 2 de polimorfismo", 8));
		jorge.getCurso(pb1).actualizarEstado();
		
		assertEquals(jorge.getCurso(pb1).getEstadoActual(), EstadoCursada.APROBADA);
	}
	
	@Test
	public void testQueSePuedaDesaprobarMateria() {
		Docente alejandro = new Docente("Alejandro", "Goitea", 3520156);
		Alumno jorge = new Alumno("Jorge", "Pereyra", 3520100, "Desarrollo Web");

		Materia pb1 = new Materia("Basica 1", alejandro);
		Materia pb2 = new Materia("Basica 2", alejandro);

		alejandro.cargarMateria(pb1);
		alejandro.cargarMateria(pb2);

		pb1.anotarAlumno(jorge);

		alejandro.subirEvaluacion("Examen 1 de herencia", pb1, false);
		alejandro.subirEvaluacion("Examen 2 de polimorfismo", pb1, false);
		jorge.realizarEvaluacion("Examen 1 de herencia", pb1);
		jorge.realizarEvaluacion("Examen 2 de polimorfismo", pb1);
		
		assertTrue(alejandro.corregirEvaluacion(pb1, jorge, "Examen 1 de herencia", 6));
		assertTrue(alejandro.corregirEvaluacion(pb1, jorge, "Examen 2 de polimorfismo", 7));
		jorge.getCurso(pb1).actualizarEstado();
		
		assertEquals(jorge.getCurso(pb1).getEstadoActual(), EstadoCursada.DESAPROBADA);
	}
}
