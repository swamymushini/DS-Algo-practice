import java.util.*;

public class Result {

	static class priceStatus {
		int price;
		int originalPrice;
		int appliedCoupons;

		public priceStatus(int price, int originalPrice, int appliedCoupons) {
			this.price = price;
			this.originalPrice = originalPrice;
			this.appliedCoupons = appliedCoupons;
		}

		@Override
		public String toString() {
			return "PriceStatus{price=" + price + ", originalPrice=" + originalPrice + ", appliedCoupons="
					+ appliedCoupons + "}";
		}
	}

	public static int findMinimumPrice(List<Integer> prices, int m) {

		PriorityQueue<priceStatus> maxHeap = new PriorityQueue<>(new Comparator<priceStatus>() {
			@Override
			public int compare(priceStatus p1, priceStatus p2) {
				return Integer.compare(p2.price, p1.price); // max heap (p2 first if price is larger)
			}
		});

		for (Integer price : prices) {
			maxHeap.add(new priceStatus(price, price, 0));
		}

		while (m > 0) {
			priceStatus price = maxHeap.poll();

			int nextPrice = maxHeap.isEmpty() ? 0 : maxHeap.peek().price;
			int curr = 0;

			while (price.price >= nextPrice && (m - curr) > 0) {
				price.appliedCoupons = price.appliedCoupons + 1;
				price.price = (int) Math.floor(price.originalPrice / Math.pow(2, price.appliedCoupons));
				curr++;
			}

			maxHeap.add(price);
			m = m - curr;
		}

		int totalCost = 0;
		for (priceStatus p : maxHeap) {
			totalCost += p.price;
		}

		return totalCost;

	}

	public static void main(String[] args) {
		List<Integer> price = new ArrayList<>(
				Arrays.asList(655, 800, 576, 884, 455, 418, 414, 818, 167, 495, 218, 992, 29, 457, 162, 834, 769));
		int coupons = 87;
		int result = findMinimumPrice(price, coupons);
		System.out.println(result);

	}
}
