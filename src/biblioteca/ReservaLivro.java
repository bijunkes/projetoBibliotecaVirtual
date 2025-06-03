package biblioteca;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class ReservaLivro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfPesquisa;
	
	private JList<String> listLivros; 
	private List<Livro> livros;
	
	SignIn signIn = new SignIn();

	public ReservaLivro(String senha) {
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
		panelMenu.setLayout(null);

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

		JButton btnSelecionar = new JButton("SELECIONAR");
		btnSelecionar.setForeground(Color.WHITE);
		btnSelecionar.setFont(new Font("Arial", Font.BOLD, 17));
		btnSelecionar.setBorderPainted(false);
		btnSelecionar.setBackground(SystemColor.windowBorder);
		btnSelecionar.setBounds(335, 276, 231, 38);
		panelMenu.add(btnSelecionar);
		
		listLivros = new JList<>();
		listLivros.setFont(new Font("Arial", Font.BOLD, 17));

		JScrollPane scrollPane = new JScrollPane(listLivros);
		scrollPane.setBounds(27, 58, 596, 203);
		panelMenu.add(scrollPane);
		
		tfPesquisa = new JTextField();
		tfPesquisa.setFont(new Font("Arial", Font.PLAIN, 15));
		tfPesquisa.setColumns(10);
		tfPesquisa.setBounds(27, 16, 596, 31);
		panelMenu.add(tfPesquisa);

		JLabel lblReserva = new JLabel("RESERVA");
		lblReserva.setBounds(146, 15, 488, 59);
		lblReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserva.setForeground(SystemColor.text);
		lblReserva.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblReserva);
		
		livros = RegistroLivro.getListaLivros();
		
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indiceSelecionado = listLivros.getSelectedIndex();
				if (indiceSelecionado != -1) {
					Livro livroSelecionado = livros.get(indiceSelecionado);
					LivroSelecionado frame = new LivroSelecionado(livroSelecionado);
					frame.setVisible(true);
				}
			}
		});

		DefaultListModel<String> model = new DefaultListModel<>();
		for (Livro livro : livros) {
			model.addElement(livro.getTitulo());
		}
		listLivros.setModel(model);
		
		tfPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pesquisa = tfPesquisa.getText().toLowerCase();
			    DefaultListModel<String> model = new DefaultListModel<>();
			    for (Livro livro : livros) {
			        if (livro.getTitulo().toLowerCase().contains(pesquisa)) {
			            model.addElement(livro.getTitulo());
			        }
			    }
			    listLivros.setModel(model);
			}
		});
	}
}
