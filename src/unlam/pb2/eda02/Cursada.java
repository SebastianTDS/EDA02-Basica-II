package unlam.pb2.eda02;

import java.util.ArrayList;

public class Cursada{

	public ArrayList<Evaluacion> listadoEvaluaciones;
	public Alumno alumnoCursando;
	public Materia materia;
	public enum estadoCursada{APROBADA, DESAPROBADA};
	private Alumno alumnoEnCursada;
	
	
	public Cursada(Materia materia, Alumno alumnoCursando) {
		this.materia = materia;
		this.alumnoCursando = alumnoCursando;
	}
	
	public ArrayList<Evaluacion> getEvaluaciones(){
		return listadoEvaluaciones;
	}
	
	public Alumno getAlumno() {
		return alumnoCursando;
	}
	
	public Materia getMateria() {
		return materia;
	}
	
	
	public Boolean añadirEvaluacion(Evaluacion eval) {
		Boolean resultado = true;
		 for(Evaluacion actual: listadoEvaluaciones) {
			if(actual.equals(eval)){
				resultado = false;
			} else if(resultado == true) {
				listadoEvaluaciones.add(eval);
			}
		}
		return resultado;
	}
	
	public Alumno getAlumnoEnCursada() {
		return alumnoEnCursada;
	}

}