package biblioteca;

public class Livro {

	private String titulo;
	private String autor;
	private String ISBN;
	private String Editora;
	private String Genero;
	private int anoPublic;
	private int nPaginas;
	
	public Livro(String titulo, String autor, String ISBN, String editora, String genero, int anoPublic, int nPaginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = ISBN;
		this.Editora = editora;
		this.Genero = genero;
		this.anoPublic = anoPublic;
		this.nPaginas = nPaginas;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getEditora() {
		return Editora;
	}

	public void setEditora(String editora) {
		Editora = editora;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public int getAnoPublic() {
		return anoPublic;
	}

	public void setAnoPublic(int anoPublic) {
		this.anoPublic = anoPublic;
	}

	public int getnPaginas() {
		return nPaginas;
	}

	public void setnPaginas(int nPaginas) {
		this.nPaginas = nPaginas;
	}
}
