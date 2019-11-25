package telaInicial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal extends JFrame implements ActionListener {

	private JMenuBar jmb = new JMenuBar();
	private JMenu jogos = new JMenu("Jogos");
	private JMenu utilitarios = new JMenu("Utilitários");
	private JMenuItem jogoVelha = new JMenuItem("Jogo da Velha");
	private JMenuItem ajuda = new JMenuItem("Ajuda");
	private JMenuItem quiz = new JMenuItem("Jogo de Perguntas");
	private JMenuItem adivinha = new JMenuItem("Jogo Adivinha o Numero");
	private JDesktopPane desk = new JDesktopPane();
	private TelaJogoDaVelha telaJogoVelha;
	private TelaAjuda telaAjuda;
	private TelaQuiz telaQuiz;
	private TelaAdivinha telaAdivinha;

	public Principal() {
		setSize(800, 600);

		setJMenuBar(jmb);
		jmb.add(jogos);
		jogos.add(jogoVelha);
		jogos.add(ajuda);
		jogos.add(quiz);
		jogos.add(adivinha);

		jogoVelha.addActionListener(this);
		add(desk);
		setVisible(true);

		ajuda.addActionListener(this);
		add(desk);
		setVisible(true);

		quiz.addActionListener(this);
		add(desk);
		setVisible(true);
		
		adivinha.addActionListener(this);
		add(desk);
		setVisible(true);

		
	}

	public static void main(String[] args) {
		Principal p = new Principal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jogoVelha) {
			if (telaJogoVelha == null) {
				telaJogoVelha = new TelaJogoDaVelha();
				desk.add(telaJogoVelha);
			}

		}

		if (e.getSource() == ajuda) {
			if (telaAjuda == null) {
				telaAjuda = new TelaAjuda();
				desk.add(telaAjuda);
			}
		}

		if (e.getSource() == quiz) {
			if (telaQuiz == null) {
				telaQuiz = new TelaQuiz();
				desk.add(telaQuiz);
			}

		}
		if (e.getSource() == adivinha) {
			if (telaAdivinha == null) {
				telaAdivinha = new TelaAdivinha();
				desk.add(telaAdivinha);
			}

		}

		
	}
}
