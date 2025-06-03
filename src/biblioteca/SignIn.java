package biblioteca;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class SignIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfEmail;
	private JPasswordField pfSenha;
	private JPasswordField pfSenhaAdmin;
	private String senhaAdmin = "";
	
	public void setSenhaAdmin(String senhaAdmin) {
		this.senhaAdmin = senhaAdmin;
	}

	public String getSenhaAdmin() {
	    return senhaAdmin;
	};

	public SignIn() {
		setTitle("SignIn");
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
		
		JLabel lblSignIn = new JLabel("SIGN-IN");
		lblSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignIn.setForeground(SystemColor.text);
		lblSignIn.setFont(new Font("Arial", Font.BOLD, 40));
		lblSignIn.setBounds(144, 38, 488, 59);
		contentPane.add(lblSignIn);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(SystemColor.text);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 17));
		lblEmail.setBackground(SystemColor.activeCaptionBorder);
		lblEmail.setBounds(41, 48, 124, 31);
		panelMenu.add(lblEmail);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setOpaque(true);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setForeground(SystemColor.text);
		lblSenha.setFont(new Font("Arial", Font.BOLD, 17));
		lblSenha.setBackground(SystemColor.activeCaptionBorder);
		lblSenha.setBounds(41, 107, 124, 31);
		panelMenu.add(lblSenha);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 17));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBackground(SystemColor.controlShadow);
		btnVoltar.setBounds(91, 233, 231, 38);
		panelMenu.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuInicial menuInicial = new MenuInicial();
				dispose();
				menuInicial.setVisible(true);
			}
		});
		
		JButton btnSignIn = new JButton("SIGN-IN");
		btnSignIn.setEnabled(false);
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setFont(new Font("Arial", Font.BOLD, 17));
		btnSignIn.setBorderPainted(false);
		btnSignIn.setBackground(SystemColor.windowBorder);
		btnSignIn.setBounds(338, 233, 231, 38);
		panelMenu.add(btnSignIn);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		tfEmail.setColumns(10);
		tfEmail.setBounds(175, 48, 437, 31);
		panelMenu.add(tfEmail);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(175, 107, 437, 31);
		panelMenu.add(pfSenha);
		
		JRadioButton rdbtnAdmin = new JRadioButton("ADMIN");
		rdbtnAdmin.setForeground(SystemColor.text);
		rdbtnAdmin.setBackground(SystemColor.activeCaptionBorder);
		rdbtnAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnAdmin.setFont(new Font("Arial", Font.BOLD, 17));
		rdbtnAdmin.setBounds(41, 162, 124, 31);
		panelMenu.add(rdbtnAdmin);
		
		pfSenhaAdmin = new JPasswordField();
		pfSenhaAdmin.setEnabled(false);
		pfSenhaAdmin.setBounds(175, 162, 437, 31);
		pfSenhaAdmin.setEnabled(false);
		panelMenu.add(pfSenhaAdmin);
		
		rdbtnAdmin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        pfSenhaAdmin.setEnabled(rdbtnAdmin.isSelected());
		        pfSenhaAdmin.setText(senhaAdmin);
		    }
		});
		
		
		
		DocumentListener listener = new DocumentListener() {
		    private void verificarCampos() {
		        btnSignIn.setEnabled(!tfEmail.getText().isEmpty() && pfSenha.getPassword().length > 0);
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
		
		tfEmail.getDocument().addDocumentListener(listener);
		pfSenha.getDocument().addDocumentListener(listener);
		
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emailDigitado = tfEmail.getText();
				String senhaDigitada = new String(pfSenha.getPassword());
				String senhaAdminDigitada = new String(pfSenhaAdmin.getPassword());
				
				boolean verificacao = false;
				
				for (Usuario usuario : SignUp.usuarios) {
					if(rdbtnAdmin.isSelected() && usuario.getEmail().equals(emailDigitado) && usuario.getSenha().equals(senhaDigitada)) {
						if(!new String(pfSenhaAdmin.getPassword()).equalsIgnoreCase("123")) {
							javax.swing.JOptionPane.showMessageDialog(null, "Senha Admin inválida", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
						} else {
							verificacao = true;
							break;
						}
					} else {
						if (usuario.getEmail().equals(emailDigitado) && usuario.getSenha().equals(senhaDigitada)) {
							verificacao = true;
							MenuFinal menuFinal = new MenuFinal(senhaAdminDigitada);
							dispose();
							menuFinal.setVisible(true);
							break;
						}
						else {
							javax.swing.JOptionPane.showMessageDialog(null, "Email ou senha inválidos", "Erro de login", javax.swing.JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				
				if (verificacao) {
					MenuFinal menuFinal = new MenuFinal(senhaAdminDigitada);
					dispose();
					menuFinal.setVisible(true);
				} 
				
			}
		});
	}
}
