package com.carlist;

	/*
	 * CarList class to represents a list of cars to sell.
	 */

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;

	public class CAR1{
		private String filename;
		
		//Constructor of CarList
		public CAR1 (String filname) {
			this.filename = filname;
		}
		
		//method to return the number of new cars in the list of car for sale.
		public int countNewCars() throws IOException {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			int count = 0;
			CAR c = CAR.read(br);
			while (c != null) {
				if (c.getKm() == 0)
					count++;
				c = CAR.read(br);
			}
			br.close();
			
			return count;
		}
		
		//method to return the car object of most expensive car in the car list.
		public CAR mostExpensiveCar() throws IOException {
			
			FileInputStream is = new FileInputStream(filename);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			double max = 0;
			CAR cmax = null;
			CAR c = CAR.read(br);
			while (c != null) {
				if (c.getPrice() > max) {
					max = c.getPrice();
					cmax = c;
				}
				c = CAR.read(br);
			}
			br.close();
			return cmax;
		}
		
		//method to add car c to the end of the list of cars.
		public void addCar(CAR c) throws IOException {
			FileWriter fw = new FileWriter(filename, true); //open file in append mode
			PrintWriter pw = new PrintWriter(fw);
			pw.println(c.getModel());
			pw.println(c.getYear());
			pw.println(c.getKm());
			pw.println(c.getPrice());
			pw.close();
		}
		
		//method to remove the list of cars whose data coincides with that of c
		public void removeCar(CAR c) throws IOException {
			File f = new File(filename);
			FileInputStream is = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(is);
			
			BufferedReader br = new BufferedReader(isr);
			
			File ftemp = new File("newcar.txt");
			FileOutputStream os = new FileOutputStream(ftemp);
			PrintWriter pw = new PrintWriter(os);
			CAR curr = CAR.read(br);
			while (curr != null) {
				System.out.println(curr.equals(c));
				if (!curr.equalTo(c)) {
				
					pw.println(curr.getModel());
					pw.println(curr.getYear());
					pw.println(curr.getKm());
					pw.println(curr.getPrice());
				}
				curr = CAR.read(br);
				
			}
			br.close();
			pw.close();
			ftemp.renameTo(f);
			
		}
	}


