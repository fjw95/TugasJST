package jst;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		// Pola alphabet G, H, dan I
		double[][] pola = {{1,1,1,1,1,1,-1,-1,-1,-1,1,-1,1,1,1,1,-1,-1,-1,1,1,1,1,1,1},
						{1,-1,-1,-1,1,1,-1,-1,-1,1,1,1,1,1,1,1,-1,-1,-1,1,1,-1,-1,-1,1},
						{-1,-1,1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1}};
		
		double[][] test = {{1,1,1,1,1,1,-1,-1,-1,-1,1,1,1,1,1,1,-1,-1,-1,1,1,1,1,1,1},
						{1,1,1,1,1,1,-1,-1,-1,-1,1,-1,1,1,1,1,-1,1,-1,1,1,1,1,1,1},
						{1,1,1,1,1,1,-1,-1,-1,-1,1,-1,1,1,1,1,1,-1,-1,1,1,1,1,1,1},
						{1,-1,-1,-1,1,1,-1,-1,-1,1,1,1,1,1,1,1,1,1,1,1,1,-1,-1,-1,1},
						{1,-1,-1,-1,1,1,1,1,1,1,1,1,1,1,1,1,-1,-1,-1,1,1,-1,-1,-1,1},
						{1,-1,-1,-1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,-1,-1,-1,1},
						{-1,1,1,1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,-1,1,1,1,-1},
						{1,1,1,1,1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,1,1,1,1,1},
						{-1,1,1,1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,-1,-1,1,1,1,1,1}};
		// Target untuk Pola G, H, dan I
		double[] target = {1,0,-1};
		
		double[] bobot = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		perceptron(pola, test, target, bobot);
	}

	private static void perceptron(double[][] pattern, double[][] test, double[] target,
			double[] bobot) {
		  
		double threshold = 0.5, bias = 0, learningRate = 0.8, y_in = 0, y = 0, x = 0, w, t;
		
		for (int a = 0; a < 100; a++) {
			System.out.println("Epoch " + a);
			boolean isFinished = true;
			for(int i = 0; i < pattern.length; i++) {
				System.out.println("Data " + i);
				double z = 0;
				 
				for(int j = 0; j < bobot.length; j++) {
					x = pattern[i][j];
					w = bobot[j];
					z = z + x * w;
				}
				y_in = bias + z;
				
				y = activationFunc(y_in, threshold);
				t = target[i];
				System.out.println("y =" + y + " t = " + t);
				if(y != t) {
					isFinished = false;
					for(int j = 0; j < bobot.length; j++) {
						double w_new = 0, w_old;
						
						w_old = bobot[j];
						w_new = w_old + learningRate * t * x;
						bobot[j] = w_new;
						
//						System.out.print("w_old : " + w_old);
//						System.out.print("w_new : " + w_new);
//						System.out.println();
					}
					bias = bias + learningRate * t;
				}
			}
			if(isFinished)
				break;
		}	
		
		System.out.println("Recognizing pattern finish");
		
	}

	private static int activationFunc(double y_in, double threshold) {
		int ret = 0;
		
		if(y_in > threshold)
			ret = 1;
		else if(y_in >= -threshold && y_in <= threshold)
			ret = 0;
		else if(y_in < -threshold)
			ret = -1;
		
		return ret;
	}

}
