package com.mycompany.mavenproject1;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator {

	private JFrame frame;
	private JTextField textField;

	private boolean isOperator = false;
	String firstnum = "0";
	String secondnum = "";
	String operations = "";

	// private void setValueToDefault() {
	// firstnum = "0";
	// secondnum = "0";
	// operations = "";
	// isOperator = false;
	// }

	private void addEventToNumButton(JButton button) {
		button.addActionListener(event -> {
			if (!textField.getText().equals("Syntax Error")) {
				String temp = event.getActionCommand();
				if (isOperator)
					secondnum += temp;
				else
					firstnum = firstnum.equals("0") && !temp.equals(".") ? temp : firstnum + temp;
				textField.setText(firstnum + operations + secondnum);
			}
		});

	}

	private void addEventToOperatorButton(JButton button) {
		button.addActionListener(event -> {
			if (!textField.getText().equals("Syntax Error")) {
				isOperator = true;
				operations = event.getActionCommand();
				textField.setText(firstnum + operations + secondnum);
			}
		});
	}

	private void addEventToButtonAC(JButton button) {
		button.addActionListener(event -> {
			firstnum = "0";
			secondnum = "";
			operations = "";
			isOperator = false;
			textField.setText(firstnum + operations + secondnum);
		});
	}

	private void addEventToButtonDel(JButton button) {
		button.addActionListener(event -> {
			if (!textField.getText().equals("Syntax Error")) {
				if (!secondnum.equals(""))
					secondnum = secondnum.substring(0, secondnum.length() - 1);
				else if (!operations.equals("")) {
					operations = "";
					isOperator = false;
				} else if (!firstnum.equals("")) {
					firstnum = firstnum.substring(0, firstnum.length() - 1);
					if (firstnum.equals(""))
						firstnum = "0";
				}
				textField.setText(firstnum + operations + secondnum);
			}
		});
	}

	private void addEventToButtonEqual(JButton button) {
		button.addActionListener(event -> {
			try {
				double numF = Double.parseDouble(firstnum);
				if (secondnum.equals("")) {
					textField.setText(firstnum);
					return;
				}
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
					if (numS == 0)
						textField.setText("Syntax Error");
					else
						textField.setText(String.format("%.2f", numF / numS));
					break;
				}
			} catch (Exception e) {
				textField.setText("Syntax Error");
			}
			isOperator = false;
			firstnum = textField.getText();
			secondnum = "";
			operations = "";
		});
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Calculator window = new Calculator();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
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
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		addEventToButtonAC(btnCancel);

		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnCancel.setBounds(12, 85, 64, 64);
		frame.getContentPane().add(btnCancel);

		JButton btnDev = new JButton("/");
		addEventToOperatorButton(btnDev);

		btnDev.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnDev.setBounds(100, 85, 64, 64);
		frame.getContentPane().add(btnDev);

		JButton btnBack = new JButton("Del");
		addEventToButtonDel(btnBack);

		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(12, 405, 64, 64);
		frame.getContentPane().add(btnBack);

		JButton btnMul = new JButton("*");
		addEventToOperatorButton(btnMul);

		btnMul.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnMul.setBounds(188, 85, 64, 64); // 276, 325, 64, 64
		frame.getContentPane().add(btnMul);

		JButton btnPlus = new JButton("+");
		addEventToOperatorButton(btnPlus);

		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnPlus.setBounds(276, 165, 64, 144);
		frame.getContentPane().add(btnPlus);

		JButton btnSub = new JButton("-");
		addEventToOperatorButton(btnSub);

		btnSub.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSub.setBounds(276, 85, 64, 64);
		frame.getContentPane().add(btnSub);

		// -------------------Row
		// 1------------------------------------------------------//
		JButton btn7 = new JButton("7");
		addEventToNumButton(btn7);

		btn7.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn7.setBounds(12, 165, 64, 64);
		frame.getContentPane().add(btn7);

		JButton btn8 = new JButton("8");
		addEventToNumButton(btn8);

		btn8.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn8.setBounds(100, 165, 64, 64);
		frame.getContentPane().add(btn8);

		JButton btn9 = new JButton("9");
		addEventToNumButton(btn9);

		btn9.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn9.setBounds(188, 165, 64, 64);
		frame.getContentPane().add(btn9);

		// -------------------Row
		// 2------------------------------------------------------//
		JButton btn4 = new JButton("4");
		addEventToNumButton(btn4);

		btn4.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn4.setBounds(12, 245, 64, 64);
		frame.getContentPane().add(btn4);

		JButton btn5 = new JButton("5");
		addEventToNumButton(btn5);

		btn5.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn5.setBounds(100, 245, 64, 64);
		frame.getContentPane().add(btn5);

		JButton btn6 = new JButton("6");
		addEventToNumButton(btn6);

		btn6.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn6.setBounds(188, 245, 64, 64);
		frame.getContentPane().add(btn6);

		// -------------------Row
		// 3------------------------------------------------------//
		JButton btn1 = new JButton("1");
		addEventToNumButton(btn1);

		btn1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn1.setBounds(12, 325, 64, 64);
		frame.getContentPane().add(btn1);

		JButton btn2 = new JButton("2");
		addEventToNumButton(btn2);

		btn2.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn2.setBounds(100, 325, 64, 64);
		frame.getContentPane().add(btn2);

		JButton btn3 = new JButton("3");
		addEventToNumButton(btn3);

		btn3.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn3.setBounds(188, 325, 64, 64);
		frame.getContentPane().add(btn3);

		// -------------------Row
		// 4------------------------------------------------------//
		JButton btn0 = new JButton("0");
		addEventToNumButton(btn0);

		btn0.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn0.setBounds(100, 405, 64, 64);
		frame.getContentPane().add(btn0);

		JButton btnDot = new JButton(".");
		addEventToNumButton(btnDot);

		btnDot.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnDot.setBounds(188, 405, 64, 64);
		frame.getContentPane().add(btnDot);

		JButton btnEqual = new JButton("=");
		addEventToButtonEqual(btnEqual);

		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnEqual.setBounds(276, 325, 64, 144);
		frame.getContentPane().add(btnEqual);
	}

}
