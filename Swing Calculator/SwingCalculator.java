import javax.swing.*; // Using Swing components
import java.awt.*;
import java.awt.event.*;

// Swing application extends from javax.swing.JFrame
public class SwingCalculator extends JFrame {
	private JTextField tfDisplay;
	private int result = 0; // the result so far
	private String numberInStr = ""; // the number entered as String
	private char previousOpr = ' '; // the previous operator
	private char currentOpr = ' '; // the current operator
	// Constructor to setup the UI

	public SwingCalculator() {
		JPanel panelDisplay = new JPanel(new FlowLayout());
		tfDisplay = new JTextField("0", 20);
		panelDisplay.add(tfDisplay);
		JPanel panelJButtons = new JPanel(new GridLayout(4, 4));

		JButton btnSeven = new JButton("7");
		panelJButtons.add(btnSeven);

		JButton btnEight = new JButton("8");
		panelJButtons.add(btnEight);

		JButton btnNine = new JButton("9");
		panelJButtons.add(btnNine);

		JButton btnAdd = new JButton("+");
		panelJButtons.add(btnAdd);

		JButton btnFour = new JButton("4");
		panelJButtons.add(btnFour);

		JButton btnFive = new JButton("5");
		panelJButtons.add(btnFive);

		JButton btnSix = new JButton("6");
		panelJButtons.add(btnSix);

		JButton btnMinus = new JButton("-");
		panelJButtons.add(btnMinus);

		JButton btnOne = new JButton("1");
		panelJButtons.add(btnOne);

		JButton btnTwo = new JButton("2");
		panelJButtons.add(btnTwo);

		JButton btnThree = new JButton("3");
		panelJButtons.add(btnThree);

		JButton btnMultiply = new JButton("*");
		panelJButtons.add(btnMultiply);

		JButton btnClear = new JButton("C");
		panelJButtons.add(btnClear);
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				result=0;
				tfDisplay.setText("0");
			}
		});

		JButton btnZero = new JButton("0");
		panelJButtons.add(btnZero);

		JButton btnEqual = new JButton("=");
		panelJButtons.add(btnEqual);

		JButton btnDivide = new JButton("/");
		panelJButtons.add(btnDivide);

		btnZero.addActionListener(new NumberBtnListener());
		btnOne.addActionListener(new NumberBtnListener());
		btnTwo.addActionListener(new NumberBtnListener());
		btnThree.addActionListener(new NumberBtnListener());
		btnFour.addActionListener(new NumberBtnListener());
		btnFive.addActionListener(new NumberBtnListener());
		btnSix.addActionListener(new NumberBtnListener());
		btnSeven.addActionListener(new NumberBtnListener());
		btnEight.addActionListener(new NumberBtnListener());
		btnNine.addActionListener(new NumberBtnListener());

		btnAdd.addActionListener(new OprBtnListener());
		btnMinus.addActionListener(new OprBtnListener());
		btnMultiply.addActionListener(new OprBtnListener());
		btnDivide.addActionListener(new OprBtnListener());
		btnEqual.addActionListener(new OprBtnListener());
		btnClear.addActionListener(new OprBtnListener());

		setLayout(new BorderLayout()); // "super" Frame sets to BorderLayout
		add(panelDisplay, BorderLayout.NORTH);
		add(panelJButtons, BorderLayout.CENTER);

		setTitle("Swing Calculator"); // "super" Frame sets title
		setSize(300, 200); // "super" Frame sets initial size
		setVisible(true); // "super" Frame shows
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// Number JButtons listener (inner class)
	private class NumberBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			numberInStr += evt.getActionCommand();
			tfDisplay.setText(numberInStr);
		}
	}

	// Operator buttons listener (inner class)
	private class OprBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			previousOpr = currentOpr; // save
			currentOpr = evt.getActionCommand().charAt(0);
			switch (previousOpr) {
			case 'C':
				result = Integer.parseInt(numberInStr);
				break;
			case ' ':
				result = Integer.parseInt(numberInStr);
				break;
			case '+':
				result += Integer.parseInt(numberInStr);
				break;
			case '-':
				result -= Integer.parseInt(numberInStr);
				break;
			case '*':
				result *= Integer.parseInt(numberInStr);
				break;
			case '/':
				result /= Integer.parseInt(numberInStr);
				break;
			case '=': // no numberInStr, do nothing
				break;
			}
			numberInStr = "";
			tfDisplay.setText(result + "");
		}
	}

	public static void main(String[] args) {
		new SwingCalculator();
	}
}