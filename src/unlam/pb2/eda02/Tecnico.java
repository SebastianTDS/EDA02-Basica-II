package unlam.pb2.eda02;

public class Tecnico extends Usuario {

	public Tecnico(String nombre, String apellido, Integer dni) {
		super(nombre, apellido, dni);
	}

	
	public Boolean desbloquearUsuario(Usuario usuario) {
		usuario.desbloquear();
		return true;
	}
	
	
	public Boolean anadirUsuario(Sistema sistemaObj, Usuario nuevoUsuario) {
		if(sistemaObj.ingresarUsuario(nuevoUsuario).equals(true)) {
			return true; 
		}else {
			return false;
		}
		
	}
	
	
	public Boolean eleminarUsuario(Sistema sistemaObj, Usuario usuarioAEliminar) {
		if(sistemaObj.removerUsuario(usuarioAEliminar).equals(true)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public Boolean anadirAlumno(Materia materia, Alumno nuevoAlumno) {
		if(materia.anotarAlumno(nuevoAlumno).equals(true)) {
			return true;
		}else {
			return false;
		}
		
	}
	

}
