package poly;

public class Pegasus extends Horse implements Flyer, Mythical {
	public static void main(String[] args) {
		Pegasus carl = new Pegasus();
		System.out.println(carl.identifyMyself());
	}
}

