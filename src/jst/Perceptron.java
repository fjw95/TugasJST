package jst;

public class Perceptron {

	public static void main(String[] args) {
		int[][] pattern = {
				{1,1,1,1,1,1,-1,-1,-1,-1,1,-1,1,1,1,1,-1,-1,-1,1,1,1,1,1,1},
				{1,1,1,1,1,1,-1,-1,-1,-1,1,-1,1,1,1,1,-1,1,-1,1,1,1,1,1,1},
				{1,1,1,1,1,1,-1,-1,-1,-1,1,-1,1,1,1,1,1,-1,-1,1,1,1,1,1,1},
				{1,-1,-1,-1,1,1,-1,-1,-1,1,1,1,1,1,1,1,-1,-1,-1,1,1,-1,-1,-1,1},
				{1,-1,-1,-1,1,1,1,1,1,1,1,1,1,1,1,1,-1,-1,-1,1,1,-1,-1,-1,1},
				{1,-1,-1,-1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,-1,-1,-1,1},
				{-1,-1,1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1},
				{1,1,1,1,1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,1,1,1,1,1},
				{-1,1,1,1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,1,1,1,1,1}
				};
		double[] weight = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		double learningRate = 0.8, threshold = 0.5, bias = 0;
		
		// Method pengenalan pola huruf G
		recognizingPatternG(pattern, weight, learningRate, threshold, bias);
		// Method pengenalan pola huruf H 
		recognizingPatternH(pattern, weight, learningRate, threshold, bias);
		// Method pengenalan pola huruf I
		recognizingPatternI(pattern, weight, learningRate, threshold, bias);
	}
	
	//TODO
	private static void recognizingPatternG(int[][] pattern, double[] weight, 
			double learningRate, double threshold, double bias) {
		
		double[] target = {1,1,1,-1,-1,-1,-1,-1,-1};
		int i, j, y, epoch;
		double yIn;
		boolean isLoop = true;
	
		epoch = 1;
		while (isLoop == true) {
			isLoop = false;
			for (i = 0; i < pattern.length; i++) {
				yIn  = 0;
				for (j = 0; j < weight.length; j++) {
					yIn  = yIn + pattern[i][j] * weight[j];
				}
				yIn = yIn + bias;
			
				//Fungsi aktivasi
				y = activationFunc(yIn, threshold);
				
				// Mengubah bobot dan bias jika y <> target
				if (y != target[i]) {
					isLoop = true;
					for (j = 0; j < weight.length; j++) {
						weight[j]  = weight[j] + learningRate * target[i] * pattern[i][j];
					}
					bias = bias + learningRate * target[i];
				}
					j = i + 1;
				}
			epoch++;
		}
		printResult(weight, epoch, bias, "G");
}
	
	//TODO
	private static void recognizingPatternH(int[][] pattern, double[] weight, 
			double learningRate, double threshold, double bias) {
		
		double[] target = {-1,-1,-1,1,1,1,-1,-1,-1};
		int i, j, y, epoch;
		double yIn;
		boolean isLoop = true;
	
		epoch = 1;
		while (isLoop == true) {
			isLoop = false;
			for (i = 0; i < pattern.length; i++) {
				yIn  = 0;
				for (j = 0; j < weight.length; j++) {
					yIn  = yIn + pattern[i][j] * weight[j];
				}
				yIn = yIn + bias;
			
				//Fungsi aktivasi
				y = activationFunc(yIn, threshold);
				
				// Mengubah bobot dan bias jika y <> target
				if (y != target[i]) {
					isLoop = true;
					for (j = 0; j < weight.length; j++) {
						weight[j]  = weight[j] + learningRate * target[i] * pattern[i][j];
					}
					bias = bias + learningRate * target[i];
				}
					j = i + 1;
				}
			epoch++;
		}
		printResult(weight, epoch, bias, "H");
}
	
	//TODO
	private static void recognizingPatternI(int[][] pattern, double[] weight, 
			double learningRate, double threshold, double bias) {
		
		double[] target = {-1,-1,-1,-1,-1,-1,1,1,1};
		int i, j, y, epoch;
		double yIn;
		boolean isLoop = true;
	
		epoch = 1;
		while (isLoop == true) {
			isLoop = false;
			for (i = 0; i < pattern.length; i++) {
				yIn  = 0;
				for (j = 0; j < weight.length; j++) {
					yIn  = yIn + pattern[i][j] * weight[j];
				}
				yIn = yIn + bias;
			
				//Fungsi aktivasi
				y = activationFunc(yIn, threshold);
				
				// Mengubah bobot dan bias jika y <> target
				if (y != target[i]) {
					isLoop = true;
					for (j = 0; j < weight.length; j++) {
						weight[j]  = weight[j] + learningRate * target[i] * pattern[i][j];
					}
					bias = bias + learningRate * target[i];
				}
					j = i + 1;
				}
			epoch++;
		}
		printResult(weight, epoch, bias, "I");		
}
	
	//TODO
	private static void printResult(double[] weight, int epoch, double bias,
			String alphabet) {
		System.out.println("Pengenalan pola huruf " + alphabet + " membutuhkan " + epoch + " epoch");
		System.out.println("Dengan bobot akhir : ");
		for(int idx = 0; idx < weight.length; idx++){
			int no = idx + 1;
		System.out.println("W" + no +"      : " + weight[idx]);
		}
		System.out.println("Dan Bias : " + bias);
		System.out.println("--------------------------------");	
	}

	//TODO
	private static int activationFunc(double yIn, double threshold) {
		int y = 0;
		
		if (yIn > threshold) 
			y = 1;
		else if (yIn < -threshold) 
			y = -1;
		else 
			y = 0;
	
		return y;	
	}
}
