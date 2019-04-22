package Model;

public class Monom  implements Comparable{
	private int grad;
	private float coeficient;
	
	public int getGrad() {
		return grad;
	}
	public void setGrad(int grad) {
		this.grad = grad;
	}
	public float getCoeficient() {
		return coeficient;
	}
	public void setCoeficient(float coeficient) {
		this.coeficient = coeficient;
	}
	public Monom(int grad, float coeficient) {
		super();
		this.grad = grad;
		this.coeficient = coeficient;
	}
	
	public String toString()	//mai verifica
	{
		if(this.coeficient == 1 && this.grad == 1)
			return ("X");
		if(this.coeficient == 1)
			return ("X^" + this.grad);
		if(this.grad == 1)
			return (this.coeficient + "X");
		if(this.grad == 0)
			return (Float.toString(this.coeficient));
		return (this.coeficient + "X^" + this.grad);
	}
	

	static public Monom StringToMonom(String s)
	{
		String[] parts = s.split("x\\^");
		if(parts[0].equals("+"))
			return (new Monom(Integer.parseInt(parts[1]),1));
		if(parts[0].equals("-"))
			return (new Monom(Integer.parseInt(parts[1]),-1));
		return (new Monom(Integer.parseInt(parts[1]),Integer.parseInt(parts[0])));
	}
	//@Override
	public int compareTo(Object m) {
		if(this.getGrad() > ((Monom) m).getGrad())
			return -1;
		else if(this.getGrad() < ((Monom) m).getGrad())
			return 1;
		return 0;
	}

}