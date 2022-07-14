public class PerfectNumber {

	public static void main(String[] args) {

		int num = 6;

		int i = 2;
		int sum = 2;

		while (i <= Math.sqrt(num)) {

			if (num % i == 0) {
				
				sum = sum+i;
				
				if(sum==num) {
					System.out.println("YES");
					return;
				}else if(sum>num){
					System.out.println("NO");
					return;
				}
			}

			i++;

		}
	}

}
