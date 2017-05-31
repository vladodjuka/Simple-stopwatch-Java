import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnStart;
	private JComboBox comboBox;
	private JLabel label;
	
	
	
	private Stopwatch de;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnStart());
		contentPane.add(getComboBox());
		contentPane.add(getLabel());
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("Start");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int time = 0;
					switch(comboBox.getSelectedIndex()){
					case 0: time=1000;break;
					case 1: time=10;break;
					}
				    
					if(btnStart.getText().equalsIgnoreCase("start")){
						de = new Stopwatch(label, time);
						de.start();
						btnStart.setText("exit");
					}
					else{
						btnStart.setText("start");
						de.interrupt();
						//de.
					}
				}
			});
			btnStart.setBounds(362, 27, 89, 23);
		}
		return btnStart;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(58, 28, 89, 20);
			comboBox.addItem("Normal");
			comboBox.addItem("Super Speed");
		}
		return comboBox;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setFont(new Font("Tahoma", Font.PLAIN, 18));
			label.setBounds(196, 145, 219, 71);
		}
		return label;
	}
}
