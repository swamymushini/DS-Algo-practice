public class NumberTriangleWithoutExecutor {
	public static void main(String[] args) throws InterruptedException {
		int N = 5;
		String[] arr = new String[N];

		for (int i = 1; i <= N; i++) {
			final int row = i;
			Thread t1 = new Thread(() -> {
				StringBuilder sb = new StringBuilder();
				for (int j = 1; j <= row; j++) {
					sb.append(j).append(" ");
				}
				arr[row - 1] = sb.toString().trim();
			});
			t1.start();
		}

		for (String line : arr) {
			System.out.println(line);
		}
	}
}
