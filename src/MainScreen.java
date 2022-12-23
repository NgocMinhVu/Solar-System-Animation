import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Dimension;


public class MainScreen {

	
	private JFrame frame;
	Solar a;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainScreen() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(700, 700));
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
		Solar a = new Solar();
		a.setBounds(0, 0, 678, 644);
		frame.getContentPane().add(a);
		
		frame.setVisible(true);
		frame.revalidate();
	}
}



