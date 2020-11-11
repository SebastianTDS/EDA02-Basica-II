package unlam.pb2.eda02;

import java.util.HashSet;

public class Materia {
	
	String nombreMateria;
	HashSet<Alumno> listadoAlumnos;
	Docente docenteDeCatedra;
	
	public Materia(String nombreMateria, Docente docenteDeCatedra) {
		this.nombreMateria = nombreMateria;
		this.docenteDeCatedra = docenteDeCatedra;
		this.listadoAlumnos = new HashSet<Alumno>();
	}
	
	public String getNombreMateria() {
		return nombreMateria;
	}
	
	public HashSet<Alumno> getListadoAlumnos(){
		return listadoAlumnos;
	}
	
	public Docente getDocente() {
		return docenteDeCatedra;
	}
	
	public Boolean anotarAlumno(Alumno nuevoAlumno) {
		nuevoAlumno.anotarseEnCursada(new Cursada(this, nuevoAlumno));
		return listadoAlumnos.add(nuevoAlumno);
	}
	
	public void setDocente(Docente nuevoDocente) {
		this.docenteDeCatedra = nuevoDocente;
	}	

}