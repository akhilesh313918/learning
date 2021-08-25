
public class MainClassForRunnable {
public static void main(String[] args) {
	
	ThreadByImplementsRunnable byImplementsRunnable = new ThreadByImplementsRunnable();
	Thread thread = new Thread(byImplementsRunnable);
	thread.start();
	
	for(int i=0; i<10; i++) {
		System.out.println("Main class thread");
	}
}
}
