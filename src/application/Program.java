package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String file = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			
			Map<String, Integer> votes = new HashMap<>();
			
			String line = br.readLine();
			while (line != null) {
				String[] vet = line.split(",");
				
				String name = vet[0];
				Integer vt = Integer.parseInt(vet[1]);
				
				if (votes.containsKey(name)) {
					int votesContain = votes.get(name);
					
					votes.put(name, votesContain + vt);
				} else {
					votes.put(name, vt);
				}
				line = br.readLine();
			}
			
			for (String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
				}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}

}
