package unlam.pb2.eda02;

import java.util.HashSet;

public class Docente extends Usuario {

	private HashSet<Materia> materiasACargo;

	public Docente(String nombre, String apellido, String dni) {
		super(nombre, apellido, dni);
		materiasACargo = new HashSet<Materia>();
	}

	public Boolean cargarMateria(Materia nuevaMateria) {
		return materiasACargo.add(nuevaMateria);
	}

	public Boolean dejarMateria(Materia catedraRetirada) {
		return materiasACargo.remove(catedraRetirada);
	}

	public HashSet<Materia> getMateriasACargo() {
		return materiasACargo;
	}

	public Materia buscarMateriaACargo(Materia materiaBuscada) {
		for (Materia materia : materiasACargo) {
			if (materia.equals(materiaBuscada))
				return materia;
		}
		return null;
	}

	public Boolean subirEvaluacion(String tituloEvaluacion, Materia materiaAEvaluar) {
		for (Materia buscada : materiasACargo) {
			if (buscada.equals(materiaAEvaluar)) {
				for (Alumno alumno : buscada.getListadoAlumnos()) {
					if(alumno.getCurso(buscada) != null)
						alumno.getCurso(buscada).anadirEvaluacion(new Evaluacion(tituloEvaluacion));
				}
				return true;
			}
		}
		return false;
	}

	public Boolean corregirEvaluacion(Materia materiaAEvaluar, Alumno alumnoAEvaluar, String tituloEval, Integer nota) {
		for (Materia buscada : materiasACargo) {
			if (buscada.equals(materiaAEvaluar)) {
				for (Alumno alumno : buscada.getListadoAlumnos()) {
					if(alumno.equals(alumnoAEvaluar)) {
						alumno.obtenerEvaluacionPorTitulo(tituloEval, alumno.getCurso(materiaAEvaluar)).colocarNota(nota);
					}
				}
				return true;
			}
		}
		return false;
	}

}
