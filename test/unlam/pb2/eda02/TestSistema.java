package unlam.pb2.eda02;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSistema {

	@Test
	public void testQueSePuedaAnadirMateriaADocente() {
		Docente alejandro = new Docente("Alejandro", "Goitea", "3520156");
		Materia pb1 = new Materia("Basica 1", alejandro);
		Materia pb2 = new Materia("Basica 2", alejandro);

		alejandro.cargarMateria(pb1);
		alejandro.cargarMateria(pb2);
		alejandro.cargarMateria(pb2);

		assertEquals(2, alejandro.getMateriasACargo().size());
	}

	@Test
	public void testQueSePuedaRemoverMateriaADocente() {
		Docente alejandro = new Docente("Alejandro", "Goitea", "3520156");
		Materia pb1 = new Materia("Basica 1", alejandro);
		Materia ingles = new Materia("Ingles", alejandro);

		alejandro.cargarMateria(pb1);
		alejandro.cargarMateria(ingles);
		alejandro.dejarMateria(ingles);

		assertEquals(1, alejandro.getMateriasACargo().size());
	}

	@Test
	public void testQueSePuedaAñadirEvaluacion() {
		Docente alejandro = new Docente("Alejandro", "Goitea", "3520156");
		Alumno jorge = new Alumno("Jorge", "Pereyra", "3520100", "Desarrollo Web");
		Alumno pedro = new Alumno("Pedro", "Pereyra", "3520101", "Desarrollo Web");

		Materia pb1 = new Materia("Basica 1", alejandro);
		Materia pb2 = new Materia("Basica 2", alejandro);

		alejandro.cargarMateria(pb1);
		alejandro.cargarMateria(pb2);

		pb1.anotarAlumno(pedro);
		pb1.anotarAlumno(jorge);

		alejandro.subirEvaluacion("Examen 1 de herencia", pb1);

		assertNotNull(jorge.obtenerEvaluacionPorTitulo("Examen 1 de herencia", jorge.getCurso(pb1)));
		assertNotNull(pedro.obtenerEvaluacionPorTitulo("Examen 1 de herencia", pedro.getCurso(pb1)));
	}

	@Test
	public void testQueSePuedaResolverEvaluacion() {
		Docente alejandro = new Docente("Alejandro", "Goitea", "3520156");
		Alumno jorge = new Alumno("Jorge", "Pereyra", "3520100", "Desarrollo Web");
		Alumno pedro = new Alumno("Pedro", "Pereyra", "3520101", "Desarrollo Web");

		Materia pb1 = new Materia("Basica 1", alejandro);
		Materia pb2 = new Materia("Basica 2", alejandro);

		alejandro.cargarMateria(pb1);
		alejandro.cargarMateria(pb2);

		pb1.anotarAlumno(pedro);
		pb1.anotarAlumno(jorge);

		alejandro.subirEvaluacion("Examen 1 de herencia", pb1);

		assertTrue(jorge.realizarEvaluación("Examen 1 de herencia", pb1));
		assertFalse(jorge.obtenerEvaluacionPorTitulo("Examen 1 de herencia", jorge.getCurso(pb1)).isPendiente());
	}
	
	@Test
	public void testQueSePuedaCorregirEvaluacion() {
		Docente alejandro = new Docente("Alejandro", "Goitea", "3520156");
		Alumno jorge = new Alumno("Jorge", "Pereyra", "3520100", "Desarrollo Web");
		Alumno pedro = new Alumno("Pedro", "Pereyra", "3520101", "Desarrollo Web");

		Materia pb1 = new Materia("Basica 1", alejandro);
		Materia pb2 = new Materia("Basica 2", alejandro);

		alejandro.cargarMateria(pb1);
		alejandro.cargarMateria(pb2);

		pb1.anotarAlumno(pedro);
		pb1.anotarAlumno(jorge);

		alejandro.subirEvaluacion("Examen 1 de herencia", pb1);
		jorge.realizarEvaluación("Examen 1 de herencia", pb1);
		
		assertTrue(alejandro.corregirEvaluacion(pb1, jorge, "Examen 1 de herencia", 7));
		assertTrue(alejandro.corregirEvaluacion(pb1, pedro, "Examen 1 de herencia", 1));
		
		assertEquals(jorge.obtenerEvaluacionPorTitulo("Examen 1 de herencia", jorge.getCurso(pb1)).getNota(), (Integer)7);
		assertEquals(pedro.obtenerEvaluacionPorTitulo("Examen 1 de herencia", pedro.getCurso(pb1)).getNota(), (Integer)0);
	}
}
