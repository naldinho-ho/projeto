package telaInicial;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TelaQuiz extends JFrame implements ActionListener{
	String [][] perguntas = new String[3][6];
	JRadioButton [] jrPerguntas = new JRadioButton[4];
	JLabel jlPergunta = new JLabel("");
	JLabel jlPontuacao = new JLabel("Pontuação: 0");
	int posAtual = 0;
	int pontos = 0;
	JButton jbResponder = new JButton("Responder");
	ButtonGroup bgOp = new ButtonGroup();
	public TelaQuiz() {
		super("Quizz");
		setLayout(new GridLayout(7,1));
		carregaPerguntas();
		for (int id=0;id<4;id++){
			jrPerguntas[id] = new JRadioButton();
			bgOp.add(jrPerguntas[id]);
		}
		montaTela();
		jlPontuacao.setHorizontalAlignment(JTextField.RIGHT);
		add(jlPergunta);
		add(jrPerguntas[0]);
		add(jrPerguntas[1]);
		add(jrPerguntas[2]);
		add(jrPerguntas[3]);
		add(jlPontuacao);
		add(jbResponder);
		jbResponder.addActionListener(this);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void carregaPerguntas(){
		perguntas[0][0] = "O que é uma classe?";
		perguntas[0][1] = " Classe é a descrição de um objeto, definindo estruturas de decisão e repetição.";
		perguntas[0][2] = "Classe é a descrição de um objeto, definindo if e else.";
		perguntas[0][3] = "Classe é o comportamento de um objeto.";
		perguntas[0][4] = "Classe é a definição de um conjunto de objetos que possuem o mesmo comportamento e características";
		perguntas[0][5] = "4";
		
		perguntas[1][0] = "Qual sentença define uma classe?";
		perguntas[1][1] = "Classe é o comportamento de um objeto.";
		perguntas[1][2] = "Classe é a descrição de um objeto, definindo if e else.";
		perguntas[1][3] = "Classe define um conjunto de objetos com a mesma caracteríscas e ações.";
		perguntas[1][4] = "Classe é uma linguagem de programação.";
		perguntas[1][5] = "3";
		
		perguntas[2][0] = "O que é um pacote?";
		perguntas[2][1] = "Pacote é uma linguagem de programação.";
		perguntas[2][2] = "Pacote é uma estrutura de repetição.";
		perguntas[2][3] = "Da mesma forma que organizamos nossas roupas em gavetas, os pacotes organizam as classes.";
		perguntas[2][4] = "Pacote é a descrição de um objeto, definindo estrutura de dados.";
		perguntas[2][5] = "3";
	}
	public void montaTela() {
		jlPergunta.setText(perguntas[posAtual][0]);
		for (int id=0;id<4;id++){
			jrPerguntas[id].setText(perguntas[posAtual][id+1]);
		}
	}
	public static void quiz(String [] args){
		new TelaQuiz();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int respostaCerta = Integer.parseInt(perguntas[posAtual][5]);
		
		if (jrPerguntas[respostaCerta-1].isSelected()){
			pontos++;
		} else{
			pontos--;
		}
		jlPontuacao.setText("Pontuação: " + pontos);
		if (posAtual<2)
			posAtual++;
		else
			JOptionPane.showMessageDialog(this, "Game Over");
		montaTela();
		
		
	}

}
