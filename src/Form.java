import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class Form extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	FileRead a = new FileRead();
	
	//Get the array PlanetForm from class FileRead
	Planet[] PlanetInfo = a.loadPlanetForm();
	

	public Form() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, (int) (screenSize.getHeight()/2 - 125), 250, 125);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name: Sun");
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 14));
		lblNewLabel.setBounds(15, 6, 198, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Classification: Star");
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(15, 32, 198, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Radius (km): 696,340");
		lblNewLabel_2.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(15, 58, 198, 20);
		contentPane.add(lblNewLabel_2);
	}
	
	
	public Form(int n) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, (int) (screenSize.getHeight()/2 - 125), 250, 250);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Planet name: " + PlanetInfo[n].getName());
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 14));
		lblNewLabel.setBounds(15, 6, 198, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Classification: " + PlanetInfo[n].getClassification());
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(15, 32, 198, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Radius (km): " + PlanetInfo[n].getRadius());
		lblNewLabel_2.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(15, 58, 198, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Distance from the Sun (AU): " + PlanetInfo[n].getDistance());
		lblNewLabel_3.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(15, 84, 198, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Number of moons: " + PlanetInfo[n].getMoon());
		lblNewLabel_4.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(15, 110, 198, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Rings: " + PlanetInfo[n].getRing());
		lblNewLabel_5.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(15, 136, 198, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Orbit period (Earth year): " + PlanetInfo[n].getPeriod());
		lblNewLabel_6.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(15, 162, 198, 20);
		contentPane.add(lblNewLabel_6);
	}
}
