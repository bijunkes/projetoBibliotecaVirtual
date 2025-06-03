package biblioteca;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuFinal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	SignIn signIn = new SignIn();

	public MenuFinal(String senha) {
		
		setTitle("MenuFinal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(SystemColor.controlHighlight);
		panelMenu.setBounds(64, 111, 650, 300);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 17));
		btnRegistrar.setBackground(SystemColor.activeCaptionBorder);
		btnRegistrar.setBounds(203, 123, 231, 38);
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setEnabled(false);
		
		if("123".equals(senha)) {
			btnRegistrar.setEnabled(true);
		}
		panelMenu.add(btnRegistrar);
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroLivro registro = new RegistroLivro(senha);
				dispose();
				registro.setVisible(true);
			}
		});
		
		JButton btnReservar = new JButton("RESERVAR");
		btnReservar.setForeground(Color.WHITE);
		btnReservar.setFont(new Font("Arial", Font.BOLD, 17));
		btnReservar.setBorderPainted(false);
		btnReservar.setBackground(SystemColor.activeCaptionBorder);
		btnReservar.setBounds(203, 62, 231, 38);
		panelMenu.add(btnReservar);
		
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservaLivro reserva = new ReservaLivro(senha);
				dispose();
				reserva.setVisible(true);
			}
		});
		
		JButton btnLivrosReservados = new JButton("LIVROS RESERVADOS");
		btnLivrosReservados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivrosReservados livrosReservados = new LivrosReservados(senha);
				dispose();
				livrosReservados.setVisible(true);
			}
		});
		btnLivrosReservados.setForeground(Color.WHITE);
		btnLivrosReservados.setFont(new Font("Arial", Font.BOLD, 17));
		btnLivrosReservados.setBorderPainted(false);
		btnLivrosReservados.setBackground(SystemColor.textInactiveText);
		btnLivrosReservados.setBounds(203, 204, 231, 38);
		panelMenu.add(btnLivrosReservados);
		
		JLabel lblTitulo = new JLabel("BIBLIOTECA VIRTUAL");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(SystemColor.text);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		lblTitulo.setBounds(150, 39, 488, 59);
		contentPane.add(lblTitulo);

	}
}
