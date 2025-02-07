package Assignment1_CSCN72040_Group16;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		DataDAO dataDAO = new DataDAO();

        String filePath = "testingData.txt";

        // Read data from file
        List<Data> dataList = dataDAO.readDataFromFile(filePath);

        // Print the data
        System.out.println("Data read from file:");
        for (Data data : dataList) {
            System.out.println("Position: " + data.getPosition() +
                               ", X: " + data.getX() +
                               ", Y: " + data.getY() +
                               ", Z: " + data.getZ());
        }
	}

}
