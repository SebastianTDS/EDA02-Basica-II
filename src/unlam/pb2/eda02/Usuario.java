package unlam.pb2.eda02;

import java.util.ArrayList;

public abstract class Usuario {

	private String nombre;
	private String apellido;
	private String contrasena;
	private String dni;
	private Integer contadorIntentos;
	private Integer CANT_MAX_INTENTOS;
	private Boolean estaLogueado;
	private Boolean estaBloqueado;
	private ArrayList<String> listadoContrasenas;

	public Usuario(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasena = dni;
		this.dni = dni;
		this.contadorIntentos = 0;
		this.CANT_MAX_INTENTOS = 3;
		this.estaLogueado = false;
		this.estaBloqueado = false;
		this.listadoContrasenas = new ArrayList<String>();

	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDNI() {
		return this.dni;
	}


	public ArrayList<String> getListadoContrasenas() {
		return this.listadoContrasenas;
	}

	public Boolean isLogueado() {
		return this.isLogueado();
	}

	public Boolean isBloqueado() {
		return this.isBloqueado();
	}

	public Boolean cambiarContrasena(String nuevaContra) {
		if (validarContrasena(nuevaContra).equals(true)) {
			return true;
		} else {
			return false;
		}
	}

	private Boolean validarContrasena(String contra) {

		Integer contadorMayusculas = 0;
		Integer contadorMinusculas = 0;
		Integer contadorNumeros = 0;
		Integer caracteresEspeciales = 0;

		for (int i = 0; i < contra.length(); i++) {

			if (Character.isUpperCase(contra.charAt(i))) {
				contadorMayusculas++;
			} else if (Character.isLowerCase(contra.charAt(i))) {
				contadorMinusculas++;
			}
			if (Character.isDigit(contra.charAt(i))) {
				contadorNumeros++;
			}

			if (!(Character.isLetterOrDigit(contra.charAt(i)))) {
				caracteresEspeciales++;
			}
		}

		if (this.isLogueado().equals(true)) {
			if ((contra.length() >= 8) && (contadorMayusculas >= 1) && (contadorMinusculas >= 1)
					&& (contadorNumeros >= 1) && (caracteresEspeciales >= 1)) {

				if (!(this.listadoContrasenas.contains(contra))) {
					if (this.listadoContrasenas.size() == 5) {
						this.listadoContrasenas.remove(this.listadoContrasenas.get(4));
						this.contrasena = contra;
						this.listadoContrasenas.add(contra);
						return true;

					} else {
						this.contrasena = contra;
						this.listadoContrasenas.add(contra);
						return true;
					}
				}
				return false;
			}
			return false;
		}
		return false;
	}
	

	public Boolean ingresarACuenta(String dni, String contrasena) {
		if(estaBloqueado) return this.estaLogueado;	
		
		if((this.dni.equals(dni)) && (this.contrasena.equals(contrasena)) && (this.isBloqueado().equals(false))){
			this.estaLogueado = true;
		}else {
			this.estaLogueado = false;
			this.contadorIntentos++;
			if(contadorIntentos >= CANT_MAX_INTENTOS)
				this.estaBloqueado = true;
		}
		return this.estaLogueado;
	}

	
	
	public void desbloquear() {
		this.estaBloqueado = false;
		this.contadorIntentos = 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}


}



