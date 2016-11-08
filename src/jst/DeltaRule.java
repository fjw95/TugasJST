package jst;

public class DeltaRule {

	public static void main(String[] args) {

		int[][]  Data      = {
				{1,1,1,1,1,1,0,0,0,0,1,0,1,1,1,1,0,0,0,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,0,0,0,0,1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,0,0,0,0,1,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1},
				{1,0,0,0,1,1,0,0,0,1,1,1,1,1,1,1,0,0,0,1,1,0,0,0,1,0},
				{1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,0,0,0,1,0},
				{1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,0},
				{0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0},
				{1,1,1,1,1,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,1,1,1,1,1,0},
				{0,1,1,1,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,1,1,1,1,1,0}
				};
		double[] Bobot     = {0.1, 0.3, 0.5, 0.7, 0.9,0.11, 0.13, 0.15, 0.17, 0.19,0.21, 0.23, 0.25, 0.27, 0.29,
								0.31, 0.33, 0.35, 0.37, 0.39,0.41, 0.43, 0.45, 0.47, 0.49};
		double   LR        = 0.2;
		double   Threshold = 0.5;
		int i, j, Y, Error, Epoch;
		double Y_In;
		boolean Ulang = true;
		
		Epoch = 1;
		while (Ulang == true) {
			Ulang = false;
			System.out.println("Epoch ke : " + Epoch);
			for (i = 0; i < Data.length; i++) {
				Y_In = 0;
				for (j = 0; j < Bobot.length; j++) {
					Y_In = Y_In + Data[i][j] * Bobot[j];
				}
				//Fungsi aktivasi
				if (Y_In < Threshold) {
					Y = 0;
				} 
				else {
					Y = 1;
				}
				Error = Data[i][25] - Y;
				if (Error == 1) {
					Ulang = true;
				}
				Bobot[0] = Bobot[0] + LR * Error * Data[i][0];
				Bobot[1] = Bobot[1] + LR * Error * Data[i][1];
				System.out.println("Y :" + Y + " Error : " + Error);
				System.out.println("W1 : " + Bobot[0] + " W2 : " + Bobot[1]);
				System.out.println("---------------------------------------");
			}
			Epoch++;
		}
	
	}

}
