package unlam.pb2.eda02;

public class Evaluacion {
	private String titulo;
	private Integer nota;

	private Boolean pendiente;
	private Boolean recuperatorio;

	public Evaluacion(String titulo, Boolean recuperatorio) {
		this.pendiente = true;
		this.titulo = titulo;
		this.nota = null;
		this.recuperatorio = recuperatorio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Evaluacion other = (Evaluacion) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	public String getTituloEvaluacion() {
		return this.titulo;
	}
	
	public Integer getNota() {
		return nota;
	}
	
	public void realizar(){
		this.pendiente = false;
	}
	
	public Boolean colocarNota(Integer nota) {
		if(nota > 10 || nota < 0 || nota == null || this.nota != null) return false;
		if(pendiente && !recuperatorio) {
			this.nota = 0;
			return false;
		}else {
			this.nota = nota;
			return true;
		}
	}
	
	public boolean isPendiente() {
		return pendiente;
	}
}
