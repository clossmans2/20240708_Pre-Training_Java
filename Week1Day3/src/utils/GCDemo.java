package utils;

public class GCDemo {

	public static void main(String[] args) {
		GCDemo gcDemo = new GCDemo(); // Created a new instance
		// Java allocates memory for my object
		// Object reference is placed on the stack
		// Object itself is placed on the heap
		gcDemo = null; // De-referenced the object
		// Object reference on the stack now has no ties to the object
		// Object no longer has any reference on the stack
		System.gc(); // Requesting that JVM run Garbage Collector
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Garbage collector called");
		super.finalize();
	}
	
	//GC Broken into generations of objects
	// Young Gen = objects are created here and most die here
	// Old Gen = objects that survive multiple generations move here (long lived)
	// GC Process Phases
	// Minor -> Young GC cleanup, move surviving objects to surviving spaces, promotes objects to old gen
	// Major -> Clean up and compact old generation from the heap
	
	/// JVM Options for optimizing GC
	// -Xms and -Xmx = set initial and max heap size
	// -XX:+UseG1GC = use the G1 garbage collector
	// -XX:+PrintGCDetails = print detailed GC logs

}
