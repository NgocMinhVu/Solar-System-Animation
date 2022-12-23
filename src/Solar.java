import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class Solar extends JPanel implements ActionListener, MouseMotionListener {
	
	private static final long serialVersionUID = 1L;
	
	private Form a;
	private double x, y, xf, yf, xp, yp, xps, yps;
	
	private int current = -2;
	private double inc = 0.015;
	private Image bg = new ImageIcon("C:\\background.png").getImage();
	
	private double[][] Planet = new double[6][8];
	private double[][] Satellite = new double[4][5];
	
	private Ellipse2D sun, mercury, venus, earth, mars, jupiter, saturn, uranus, neptune, moon, ganymede, callisto, titan, triton;
	private Ellipse2D[] planet = {mercury, venus, earth, mars, jupiter, saturn, uranus, neptune};
	private Ellipse2D[] satellite = {moon, ganymede, callisto, titan, triton};
	
	private Timer timer = new Timer(5, this);
	
	
	private void posPlanet(double d, double ma, double mi, double de, double t) {
		double diameter = d;
		double major = ma;
		double minor = mi;
		double deviation = de;
		double theta = t;
		
		x = (xf/2) + deviation + (major * Math.cos(theta));
    	y = (yf/2) + (minor * Math.sin(theta));

    	xp = (int) (Math.round(x) - (diameter/2));
    	yp = (int) (Math.round(y) - (diameter/2));	
	}	
		
	
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	    xf = getWidth();
	    yf = getHeight();
	    
	    g.drawImage(bg, 0, 0, this);
	    
	    Graphics2D g2d = (Graphics2D) g;
	    
	    sun = new Ellipse2D.Double(xf/2-18, yf/2-18, (double) 36, (double) 36);
	    g2d.setColor(new Color(255, 205, 40));
	    g2d.fill(sun);
	    
	    for(int i = 0; i < Planet[5].length; i++) {
	    	int z = -1;
	    	int j = -1;
	    	double diameter = Planet[0][i];
	    	
	    	posPlanet(diameter, Planet[1][i], Planet[2][i], Planet[3][i], Planet[5][i]);
	    	
	    	switch(i) {
		    case 0:
		   		g2d.setColor(new Color(153, 153, 153));
		   		break;
	    	case 1:
		  		g2d.setColor(new Color(241,156,153));
	    		break;
	    	case 2:
		   	    GradientPaint twoColorGradient = new GradientPaint((int)xp, (int)yp+2, 
		   	    		new Color(18, 136, 238), (int)xp+4, (int)yp-1, new Color(127, 195, 141));
		   	    g2d.setPaint(twoColorGradient);
		   	    z = 0;
		   	    break;
	    	case 3:
	    		g2d.setColor(new Color(255, 51, 51));
	    		break;
		    case 4:
		   		g2d.setColor(new Color(230, 197, 158));
		   		z = 1;
		   		j = 2;
		   		break;
		   	case 5:
		   		g2d.setColor(new Color(227, 216, 182));
	    		z = 3;
		   		break;
	    	case 6:
		    	g2d.setColor(new Color(204, 229, 255));
		    	break;
		   	case 7:
		   		g2d.setColor(new Color(27, 161, 226));
		   		z = 4;
		   		break;
	    	}
	    	
	    	planet[i] = new Ellipse2D.Double(xp, yp, diameter, diameter);
	    	g2d.fill(planet[i]);
	    	
	    	if(z != -1) {
	    		diameter = Satellite[0][z];
	    		
	    		xps = x + (Satellite[1][z] * Math.cos(Satellite[3][z])) - (diameter/2);
		    	yps = y + (Satellite[1][z] * Math.sin(Satellite[3][z])) - (diameter/2);
		    	
		    	switch(z) {
		    	case 0:
		    		g2d.setColor(new Color(217, 217, 217));
		    		break;
		    	case 1:
		    		g2d.setColor(new Color(111, 95, 72));
		    		break;
		    	case 3:
		    		g2d.setColor(new Color(123, 222, 202));
		    		break;
		    	case 4:
		    		g2d.setColor(new Color(191, 185, 197));
		    		break;
		    	}
		    	
		    	satellite[z] = new Ellipse2D.Double(xps, yps, diameter, diameter);
		    	g2d.fill(satellite[z]);
		    	
		    	if(j != -1) {
		    		diameter = (int) Math.round(Satellite[0][j]);
		    		
		    		xps = (int) ((int) Math.round(x + (Satellite[1][j] * Math.cos(Satellite[3][j]))) - (diameter/2));
			    	yps = (int) ((int) Math.round(y + (Satellite[1][j] * Math.sin(Satellite[3][j]))) - (diameter/2));
		    		
			    	satellite[j] = new Ellipse2D.Double(xps, yps, diameter, diameter);
			    	g2d.setColor(new Color(215, 189, 176));
			    	g2d.fill(satellite[j]);
		    	}
	    	}
	    }
	}
	
		
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < Planet[5].length; i++) {
				Planet[5][i] = Planet[5][i] + (inc/Planet[4][i]);
			if(Planet[5][i] >= (Math.PI*2)) {
				Planet[5][i] = Planet[5][i] - (Math.PI*2);
			}
		}
		
		for(int i = 0; i < Satellite[3].length; i++) {
			Satellite[3][i] = Satellite[3][i] + (inc/Satellite[2][i]);
			if(Satellite[3][i] >= (Math.PI*2)) {
				Satellite[3][i] = Satellite[3][i] - (Math.PI*2);
			}
		}
		
		repaint();
	}
			
	
	public void mouseMoved(MouseEvent e) {
		boolean isIn = false;
		int index = -2;
		
		//Check if the coordinate of mouse is within the Sun.
		if(sun.contains(e.getX(), e.getY())){
			index = -1;
			isIn = true;
		}
		
		//Loop through planet array to check if mouse is within a planet.
		for(int i = 0; i < 8; i++) {
			if(planet[i].contains(e.getX(), e.getY())) {
				index = i;
				isIn = true;
			}
		}
		
		if(isIn == true) {
			//Stop the animation.
			timer.stop();
			
			//Check whether an instance of the Form class of the planet is already exist.
			if(index != current) {
				if(index == -1) {
					a = new Form();
					a.setVisible(true);
					current = index;
				}else{
					a = new Form(index);
					a.setVisible(true);
					current = index;	
				}
			}
			
			//If the Form a is disposed, the integer current is changed to -2.
			if(a.isDisplayable() == false) {
				current = -2;
			}
		}else{
			if(timer.isRunning() == false) {
				a.dispose();
				timer.start();
			}
		}
	}
	

	public void mouseDragged(MouseEvent e) {
		
	}

	
	Solar(){
		timer.start();
		
		FileRead a = new FileRead();
		Planet = a.loadPlanetRatio();
		Satellite = a.loadSatelliteRatio();
		
		this.addMouseMotionListener((MouseMotionListener) this);
		
	}

}