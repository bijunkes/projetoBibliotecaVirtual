package biblioteca;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LivrosReservados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public LivrosReservados(String senha) {
		setTitle("Livros Reservados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(64, 81, 650, 330);
		panelMenu.setBackground(SystemColor.controlHighlight);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblReserva = new JLabel("LIVROS RESERVADOS");
		lblReserva.setBounds(146, 15, 488, 59);
		lblReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserva.setForeground(SystemColor.text);
		lblReserva.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblReserva);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 17));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBackground(SystemColor.controlShadow);
		btnVoltar.setBounds(90, 278, 231, 38);
		panelMenu.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFinal menuFinal = new MenuFinal(senha);
				dispose();
				menuFinal.setVisible(true);
			}
		});
		
		DefaultListModel<String> model = new DefaultListModel<>();
		for (Livro livro : LivroSelecionado.livrosReservados) {
			model.addElement(livro.getTitulo());
		}
		
		JList<String> lista = new JList<>(model);
		lista.setFont(new Font("Arial", Font.PLAIN, 18));
		
		JScrollPane scrollPane = new JScrollPane(lista);
		scrollPane.setBounds(26, 24, 596, 243);
		panelMenu.add(scrollPane);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 17));
		btnExcluir.setBorderPainted(false);
		btnExcluir.setBackground(SystemColor.textInactiveText);
		btnExcluir.setBounds(331, 278, 231, 38);
		panelMenu.add(btnExcluir);
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int livroSelecionado = lista.getSelectedIndex();
				
				if (livroSelecionado != -1) {
					model.remove(livroSelecionado);
					LivroSelecionado.livrosReservados.remove(livroSelecionado);
				}
			}
		});
		
	}
}
