package unlam.pb2.eda02;

import java.util.ArrayList;

public class Cursada{

	public ArrayList<Evaluacion> listadoEvaluaciones;
	public Alumno alumnoCursando;
	public Materia materia;
	public enum estadoCursada{APROBADA, DESAPROBADA};

	
	public Cursada(Materia materia, Alumno alumnoCursando) {
		this.materia = materia;
		this.alumnoCursando = alumnoCursando;
		this.listadoEvaluaciones = new ArrayList<Evaluacion>();
	}
	
	public ArrayList<Evaluacion> getEvaluaciones(){
		return listadoEvaluaciones;
	}
	
	public Alumno getAlumnoCursando() {
		return alumnoCursando;
	}
	
	public Materia getMateria() {
		return materia;
	}
	
	
	public Boolean añadirEvaluacion(Evaluacion eval) {
		return listadoEvaluaciones.add(eval);
	}
}