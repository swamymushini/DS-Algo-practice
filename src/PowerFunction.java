public class PowerFunction {

	public static void main(String[] args) {
		System.out.println(new PowerFunction().pow(71045970, 41535484, 64735492));
	}

	public int pow(int A, int B, int C) {

		if (A == 0) {
			return 0;
		}

		return power(A, B, C);
	}

	int power(int A, int B, int C) {

		if (B == 0)
			return 1;

		if (A < 0 & B == 1) {
			return C + A;
		}

		long val = power(A, B / 2, C);
		
		long l = val%C;
		
		l = val*val;

		int ans = (int) l % C;

		if (B % 2 == 0)
			return ans;
		else
			return (int) ((long) A * (ans)) % C;
	}

}
