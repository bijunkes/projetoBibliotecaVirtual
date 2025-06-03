package biblioteca;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class LivroSelecionado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	public static List<Livro> livrosReservados = new ArrayList<>();

	public LivroSelecionado(Livro livro) {
		setTitle("Reserva");
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

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(88, 276, 231, 38);
		panelMenu.setLayout(null);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 17));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBackground(SystemColor.controlShadow);
		panelMenu.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton btnReservar = new JButton("RESERVAR");
		btnReservar.setBounds(335, 276, 231, 38);
		btnReservar.setForeground(Color.WHITE);
		btnReservar.setFont(new Font("Arial", Font.BOLD, 17));
		btnReservar.setBorderPainted(false);
		btnReservar.setBackground(SystemColor.windowBorder);
		panelMenu.add(btnReservar);

		JLabel lblTituloLivro = new JLabel(livro.getTitulo());
		lblTituloLivro.setBounds(146, 15, 488, 59);
		lblTituloLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLivro.setForeground(SystemColor.text);
		lblTituloLivro.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblTituloLivro);
		
		table = new JTable();
		table.setBounds(27, 21, 596, 232);
		table.setForeground(SystemColor.desktop);
		table.setBackground(SystemColor.scrollbar);
		table.setFont(new Font("Arial", Font.BOLD, 17));
		table.setRowHeight(39);
		panelMenu.add(table);
		
		String[] colunas = {"Atributo", "Valor"};

		Object[][] dados = {
			{"Título", livro.getTitulo() },
			{"Autor", livro.getAutor() },
			{"Editora", livro.getEditora()},
			{"Ano Publicação", livro.getAnoPublic() },
			{"Gênero", livro.getGenero() },
			{"Nº Páginas", livro.getnPaginas()}
		};

		table.setModel(new javax.swing.table.DefaultTableModel(dados, colunas));
		
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livrosReservados.add(livro);
				javax.swing.JOptionPane.showMessageDialog(null, "Livro reservado", "Aviso", javax.swing.JOptionPane.PLAIN_MESSAGE);
			}
		});
		
	}
}
