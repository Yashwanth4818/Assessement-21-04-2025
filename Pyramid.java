package assessment;

public class Pyramid {

	public static void main(String[] args) {
		int r = 5;

		for (int i = 1; i <= r; i++) {

			for (int j = i; j < r; j++) {
				System.out.print("  ");
			}
			for (int k = 1; k <= (2 * i - 1); k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
