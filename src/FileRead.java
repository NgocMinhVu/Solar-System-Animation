import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileRead{
	
	double[][] PlanetRatio = new double[6][8];
	double[][] SatelliteRatio = new double[4][5];
	
	String[][] PlanetInfo = new String[7][8];
	
	Planet mercury, venus, earth, mars, jupiter, saturn, uranus, neptune;
	Planet[] PlanetForm = {mercury, venus, earth, mars, jupiter, saturn, uranus, neptune};
	
	
	FileRead(){ 
		readRatio();
		readInfo();
	}
	
	
	private void readInfo() {
		String path = "C:\\information.csv";
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			int count = 0;
			
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				PlanetInfo[count] = values;
				count = count +1;
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < PlanetInfo[0].length; i++) {
			PlanetForm[i] = new Planet(PlanetInfo[0][i], PlanetInfo[1][i], PlanetInfo[2][i], 
					PlanetInfo[3][i], PlanetInfo[4][i], PlanetInfo[5][i], PlanetInfo[6][i]);
		}
	}
	
	
	private void readRatio() {
		String path = "C:\\ratio.csv";
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			int count = 0;
			
			while((line = br.readLine()) != null) {
				String[] values = line.split(",");
				
				double temp;
				
				for(int i = 0; i < values.length; i++) {
					temp = Double.parseDouble((String) values[i]);
					
					if(count < 6) {
						PlanetRatio[count][i] = temp;
					}else {
						SatelliteRatio[count-6][i] = temp;
					}
				}
				count = count + 1;
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Planet[] loadPlanetForm(){
		return PlanetForm;
	}
	
	
	public double[][] loadPlanetRatio() {
		return PlanetRatio;
	}
	
	
	public double[][] loadSatelliteRatio(){
		return SatelliteRatio;
	}
	
}
