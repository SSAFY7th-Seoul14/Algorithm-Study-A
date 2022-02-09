package jhkim.p220209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12927 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String lights = br.readLine();
		char[] light = new char[lights.length()];
		int j = 0, count = 0;
		
		for(int i = 0; i < lights.length(); i++) {
			light[i] = lights.charAt(i);
		}
		
		if(light[0] == 'N') {
			for(int i = 1; i < lights.length(); i++) {
				if(light[i] == 'Y') {
					j = i;
					count++;
					while (j < lights.length()) {
						if(light[j] == 'Y') {
							light[j] = 'N';
						} else {
							light[j] = 'Y';
						}
						j += i + 1;
					}
				}
			}
		} else if(light[0] == 'Y') {
			count++;
			for(int i = 1; i < lights.length(); i++) {
				if(light[i] == 'N') {
					j = i;
					count++;
					while (j < lights.length()) {
						if(light[j] == 'N') {
							light[j] = 'Y';
						} else {
							light[j] = 'N';
						}
						j += i + 1;
					}
				}
			}
		}
		System.out.println(count);
	}
}
