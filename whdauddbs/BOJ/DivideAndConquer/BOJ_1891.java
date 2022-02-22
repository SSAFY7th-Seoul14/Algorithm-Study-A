import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
	long y, x;
	public Point(long y, long x) {
		this.y = y;
		this.x = x;
	}
	@Override
	public String toString() {
		return y + ", " + x;
	}
}

public class BOJ_1891 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int[] n = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
		Point here = calculatePoint(d, n);
//		System.out.println(here);
		
		st = new StringTokenizer(br.readLine());
		long x = Long.parseLong(st.nextToken());
		long y = Long.parseLong(st.nextToken());
		Point next = new Point(here.y - y, here.x + x);
		
//		System.out.println(next);
		if(next.y >= 0 && next.y < (long)1<<d && next.x >= 0 && next.x < (long)1<<d) {
			String str = Arrays.toString(calculateNum(d, next));
			System.out.println(str.substring(1, str.length()-1).replace(", ", ""));
		} else {
			System.out.println(-1);
		}
		
		br.close();
	}
	
	static Point calculatePoint(int d, int[] n) {
		Point start = new Point(0, 0);
		Point end = new Point((long)1 << d, (long)1<<d);
		for(int quarter : n) {
			if(quarter == 1) {
				end.y = (start.y+end.y)/2;
				start.x = (start.x+end.x)/2;
			} else if(quarter == 2) {
				end.y = (start.y+end.y)/2;
				end.x = (start.x+end.x)/2;
			} else if(quarter == 3) {
				start.y = (start.y+end.y)/2;
				end.x = (start.x+end.x)/2;
			} else if(quarter == 4) {
				start.y = (start.y+end.y)/2;
				start.x = (start.x+end.x)/2;
			}
		}
		return start;
	}
	
	static int[] calculateNum(int d, Point next) {
		Point start = new Point(0, 0);
		Point end = new Point((long)1<<d, (long)1<<d);
		int[] result = new int[d];
		int cnt = 0;
		while(cnt != d) {
			if(next.y < (start.y+end.y)/2 && next.x < (start.x+end.x)/2) {
				result[cnt] = 2;
				end.y = (start.y+end.y)/2;
				end.x = (start.x+end.x)/2;
			} else if(next.y < (start.y+end.y)/2 && next.x >= (start.x+end.x)/2) {
				result[cnt] = 1;
				end.y = (start.y+end.y)/2;
				start.x = (start.x+end.x)/2;
			} else if(next.y >= (start.y+end.y)/2 && next.x < (start.x+end.x)/2) {
				result[cnt] = 3;
				start.y = (start.y+end.y)/2;
				end.x = (start.x+end.x)/2;
			} else if(next.y >= (start.y+end.y)/2 && next.x >= (start.x+end.x)/2) {
				result[cnt] = 4;
				start.y = (start.y+end.y)/2;
				start.x = (start.x+end.x)/2;
			}
			cnt++;
		}
		return result;
	}
}