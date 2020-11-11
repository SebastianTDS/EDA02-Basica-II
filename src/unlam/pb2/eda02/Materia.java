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
		Boolean resultado=true;
		for(Alumno actual: listadoAlumnos) {
			if(actual.equals(nuevoAlumno)){
				resultado = false;
			} else if(resultado == true) {
				listadoAlumnos.add(nuevoAlumno);
			}
		}
		return resultado;
	}
	
	public void setDocente(Docente nuevoDocente) {
		this.docenteDeCatedra = nuevoDocente;
	}	

}