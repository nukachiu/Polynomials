package Model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Polinom{
	private  ArrayList<Monom> pol;
	
	public String toMyString()
	{
		String finalString = "";
		for(Monom i : pol)
		{
			if(i.getCoeficient() >= 0)
				finalString += "+";
			finalString+=(i.toString() + " ");
		}
		
		return finalString;
	}
	
	public ArrayList<Monom> getPol()
	{
		return this.pol;
	}
	
	public void setPol(ArrayList<Monom> newPol)
	{
		for(Monom m: newPol)
			this.pol.add(m);
		//this.pol = newPol;
	}
	
	public Polinom()
	{
		pol = new ArrayList<Monom>();
	}
	public Polinom(String s)
	{
		pol = new ArrayList<Monom>();
		
		String[] parts = s.split(" ");
		List<String> temp = Arrays.asList(parts);
		
		for(String i : temp)
		{
			Monom a = Monom.StringToMonom(i);
			pol.add(a);
		}
		
		Collections.sort(pol);
	}
}
