package biblioteca;

import java.awt.EventQueue;
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

public class MenuInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial frame = new MenuInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuInicial() {
		setTitle("MenuInicial");
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
		
		JButton btnCadastrar = new JButton("SIGN-UP");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 17));
		btnCadastrar.setBackground(SystemColor.activeCaptionBorder);
		btnCadastrar.setBounds(203, 150, 231, 38);
		btnCadastrar.setBorderPainted(false);
		panelMenu.add(btnCadastrar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signUp = new SignUp();
				dispose();
				signUp.setVisible(true);
			}
		});
		
		JButton btnRegistrar = new JButton("SIGN-IN");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 17));
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setBackground(SystemColor.activeCaptionBorder);
		btnRegistrar.setBounds(203, 89, 231, 38);
		panelMenu.add(btnRegistrar);
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn signIn = new SignIn();
				dispose();
				signIn.setVisible(true);
			}
		});
		
		JLabel lblTitulo = new JLabel("BIBLIOTECA VIRTUAL");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(SystemColor.text);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		lblTitulo.setBounds(150, 39, 488, 59);
		contentPane.add(lblTitulo);
	}
}
