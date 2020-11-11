package unlam.pb2.eda02;

import java.util.HashSet;

public class Alumno extends Usuario {
	private String carrera;
	private HashSet<Cursada> materiasEnCurso;

	public Alumno(String nombre, String apellido, String dni, String carrera) {
		super(nombre, apellido, dni);
		this.carrera = carrera;
		this.materiasEnCurso = new HashSet<Cursada>();
	}
	
	public String getCarrera() {
		return this.carrera;
	}
	
	public void setCarrera(String nuevaCarrera) {
		this.carrera = nuevaCarrera;
	}
	
	public HashSet<Cursada> getListadoCursada(){
		return this.materiasEnCurso;
	}
	
	public Boolean anotarseEnCursada(Cursada curso) {
		if(curso.getAlumnoEnCursada() != this) return false;
		return materiasEnCurso.add(curso);
	}
	
	public Boolean abandonarCursada(Cursada curso) {	
		return materiasEnCurso.remove(curso);
	}
	
	public Boolean realizarEvaluación(String titulo, Materia materiaEvaluada) {
		for(Cursada curso : materiasEnCurso) {
			if(curso.getMateria().equals(materiaEvaluada) && obtenerEvaluacionPorTitulo(titulo, curso) != null){
				Evaluacion realizada = obtenerEvaluacionPorTitulo(titulo, curso);
				realizada.realizar();
				return true;
			}
		}
		return false;
	}
	
	public Cursada getCurso(Materia materiaCursada) {
		for(Cursada curso : materiasEnCurso) {
			if(curso.getMateria().equals(materiaCursada)) {
				return curso;
			}
		}
		return null;
	}
	
	public Evaluacion obtenerEvaluacionPorTitulo(String titulo, Cursada curso) {
		if(!materiasEnCurso.contains(curso)) return null;
		for(Evaluacion examen : curso.getEvaluaciones()) {
			if(examen.getTituloEvaluacion().equals(titulo)) {
				return examen;
			}
		}
		return null;
	}
}
