package unlam.pb2.eda02;

import java.util.HashSet;

public class Sistema {

	private String nombre;
	private HashSet<Usuario> listaDeUsuarios;
	private HashSet<Materia> listaDeMaterias;

	public Sistema(String nombre) {
		this.nombre = nombre;
		this.listaDeUsuarios = new HashSet <Usuario>();
		this.listaDeMaterias = new HashSet <Materia>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public HashSet<Usuario> getUsuarios() {
		return this.listaDeUsuarios;
	}

	public HashSet<Materia> getMaterias() {
		return this.listaDeMaterias;
	}

	public Boolean ingresarUsuario(Usuario nuevoUsuario) {
		return this.listaDeUsuarios.add(nuevoUsuario);
	}
	
	public Boolean removerUsuario(Usuario usuarioAEliminar) {
		return this.listaDeUsuarios.remove(usuarioAEliminar);
	}		
	
	public HashSet<Tecnico> obtenerTecnicos(){
		HashSet<Tecnico>listaTecnicos = new HashSet <Tecnico>();
		
		for(Usuario i : this.listaDeUsuarios) {
			if(i instanceof Tecnico) {
				listaTecnicos.add(i);
			}
		}
		return listaTecnicos;
	}
	
	public HashSet<Alumno> obtenerAlumnos(){
		HashSet<Alumno>listaAlumnos = new HashSet <Alumno>();
		
		for(Usuario i : this.listaDeUsuarios) {
			if(i instanceof Alumno) {
				listaAlumnos.add(i);
			}
		}
		return listaAlumnos;
	}
	
	public HashSet<Docente> obtenerDocentes(){
		HashSet<Docente>listaDocentes = new HashSet <Docente>();
		
		for(Usuario i : this.listaDeUsuarios) {
			if(i instanceof Docente) {
				listaDocentes.add(i);
			}
		}
		return listaDocentes;
	}
	
	public Integer obtenerNumeroUsuarios() {
		return this.listaDeUsuarios.size();
	}
	
	public Integer obtenerNumeroTecnicos() {
		HashSet<Tecnico>listaTecnicos = new HashSet <Tecnico>();
		
		for(Usuario i : this.listaDeUsuarios) {
			if(i instanceof Tecnico) {
				listaTecnicos.add(i);
			}
		}
		return listaTecnicos.size();
	}
	
	public Integer obtenerNumeroAlumnos() {
		HashSet<Alumno>listaAlumnos = new HashSet <Alumno>();
		
		for(Usuario i : this.listaDeUsuarios) {
			if(i instanceof Alumno) {
				listaAlumnos.add(i);
			}
		}
		return listaAlumnos.size();
	}
	
	public Integer obtenerNumeroDocentes() {
		HashSet<Docente>listaDocentes = new HashSet <Docente>();
		
		for(Usuario i : this.listaDeUsuarios) {
			if(i instanceof Docente) {
				listaDocentes.add(i);
			}
		}
		return listaDocentes.size();
		
	}
	
	public Materia obtenerMateria(Materia materiaSolicitada) {
		if(this.listaDeMaterias.contains(materiaSolicitada)) {
			for (Materia i : this.listaDeMaterias) {
				if (i.equals(materiaSolicitada)) {
					return i;
				}
			}
		}
		return null;
	}
	
	public Usuario obtenerUsuario(Usuario usuarioSolicitado) {
		if(this.listaDeUsuarios.contains(usuarioSolicitado)) {
			for (Usuario i : this.listaDeUsuarios) {
				if (i.equals(usuarioSolicitado)) {
					return i;
				}
			}
		}
		return null;
	}
	
	public Boolean ingresarMateria(Materia nuevaMateria) {
		return this.listaDeMaterias.add(nuevaMateria);
	}
	
	public Boolean removerMateria(Materia materiaAEliminar) {
		return this.listaDeMaterias.remove(materiaAEliminar);
	}
	
	public Integer obtenerNumeroCursada (Materia materiaSolicitada) {
		return materiaSolicitada.getListadoAlumnos().size();
	}

	public HashSet<Alumno> obtenerListaCursada(Materia materiaSolicitada){
		return materiaSolicitada.getListadoAlumnos();
	}
	
}


