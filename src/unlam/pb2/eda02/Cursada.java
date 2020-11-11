package unlam.pb2.eda02;

import java.util.ArrayList;

public class Cursada{

	public enum EstadoCursada{APROBADA, DESAPROBADA, CURSANDO};
	private ArrayList<Evaluacion> listadoEvaluaciones;
	private Alumno alumnoCursando;
	private Materia materia;
	private EstadoCursada estadoActual;

	
	public Cursada(Materia materia, Alumno alumnoCursando) {
		this.materia = materia;
		this.alumnoCursando = alumnoCursando;
		this.listadoEvaluaciones = new ArrayList<Evaluacion>();
		this.estadoActual = EstadoCursada.CURSANDO;
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
	
	public Boolean anadirEvaluacion(Evaluacion eval) {
		return listadoEvaluaciones.add(eval);
	}
	
	public void actualizarEstado() {
		Integer notaAcumulada = 0;
		for(Evaluacion eval : listadoEvaluaciones) {
			if(eval.getNota() != null) {
				notaAcumulada += eval.getNota();
				
			}
		}
		
		if(notaAcumulada.doubleValue() / listadoEvaluaciones.size() >= 7) 
			this.estadoActual = EstadoCursada.APROBADA;
		else if(notaAcumulada.doubleValue() / listadoEvaluaciones.size() < 7)
			this.estadoActual = EstadoCursada.DESAPROBADA;			
	}

	public EstadoCursada getEstadoActual() {
		return estadoActual;
	}
}