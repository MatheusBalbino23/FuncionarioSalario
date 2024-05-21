package basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Programa extends JFrame {

	private JTextField nomeField;
	private JTextField vendasField;
	private JTextField comissaoField;
	private JTextField salarioField;
	private JTextField totalField;
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JRadioButton radio3;
	private JRadioButton radio4;

	public void CalculadoraComissao() {
		setTitle("Calculadora de Comissão");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLayout(new GridLayout(9, 2, 5, 5));

		// Nome do Funcionário
		add(new JLabel("Nome do funcionário:"));
		nomeField = new JTextField();
		add(nomeField);

		// Total de vendas
		add(new JLabel("Total de vendas:"));
		vendasField = new JTextField();
		add(vendasField);

		// Comissão
		add(new JLabel("Comissão:"));
		JPanel comissaoPanel = new JPanel(new GridLayout(1, 4));
		ButtonGroup grupoComissao = new ButtonGroup();
		radio1 = new JRadioButton("1%");
		radio2 = new JRadioButton("2%");
		radio3 = new JRadioButton("3%");
		radio4 = new JRadioButton("4%");
		grupoComissao.add(radio1);
		grupoComissao.add(radio2);
		grupoComissao.add(radio3);
		grupoComissao.add(radio4);
		comissaoPanel.add(radio1);
		comissaoPanel.add(radio2);
		comissaoPanel.add(radio3);
		comissaoPanel.add(radio4);
		add(comissaoPanel);

		// Valor da comissão
		add(new JLabel("Valor da comissão:"));
		comissaoField = new JTextField();
		comissaoField.setEditable(false);
		add(comissaoField);

		// Salário
		add(new JLabel("Salário:"));
		salarioField = new JTextField();
		add(salarioField);

		// Salário + Comissão
		add(new JLabel("Salário + comissão:"));
		totalField = new JTextField();
		totalField.setEditable(false);
		add(totalField);

		// Botão Calcular
		JButton calcularButton = new JButton("Calcular");
		calcularButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		add(calcularButton);

		// Adiciona um espaço vazio para manter o layout
		add(new JLabel());

		setVisible(true);
	}

	private void calcular() {
		try {
			double vendas = Double.parseDouble(vendasField.getText());
			double salario = Double.parseDouble(salarioField.getText());
			double taxaComissao = 0;

			if (radio1.isSelected()) {
				taxaComissao = 0.01;
			} else if (radio2.isSelected()) {
				taxaComissao = 0.02;
			} else if (radio3.isSelected()) {
				taxaComissao = 0.03;
			} else if (radio4.isSelected()) {
				taxaComissao = 0.04;
			}

			double comissao = vendas * taxaComissao;
			double salarioTotal = salario + comissao;

			comissaoField.setText(String.format("%.2f", comissao));
			totalField.setText(String.format("%.2f", salarioTotal));

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.", "Erro de Entrada",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
