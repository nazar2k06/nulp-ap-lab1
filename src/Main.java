import java.util.Scanner;

/**
 * Class that representing a Luke number.
 * @author Nazar Vereshchynskyi
 */
class LukeNumber {
	/**
	 * Default constructor.
	 */
	public LukeNumber() {
		index = 0;
		value = 0;
	}

	/**
	 * Constructor that initialize the index of the Luke number.
	 *
	 * @param index index of the Luke number.
	 */
	public LukeNumber(int index) {
		setIndex(index);
	}

	/**
	 * Sets index of the Luke number.
	 *
	 * @param index index of the Luke number.
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Sets Luke number.
	 *
	 * @param value Luke number.
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Gets the index of the Luke number.
	 *
	 * @return index of the Luke number.
	 */
	public int getIndex() {
		return this.index;
	}

	/**
	 * Gets the Luke number.
	 *
	 * @return Luke number.
	 */
	public int getValue() {
		return this.value;
	}

	private int index;
	private int value;

}

/**
 * Main class of the program.
 */
public class Main {
	/**
	 * Entry point of the program.
	 *
	 * @param args command-line arguments.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LukeNumber[] numbers;
		byte numbers_count = 0;

		while (true) {
			System.out.print("Enter Luke numbers count:");

			if (in.hasNextByte()) {
				numbers_count = in.nextByte();
				break;
			}
			else {
				in.nextLine();
			}
		}

		numbers = new LukeNumber[numbers_count];
		System.out.printf("%d Luke numbers:\n", numbers_count);

		for (byte i = 0;i < numbers.length;i++) {
			numbers[i] = new LukeNumber(i + 1);

			if (i == 0) {
				numbers[i].setValue(2);
			}
			else if (i == 1) {
				numbers[i].setValue(1);
			}
			else {
				numbers[i].setValue(numbers[i - 2].getValue() + numbers[i - 1].getValue());
			}

			System.out.printf("Number No%d: %d - ", numbers[i].getIndex(), numbers[i].getValue());
			System.out.printf("%s\n", isNumberCube(numbers[i].getValue()) ? "is a cube" : "is not a cube");
		}
	}

	/**
	 * Checks if the number is a cube.
	 *
	 * @param number number to check.
	 * @return true if the number is a cube.
	 * @author Nazar Vereshchynskyi
	 */
	public static boolean isNumberCube(int number) {
		double cube_root = Math.cbrt(number);
		int cube_root_int = (int) cube_root;

		return (Math.pow(cube_root_int, 3) == (double) number);
	}
}
