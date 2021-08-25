package factory;

public class FactoryPatternMainClass {
public static void main(String[] args) {
	ProfessionFactory professionFactory = new ProfessionFactory();
	
	Profession teach = professionFactory.getProfession("Teacher");
	teach.print();
	
	Profession doc = professionFactory.getProfession("Doctor");
	doc.print();
	
	Profession eng = professionFactory.getProfession("Engineer");
	eng.print();
}
}
