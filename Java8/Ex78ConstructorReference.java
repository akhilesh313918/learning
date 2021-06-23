class Sample{
Sample(){
System.out.println("Sample constructor execution and Object creation");
}
}

interface Interf{
	public Sample get();
}

public class Ex78ConstructorReference{
public static void main(String [] args){
	Interf i = Sample::new;
	Sample s = i.get();
}
}