
public class MainClass {
public static void main(String[] args) {
	ThreadByExtendingThreadClass byExtendingThreadClass = new ThreadByExtendingThreadClass();
	byExtendingThreadClass.start();
	
	for(int i=0; i<10; i++) {
		System.out.println("Main class thread");
	}
}
}
