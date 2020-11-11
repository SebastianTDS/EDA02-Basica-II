package unlam.pb2.eda02;

import java.util.HashSet;

public class Cursada {
	
	private Materia materiaEnCurso;
	private HashSet<Evaluacion> evaluacionesCursada;
	private Alumno alumnoEnCursada;
	
	public Cursada(Materia materiaEnCurso, Alumno alumnoEnCursada) {
		this.materiaEnCurso = materiaEnCurso;
		this.evaluacionesCursada = new HashSet<Evaluacion>();
		this.alumnoEnCursada = alumnoEnCursada;
	}

	public Materia getMateria() {
		return materiaEnCurso;
	}

	public Boolean anadirEvaluacion(Evaluacion evaluacion) {
		return evaluacionesCursada.add(evaluacion);
	}

	public HashSet<Evaluacion> getEvaluaciones() {
		return evaluacionesCursada;
	}

	public Alumno getAlumnoEnCursada() {
		return alumnoEnCursada;
	}
}
