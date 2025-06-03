package biblioteca;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfEmail;
	private JPasswordField pfSenha;
	
	public static List<Usuario> usuarios = new ArrayList<>();

	public SignUp() {
		setTitle("SignUp");
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
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setOpaque(true);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setForeground(SystemColor.text);
		lblNome.setFont(new Font("Arial", Font.BOLD, 17));
		lblNome.setBackground(SystemColor.activeCaptionBorder);
		lblNome.setBounds(41, 33, 124, 31);
		panelMenu.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial", Font.PLAIN, 15));
		tfNome.setColumns(10);
		tfNome.setBounds(175, 34, 437, 31);
		panelMenu.add(tfNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setOpaque(true);
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setForeground(SystemColor.text);
		lblCpf.setFont(new Font("Arial", Font.BOLD, 17));
		lblCpf.setBackground(SystemColor.activeCaptionBorder);
		lblCpf.setBounds(41, 83, 124, 31);
		panelMenu.add(lblCpf);
		
		tfCpf = new JTextField();
		tfCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		tfCpf.setColumns(10);
		tfCpf.setBounds(175, 84, 437, 31);
		panelMenu.add(tfCpf);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(SystemColor.text);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 17));
		lblEmail.setBackground(SystemColor.activeCaptionBorder);
		lblEmail.setBounds(41, 136, 124, 31);
		panelMenu.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		tfEmail.setColumns(10);
		tfEmail.setBounds(175, 137, 437, 31);
		panelMenu.add(tfEmail);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setOpaque(true);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setForeground(SystemColor.text);
		lblSenha.setFont(new Font("Arial", Font.BOLD, 17));
		lblSenha.setBackground(SystemColor.activeCaptionBorder);
		lblSenha.setBounds(41, 187, 124, 31);
		panelMenu.add(lblSenha);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 17));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBackground(SystemColor.controlShadow);
		btnVoltar.setBounds(90, 240, 231, 38);
		panelMenu.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuInicial menuInicial = new MenuInicial();
				dispose();
				menuInicial.setVisible(true);
			}
		});
		
		JButton btnSignUp = new JButton("SIGN-UP");
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Arial", Font.BOLD, 17));
		btnSignUp.setBorderPainted(false);
		btnSignUp.setBackground(SystemColor.windowBorder);
		btnSignUp.setBounds(337, 240, 231, 38);
		btnSignUp.setEnabled(false);
		panelMenu.add(btnSignUp);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(175, 189, 437, 31);
		panelMenu.add(pfSenha);
		
		DocumentListener listener = new DocumentListener() {
		    private void verificarCampos() {
		        btnSignUp.setEnabled(!tfNome.getText().isEmpty() && !tfCpf.getText().isEmpty() && !tfEmail.getText().isEmpty() && pfSenha.getPassword().length > 0);
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
		
		tfNome.getDocument().addDocumentListener(listener);
		tfCpf.getDocument().addDocumentListener(listener);
		tfEmail.getDocument().addDocumentListener(listener);
		pfSenha.getDocument().addDocumentListener(listener);
		
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean usuarioExiste = false;
				
				for(Usuario u : usuarios) {
					if(u.getCpf().equalsIgnoreCase(criarUsuario().getCpf())) {
						usuarioExiste = true;
					}
					else {
						usuarioExiste = false;
			            break;
					}
				}
				
				if(usuarioExiste) {
					javax.swing.JOptionPane.showMessageDialog(null, "Cadastro existente", "Aviso", javax.swing.JOptionPane.PLAIN_MESSAGE);
				} else {
					usuarios.add(criarUsuario());
					tfNome.setText("");
		            tfCpf.setText("");
		            tfEmail.setText("");
		            pfSenha.setText("");
		            javax.swing.JOptionPane.showMessageDialog(null, "Cadastro efetuado", "Aviso", javax.swing.JOptionPane.PLAIN_MESSAGE);
		            MenuInicial menuInicial = new MenuInicial();
					dispose();
					menuInicial.setVisible(true);
				}
				
			}
		});
		
		JLabel lblSignUp = new JLabel("SIGN-UP");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setForeground(SystemColor.text);
		lblSignUp.setFont(new Font("Arial", Font.BOLD, 40));
		lblSignUp.setBounds(144, 38, 488, 59);
		contentPane.add(lblSignUp);
	}
	
	private Usuario criarUsuario() {
        String nome = tfNome.getText();
        String cpf = tfCpf.getText();
        String email = tfEmail.getText();
        String senha = new String(pfSenha.getPassword());

        return new Usuario(nome, cpf, email, senha);
    }

}
