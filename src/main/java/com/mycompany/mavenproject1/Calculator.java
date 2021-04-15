/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator {

	private JFrame frame;
	private JTextField textField;

	private boolean isSecondNum = false;
	private boolean isFirstNum = true;
	private boolean isOperator = false;
	String firstnum = "";
	String secondnum = "";
	String operations = "";

	private void setDefaultValue() {

	}

	private void addEventToButton(JButton button) {
		button.addActionListener(event -> {
			ArrayList<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
			if (operators.contains(event.getActionCommand())) { // neu event bang + - * /
				isOperator = true;
				textField.setText(event.getActionCommand());
				operations = event.getActionCommand();
			} else if (event.getActionCommand().equals("AC")) {
				firstnum = "0";
				secondnum = "";
				operations = "";
				// textField.setText("0");
				// return;
			} else if (event.getActionCommand().equals("Del")) {
				if (!secondnum.equals(""))
					secondnum = secondnum.substring(0, secondnum.length() - 1);
				else if (!operations.equals("")) {
					operations = "";
					isOperator = false;
				} else if (!firstnum.equals(""))
					firstnum = firstnum.substring(0, firstnum.length() - 1);
				else {
					textField.setText("0");
					return;
				}

			} else if (event.getActionCommand().equals("=")) {
				isOperator = false;
				double numF = firstnum.equals("") ? 0 : Double.parseDouble(firstnum);
				double numS = Double.parseDouble(secondnum);
				switch (operations) {
				case "+":
					textField.setText(String.format("%.2f", numF + numS));
					break;
				case "-":
					textField.setText(String.format("%.2f", numF - numS));
					break;
				case "*":
					textField.setText(String.format("%.2f", numF * numS));
					break;
				case "/":
					textField.setText(String.format("%.2f", numF / numS));
					break;
				}
				firstnum = textField.getText();
				secondnum = "";
				operations = "";
				return;
			} else { // cac nut con lai --> number .
				if (isOperator)
					secondnum += event.getActionCommand();
				else
					firstnum += event.getActionCommand();
			}
			textField.setText(firstnum + operations + secondnum);
		});

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.setDefaultValue();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 371, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 26));
		textField.setText("0");
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(12, 13, 330, 59);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		// -------------------Row
		// 0------------------------------------------------------//

		JButton btnCancel = new JButton("AC");
		addEventToButton(btnCancel);

		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnCancel.setBounds(12, 85, 64, 64);
		frame.getContentPane().add(btnCancel);

		JButton btnDev = new JButton("/");
		addEventToButton(btnDev);

		btnDev.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnDev.setBounds(100, 85, 64, 64);
		frame.getContentPane().add(btnDev);

		JButton btnBack = new JButton("Del");
		addEventToButton(btnBack);

		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(12, 405, 64, 64);
		frame.getContentPane().add(btnBack);

		JButton btnMul = new JButton("*");
		addEventToButton(btnMul);

		btnMul.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnMul.setBounds(188, 85, 64, 64); // 276, 325, 64, 64
		frame.getContentPane().add(btnMul);

		/*
		 * JButton btnPerc = new JButton("%"); btnPerc.addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent e) { firstnum =
		 * Double.parseDouble(textField.getText()); textField.setText(""); operations =
		 * "%"; } }); btnPerc.setFont(new Font("Tahoma", Font.BOLD, 22));
		 * btnPerc.setBounds(188, 85, 64, 64); frame.getContentPane().add(btnPerc);
		 */

		JButton btnPlus = new JButton("+");
		addEventToButton(btnPlus);

		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnPlus.setBounds(276, 165, 64, 144);
		frame.getContentPane().add(btnPlus);

		JButton btnSub = new JButton("-");
		addEventToButton(btnSub);

		btnSub.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSub.setBounds(276, 85, 64, 64);
		frame.getContentPane().add(btnSub);

		// -------------------Row
		// 1------------------------------------------------------//
		JButton btn7 = new JButton("7");
		addEventToButton(btn7);

		btn7.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn7.setBounds(12, 165, 64, 64);
		frame.getContentPane().add(btn7);

		JButton btn8 = new JButton("8");
		addEventToButton(btn8);

		btn8.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn8.setBounds(100, 165, 64, 64);
		frame.getContentPane().add(btn8);

		JButton btn9 = new JButton("9");
		addEventToButton(btn9);

		btn9.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn9.setBounds(188, 165, 64, 64);
		frame.getContentPane().add(btn9);

		// -------------------Row
		// 2------------------------------------------------------//
		JButton btn4 = new JButton("4");
		addEventToButton(btn4);

		btn4.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn4.setBounds(12, 245, 64, 64);
		frame.getContentPane().add(btn4);

		JButton btn5 = new JButton("5");
		addEventToButton(btn5);

		btn5.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn5.setBounds(100, 245, 64, 64);
		frame.getContentPane().add(btn5);

		JButton btn6 = new JButton("6");
		addEventToButton(btn6);

		btn6.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn6.setBounds(188, 245, 64, 64);
		frame.getContentPane().add(btn6);

		// -------------------Row
		// 3------------------------------------------------------//
		JButton btn1 = new JButton("1");
		addEventToButton(btn1);

		btn1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn1.setBounds(12, 325, 64, 64);
		frame.getContentPane().add(btn1);

		JButton btn2 = new JButton("2");
		addEventToButton(btn2);

		btn2.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn2.setBounds(100, 325, 64, 64);
		frame.getContentPane().add(btn2);

		JButton btn3 = new JButton("3");
		addEventToButton(btn3);

		btn3.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn3.setBounds(188, 325, 64, 64);
		frame.getContentPane().add(btn3);

		// -------------------Row
		// 4------------------------------------------------------//
		JButton btn0 = new JButton("0");
		addEventToButton(btn0);

		btn0.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn0.setBounds(100, 405, 64, 64);
		frame.getContentPane().add(btn0);

		JButton btnDot = new JButton(".");
		addEventToButton(btnDot);

		btnDot.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnDot.setBounds(188, 405, 64, 64);
		frame.getContentPane().add(btnDot);

		JButton btnEqual = new JButton("=");
		addEventToButton(btnEqual);

		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnEqual.setBounds(276, 325, 64, 144);
		frame.getContentPane().add(btnEqual);
	}

}
