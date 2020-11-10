package unlam.pb2.eda02;

import java.util.HashSet;

public class Materia {
	
	private HashSet<Alumno> listadoAlumnos;
	private String nombreMateria;
	private Docente docenteDeCatedra;
	
	public Materia(String nombreMateria, Docente docenteDeCatedra) {
		this.listadoAlumnos = new HashSet<Alumno>();
		this.docenteDeCatedra = docenteDeCatedra;
		this.nombreMateria = nombreMateria;
	}
	
	public Docente getDocente() {
		return docenteDeCatedra;
	}

	public HashSet<Alumno> getListadoAlumnos() {
		return listadoAlumnos;
	}
	
	public Boolean anotarAlumno(Alumno alumnoNuevo) {
		alumnoNuevo.anotarseEnCursada(new Cursada(this, alumnoNuevo));
		return listadoAlumnos.add(alumnoNuevo);
	}
	
	public Boolean removerAlumno(Alumno alumnoRemovido) {
		alumnoRemovido.abandonarCursada(alumnoRemovido.getCurso(this));
		return listadoAlumnos.remove(alumnoRemovido);
	}

}
