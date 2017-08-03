import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MainClass extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton enviar,verificar;
	private JLabel resultado,dados,dados1,dados2;
	private JTextField var1,var2,var,inferencia;
	private Background construtorImage = null;
	JRadioButton atomo,sentenca,analise;
	private static int resposta,x,y;
	private static List<Atomo> varAtomo = new ArrayList<Atomo>();
	private static List<Sentenca> varSentenca = new ArrayList<Sentenca>();
	
	public MainClass(int resp){
		super("Provador Modus Ponens");
		ImageIcon icone = new ImageIcon("icone.png");
		setIconImage(icone.getImage());
		construtorImage = new Background("cinza.jpg");
		construtorImage.setSize(2000, 1500);
		panel = new JPanel();
		panel.setLayout(null);
		this.resposta = resp;

		x = 50;
		y = 70;
		varAtomo = BaseDeDados.getAtomos();
		varSentenca = BaseDeDados.getSentencas();
		if(!varSentenca.isEmpty()){
			for(int i=0;i<varSentenca.size();i++){
				dados1 = new JLabel();
				dados1.setText(varSentenca.get(i).getVar1());
				dados1.setBounds(x, y, 20, 13);
				panel.add(dados1);
				ImageIcon seta = new ImageIcon("seta.png");
				JLabel label30 = new JLabel(seta);
				label30.setBounds(x+15, y, 20, 13);
				panel.add(label30);
				dados2 = new JLabel();
				dados2.setText(varSentenca.get(i).getVar2());
				dados2.setBounds(x+40, y, 20, 13);
				panel.add(dados2);
				y = y + 20;
			}
		}
		if(!varAtomo.isEmpty()){
			for(int i=0;i<varAtomo.size();i++){
				dados = new JLabel();
				dados.setText(varAtomo.get(i).getVar());
				dados.setBounds(x, y, 250, 60);	
				panel.add(dados);
				y = y + 20;
			}
		}
				
		atomo = new JRadioButton("<html><font color = #FFFFFF size = 6>Átomo</font></html>", true);
		atomo.setBounds(50, 350, 120, 40);
		atomo.setOpaque(false);
		sentenca = new JRadioButton("<html><font color = #FFFFFF size = 6>Sentença</font></html>", false);
		sentenca.setBounds(280, 350, 140, 40);
		sentenca.setOpaque(false);
		analise = new JRadioButton("<html><font color = #FFFFFF size = 6>Inferência</font></html>", false);
		analise.setBounds(640, 350, 140, 40);
		analise.setOpaque(false);
		ButtonGroup group1 = new ButtonGroup();
		group1.add(atomo);
		group1.add(sentenca);
		group1.add(analise);
		GridBagConstraints constraints1 = new GridBagConstraints();
		constraints1.gridx = 0;
		constraints1.gridx = 1;
		
		var = new JTextField();
		var.setBounds(190, 352, 50, 40);
		panel.add(var);
		
		var1 = new JTextField();
		var1.setBounds(430, 352, 50, 40);
		panel.add(var1);
		
		var2 = new JTextField();
		var2.setBounds(550, 352, 50, 40);
		panel.add(var2);
		
		ImageIcon implica = new ImageIcon("implica.png");
		JLabel label = new JLabel(implica);
		label.setBounds(490, 360, 50, 30);
		
		inferencia = new JTextField();
		inferencia.setBounds(790, 352, 50, 40);
		panel.add(inferencia);
		
		enviar = new JButton(new ImageIcon("adicionar.png"));
		enviar.setBounds(900, 350, 169, 46);
		enviar.setBackground(Color.white);
		panel.add(enviar);
		EventoAdicionar handler1 = new EventoAdicionar();
		enviar.addActionListener(handler1);
		
		verificar = new JButton(new ImageIcon("resultado.png"));
		verificar.setBounds(1100, 350, 169, 46);
		verificar.setBackground(Color.white);
		panel.add(verificar);
		EventoVerificar handler2 = new EventoVerificar();
		verificar.addActionListener(handler2);
	
		if(resposta == 0){
			resultado = new JLabel();
			resultado.setText("<html><font color = #FFFFFF size = 7>RESULTADO: </font></html>");
			resultado.setBounds(60, 500, 450, 60);
			panel.add(resultado);
			
			ImageIcon veredito = new ImageIcon("false.png");
			JLabel label3 = new JLabel(veredito);
			label3.setBounds(330, 515, 121, 46);
			panel.add(label3);
		}else if(resposta == 1){
			resultado = new JLabel();
			resultado.setText("<html><font color = #FFFFFF size = 7>RESULTADO: </font></html>");
			resultado.setBounds(60, 500, 450, 60);
			panel.add(resultado);
			
			ImageIcon veredito = new ImageIcon("true.png");
			JLabel label4 = new JLabel(veredito);
			label4.setBounds(330, 515, 121, 46);
			panel.add(label4);			
		}
		
		panel.add(analise);
		panel.add(label);
		panel.add(atomo, constraints1);
		panel.add(sentenca, constraints1);
		panel.add(construtorImage);

		this.setContentPane(panel);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private class EventoAdicionar implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == enviar) {
				if(atomo.isSelected()==true){
					if(var.getText().charAt(0)<65 || var.getText().charAt(0)>90){
						JOptionPane.showMessageDialog(null,"OPÇÂO NÂO SUPORTADA", "ERRO",JOptionPane.ERROR_MESSAGE);
					}else{
						BaseDeDados.addAtomo(var.getText().charAt(0));
						MainClass m = new MainClass(2); 
						MainClass.this.dispose();
					}
				}else if(sentenca.isSelected()==true){
					if(var1.getText().charAt(0)<65 || var1.getText().charAt(0)>90 || var2.getText().charAt(0)<65 && var2.getText().charAt(0)>90){
						JOptionPane.showMessageDialog(null,"OPÇÂO NÂO SUPORTADA", "ERRO",JOptionPane.ERROR_MESSAGE);						
					}else{
						BaseDeDados.addSentenca(var1.getText().charAt(0), var2.getText().charAt(0));
						MainClass m = new MainClass(2);
						MainClass.this.dispose();
					}
				}
			}
		}
	}
	private class EventoVerificar implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == verificar) {
				if(analise.isSelected()==true){
					if(inferencia.getText().charAt(0)<65 || inferencia.getText().charAt(0)>90){
						JOptionPane.showMessageDialog(null, "ERRO","OPÇÂO NÂO SUPORTADA",JOptionPane.ERROR_MESSAGE);						
					}else{
						boolean result;
						result = BaseDeDados.verificarDado(inferencia.getText().charAt(0));
						if(result){
							MainClass m = new MainClass(1);
						}else{
							MainClass m = new MainClass(0);
						}
						MainClass.this.dispose();
					}
				}
			}
		}
	}
}
