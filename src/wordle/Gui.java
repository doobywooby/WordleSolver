package wordle;

import javax.swing.*;

public class Gui {

	JFrame window = new JFrame("Wordle Solver");
	JPanel panel = new JPanel();
	
	public static JCheckBox[] yellowChecks = new JCheckBox[5];
	public static JCheckBox[] greenChecks = new JCheckBox[5];
	
	static JTextField[] letters = new JTextField[5];
	public static JCheckBox g1 = new JCheckBox();
	public static JCheckBox g2 = new JCheckBox();
	public static JCheckBox g3 = new JCheckBox();
	public static JCheckBox g4 = new JCheckBox();
	public static JCheckBox g5 = new JCheckBox();
	public static JCheckBox y1 = new JCheckBox();
	public static JCheckBox y2 = new JCheckBox();
	public static JCheckBox y3 = new JCheckBox();
	public static JCheckBox y4 = new JCheckBox();
	public static JCheckBox y5 = new JCheckBox();
	
	public static JTextArea wordArea;
	
	/*
	static JTextField letter1 = new JTextField(5);
	static JTextField letter2 = new JTextField(5);
	static JTextField letter3 = new JTextField(5);
	static JTextField letter4 = new JTextField(5);
	static JTextField letter5 = new JTextField(5);
	*/
	static JTextField used = new JTextField(5);
	
	public Gui() {
		setFrame();
		setLabels();
		initWordArea();
		setButtons();
		setInput();
		windowSetup();
	}
	

	private void setFrame() {
		/**
		 * Creates the window.
		 */
		//panel.setLayout(new BorderLayout());
		panel.setLayout(null);
	}
	
	private void setLabels() {
		// labels for the letter section
		JLabel wordLabel = new JLabel("Letters: ");
		wordLabel.setBounds(250, 93, 150, 30);
		panel.add(wordLabel);
		
		//label for used letters
		JLabel usedLabel = new JLabel("Used Letters: ");
		usedLabel.setBounds(470, 93, 100, 30);
		panel.add(usedLabel);
		
		// green/yellow
		JLabel green = new JLabel("Green: ");
		green.setBounds(250, 120, 50, 30);
		panel.add(green);
		JLabel yellow = new JLabel("Yellow: ");
		yellow.setBounds(250, 140, 50, 30);
		panel.add(yellow);
	}
	
	public void initWordArea() {
	    wordArea = new JTextArea();
	    wordArea.setBounds(50, 300, 700, 400);
	    wordArea.setEditable(false);
	    wordArea.setLineWrap(true);
	    wordArea.setWrapStyleWord(true);

	    JScrollPane scrollPane = new JScrollPane(wordArea);
	    scrollPane.setBounds(50, 300, 700, 400);
	    panel.add(scrollPane);
	}
	
	private void setButtons() {
		// button setup
		JButton refresh = new JButton("Refresh words");
		refresh.setBounds(300, 175, 150, 30);
		refresh.addActionListener(e -> WordSort.refresh());
		panel.add(refresh);	
	}
	
	private void setInput() {
		///
		/// setup text input
		///
		///
		
		
		for (int i = 0; i < 5; i++) {
		    letters[i] = new JTextField(1);
		    letters[i].setBounds(300 + i * 30, 100, 20, 20);
		    panel.add(letters[i]);
		}
		
		used.setBounds(550, 100, 200, 20);
		panel.add(used);
		
		///
		/// setup green/yellow checkboxes
		 
		setCheckbox(300, 125);
		
		//not very efficient.....
	}
	
	public static String getWord() {
	    StringBuilder word = new StringBuilder();

	    for (JTextField letter : letters) {
	        word.append(letter.getText());
	    }

	    return word.toString();
	}
	
	
	private void setCheckbox(int startX, int startY) {
	    for (int i = 0; i < 5; i++) {
	        greenChecks[i] = new JCheckBox("" + (i + 1));
	        yellowChecks[i] = new JCheckBox("" + (i + 1));

	        int x = startX + i * 30;

	        greenChecks[i].setBounds(x, startY, 25, 25);
	        yellowChecks[i].setBounds(x, startY + 20, 25, 25);

	        panel.add(greenChecks[i]);
	        panel.add(yellowChecks[i]);
	    }
	}
	
	private void windowSetup() {
		// window setup
		window.add(panel);
		window.setSize(800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
	}
}
