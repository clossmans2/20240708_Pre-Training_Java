package poly;

public class Dragon implements EggLayer, FireBreather {
	public static void main(String[] args) {
		Dragon pete = new Dragon();
		System.out.println(pete.identifyMyself());
	}
}

interface Animalian {
	static final String kingdom = "Animal";
	
	default public String identifyMyself() {
		return "I am an animal.";
	}
	
//	String identifyThyself();
}

interface EggLayer extends Animalian {
	default public String identifyMyself() {
		return "I am able to lay eggs.";
	}
}

interface FireBreather extends Animalian {
//	default public String identifyMyself() {
//		return "I can breathe fire.";
//	}
}
