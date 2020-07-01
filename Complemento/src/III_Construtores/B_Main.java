package III_Construtores;

class Animal {
	private String name;
	
	public Animal (String name) 
	{	this.name = name;
	}
	
	public void saySomething ()
	{	System.out.println("I am"+name);
	}
}

class Dog extends Animal {
	public Dog (String name) 
	{	super(name);
	}
	
	public void saySomething ()
	{	System.out.println("I can bark");
	}
}

public class B_Main
{	public static void main (String[] args)
	{
		Dog dog = new Dog ("Chiwawa");
		dog.saySomething();
	}
}