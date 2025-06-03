package biblioteca;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class RegistroLivro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JTextField tfISBN;
	private JTextField tfEditora;
	private JTextField tfGenero;
	private JTextField tfAnoPublic;
	private JTextField tfNpaginas;
	private static List<Livro> listaLivros = new ArrayList<>();
	
	SignIn signIn = new SignIn();
	
	public static void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
    }
	public static List<Livro> getListaLivros() {
        return listaLivros;
    }
	
	public RegistroLivro(String senha) {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(64, 81, 650, 330);
		panelMenu.setBackground(SystemColor.controlHighlight);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblTitulo = new JLabel("TÍTULO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(SystemColor.text);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 17));
		lblTitulo.setBackground(SystemColor.activeCaptionBorder);
		lblTitulo.setOpaque(true);
		lblTitulo.setBounds(25, 23, 124, 31);
		panelMenu.add(lblTitulo);
		
		JLabel lblAutor = new JLabel("AUTOR");
		lblAutor.setOpaque(true);
		lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutor.setForeground(SystemColor.text);
		lblAutor.setFont(new Font("Arial", Font.BOLD, 17));
		lblAutor.setBackground(SystemColor.activeCaptionBorder);
		lblAutor.setBounds(25, 66, 124, 31);
		panelMenu.add(lblAutor);
		
		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setOpaque(true);
		lblISBN.setHorizontalAlignment(SwingConstants.CENTER);
		lblISBN.setForeground(SystemColor.text);
		lblISBN.setFont(new Font("Arial", Font.BOLD, 17));
		lblISBN.setBackground(SystemColor.activeCaptionBorder);
		lblISBN.setBounds(25, 108, 124, 31);
		panelMenu.add(lblISBN);
		
		JLabel lblEditora = new JLabel("EDITORA");
		lblEditora.setOpaque(true);
		lblEditora.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditora.setForeground(SystemColor.text);
		lblEditora.setFont(new Font("Arial", Font.BOLD, 17));
		lblEditora.setBackground(SystemColor.activeCaptionBorder);
		lblEditora.setBounds(25, 150, 124, 31);
		panelMenu.add(lblEditora);
		
		JLabel lblGenero = new JLabel("GÊNERO");
		lblGenero.setOpaque(true);
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenero.setForeground(SystemColor.text);
		lblGenero.setFont(new Font("Arial", Font.BOLD, 17));
		lblGenero.setBackground(SystemColor.activeCaptionBorder);
		lblGenero.setBounds(25, 192, 124, 31);
		panelMenu.add(lblGenero);
		
		JLabel lblAnoPublicacao = new JLabel("ANO PUBLIC.");
		lblAnoPublicacao.setOpaque(true);
		lblAnoPublicacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnoPublicacao.setForeground(SystemColor.text);
		lblAnoPublicacao.setFont(new Font("Arial", Font.BOLD, 17));
		lblAnoPublicacao.setBackground(SystemColor.activeCaptionBorder);
		lblAnoPublicacao.setBounds(25, 234, 124, 31);
		panelMenu.add(lblAnoPublicacao);
		
		tfTitulo = new JTextField();
		tfTitulo.setFont(new Font("Arial", Font.PLAIN, 15));
		tfTitulo.setBounds(159, 23, 470, 31);
		panelMenu.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		tfAutor = new JTextField();
		tfAutor.setFont(new Font("Arial", Font.PLAIN, 15));
		tfAutor.setColumns(10);
		tfAutor.setBounds(159, 66, 470, 31);
		panelMenu.add(tfAutor);
		
		tfISBN = new JTextField();
		tfISBN.setFont(new Font("Arial", Font.PLAIN, 15));
		tfISBN.setColumns(10);
		tfISBN.setBounds(159, 108, 470, 31);
		panelMenu.add(tfISBN);
		
		tfEditora = new JTextField();
		tfEditora.setFont(new Font("Arial", Font.PLAIN, 15));
		tfEditora.setColumns(10);
		tfEditora.setBounds(159, 150, 470, 31);
		panelMenu.add(tfEditora);
		
		tfGenero = new JTextField();
		tfGenero.setFont(new Font("Arial", Font.PLAIN, 15));
		tfGenero.setColumns(10);
		tfGenero.setBounds(159, 192, 470, 31);
		panelMenu.add(tfGenero);
		
		tfAnoPublic = new JTextField();
		tfAnoPublic.setFont(new Font("Arial", Font.PLAIN, 15));
		tfAnoPublic.setColumns(10);
		tfAnoPublic.setBounds(159, 234, 160, 31);
		panelMenu.add(tfAnoPublic);
		
		JLabel lblNpaginas = new JLabel("Nº PÁGINAS");
		lblNpaginas.setOpaque(true);
		lblNpaginas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNpaginas.setForeground(SystemColor.text);
		lblNpaginas.setFont(new Font("Arial", Font.BOLD, 17));
		lblNpaginas.setBackground(SystemColor.activeCaptionBorder);
		lblNpaginas.setBounds(335, 234, 124, 31);
		panelMenu.add(lblNpaginas);
		
		tfNpaginas = new JTextField();
		tfNpaginas.setFont(new Font("Arial", Font.PLAIN, 15));
		tfNpaginas.setColumns(10);
		tfNpaginas.setBounds(469, 234, 160, 31);
		panelMenu.add(tfNpaginas);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 17));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBackground(SystemColor.controlShadow);
		btnVoltar.setBounds(88, 276, 231, 38);
		panelMenu.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFinal menuFinal = new MenuFinal(senha);
				dispose();
				menuFinal.setVisible(true);
			}
		});
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 17));
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setBackground(SystemColor.windowBorder);
		btnRegistrar.setBounds(335, 276, 231, 38);
		btnRegistrar.setEnabled(false);
		panelMenu.add(btnRegistrar);
		
		DocumentListener listener = new DocumentListener() {
		    private void verificarCampos() {
		        btnRegistrar.setEnabled(!tfTitulo.getText().isEmpty() && !tfAutor.getText().isEmpty() && !tfISBN.getText().isEmpty() && !tfEditora.getText().isEmpty() 
		        		 && !tfGenero.getText().isEmpty() && !tfAnoPublic.getText().isEmpty() && !tfNpaginas.getText().isEmpty());
		    }

		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        verificarCampos();
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        verificarCampos();
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        verificarCampos();
		    }
		};
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarLivro();
				tfTitulo.setText("");
				tfAutor.setText("");
				tfISBN.setText("");
				tfEditora.setText("");
				tfGenero.setText("");
				tfAnoPublic.setText("");
				tfNpaginas.setText("");
			}
		});
		
		tfTitulo.getDocument().addDocumentListener(listener);
		tfAutor.getDocument().addDocumentListener(listener);
		tfISBN.getDocument().addDocumentListener(listener);
		tfEditora.getDocument().addDocumentListener(listener);
		tfGenero.getDocument().addDocumentListener(listener);
		tfAnoPublic.getDocument().addDocumentListener(listener);
		tfNpaginas.getDocument().addDocumentListener(listener);
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setBounds(146, 15, 488, 59);
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setForeground(SystemColor.text);
		lblRegistro.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblRegistro);
		
	}
	
	private Livro criarLivro() {
		String titulo = tfTitulo.getText();
		String autor = tfAutor.getText();
		String ISBN = tfISBN.getText();
		String editora = tfEditora.getText();
		String genero = tfGenero.getText();
		int anoPublic = Integer.parseInt(tfAnoPublic.getText());
		int nPaginas = Integer.parseInt(tfNpaginas.getText());
		
		Livro livro = new Livro(titulo, autor, ISBN, editora, genero, anoPublic, nPaginas);
	    adicionarLivro(livro);
	    return livro;
	}
	
	static {
		listaLivros.add(new Livro("Hobbit", "J.R.R. Tolkien", "978-0547928227", "HarperCollins", "Fantasia", 1937, 328));;
		listaLivros.add(new Livro("A Guerra dos Tronos", "George R.R. Martin", "978-0553593716", "Bantam", "Fantasia", 1996, 835));
		listaLivros.add(new Livro("Ensaio sobre a Cegueira", "José Saramago", "978-0156007757", "Harcourt", "Ficção", 1995, 352));
		listaLivros.add(new Livro("Crime e Castigo", "Fiódor Dostoiévski", "978-0140449136", "Penguin Classics", "Ficção", 1866, 430));
		listaLivros.add(new Livro("A Metamorfose", "Franz Kafka", "978-0486290305", "Dover Publications", "Ficção", 1915, 102));
		listaLivros.add(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "978-0544003415", "Mariner Books", "Fantasia", 1954, 1216));
		listaLivros.add(new Livro("O Cortiço", "Aluísio Azevedo", "978-8520920293", "Nova Fronteira", "Naturalismo", 1890, 288));
		listaLivros.add(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", "978-8572320029", "Global", "Romance", 1881, 208));
		listaLivros.add(new Livro("Vidas Secas", "Graciliano Ramos", "978-8520920217", "Nova Fronteira", "Romance", 1938, 174));
		listaLivros.add(new Livro("A Hora da Estrela", "Clarice Lispector", "978-8535914847", "Rocco", "Ficção", 1977, 96));
	}
}
