package Calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class History extends JFrame {

	private JPanel contentPane;
	GridBagConstraints gbc_lblNewLabel_1;
	JLabel lblNewLabel_1;
	int disp_cont=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History();
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
	public History() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		lblNewLabel_1 = new JLabel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane);
		GridBagLayout gbl_panel_display = new GridBagLayout();
		gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = disp_cont;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		disp_cont++;

		setContentPane(contentPane);
		contentPane.setLayout(gbl_panel_display);
	}

}
