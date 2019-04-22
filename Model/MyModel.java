package Model;

import java.util.ArrayList;
import java.util.Collections;

public class MyModel {
	
	Polinom result;
	
	public void beautifulPol(Polinom p)
	{
		ArrayList<Monom> list1 = p.getPol();
		
		Collections.sort(p.getPol());
		list1 = p.getPol(); // verifica ca nu s sigur aca i bine
		ArrayList<Monom> stergere = new ArrayList<Monom>();
		for(Monom i: list1)
		{
			for(Monom j : list1)
			{
				if(i != j && list1.indexOf(i) > list1.indexOf(j))
				{
					//System.out.println(i.toString() + " " + j.toString());
					if(i.getGrad() == j.getGrad())
					{	i.setCoeficient(i.getCoeficient() + j.getCoeficient());
						stergere.add(j);
					}
				}
			}
		}
		
		for(Monom i : stergere)
		{
			p.getPol().remove(i);
		}
	}
	
	public void derivare(Polinom p)
	{
		result = new Polinom();
		ArrayList<Monom> temp = p.getPol(); 
		for(Monom i : temp)
		{
			Monom newMonom = new Monom(i.getGrad() - 1, i.getCoeficient() * i.getGrad());
			if(i.getGrad() > 0)
				result.getPol().add(newMonom);
		}
	}
	
	public void integrare(Polinom p)
	{
		result = new Polinom();
		ArrayList<Monom> temp = p.getPol();
		for(Monom i : temp)
		{
			Monom newMonom = new Monom(i.getGrad() + 1, i.getCoeficient() / (i.getGrad() + 1));
			result.getPol().add(newMonom);
		}
	}
	
	public void adunare(Polinom p1, Polinom p2)
	{	
		result = new Polinom();
		ArrayList<Monom> list1 = p1.getPol();
		ArrayList<Monom> list2 = p2.getPol();
		for(Monom i :list1)
			result.getPol().add(i);
		
		for(Monom i :list2)
			result.getPol().add(i);
		
		this.beautifulPol(result);
		
	}
	public void scadere(Polinom p1, Polinom p2)
	{
		result = new Polinom();
		for(Monom i : p2.getPol())
			i.setCoeficient(-1 * i.getCoeficient());
		
		this.adunare(p1, p2);
	}
	
	public void inmultire(Polinom p1, Polinom p2)
	{
		result = new Polinom();
		ArrayList<Monom> list1 = p1.getPol();
		ArrayList<Monom> list2 = p2.getPol();
		
		for(Monom i : list1)
			for(Monom j : list2)
			{
				Monom newMonom = new Monom(i.getGrad() + j.getGrad(),i.getCoeficient() * j.getCoeficient());
				result.getPol().add(newMonom);
			}
		
		this.beautifulPol(result);
	}
	
	public void impartire(Polinom p1, Polinom p2)
	{
		result = new Polinom();
		Polinom result_intermediar = new Polinom();
		ArrayList<Monom> list1 = p1.getPol();
		ArrayList<Monom> list2 = p2.getPol();
		ArrayList<Monom> scadere = p1.getPol();
		
		Monom scadere_grad = new Monom(list1.get(0).getGrad(),list1.get(0).getCoeficient());
		
		for(int i = 0; i <= list2.get(0).getGrad(); i ++)
		{
			Monom aux = new Monom(scadere_grad.getGrad() - list2.get(0).getGrad(),scadere_grad.getCoeficient() / list2.get(0).getCoeficient());
			//System.out.println("Monomul este" + aux.toString());
			result_intermediar.getPol().add(aux);
			//System.out.println("Rezultat intermediar: " + result_intermediar.toMyString());
			Polinom monom_aux = new Polinom();
			monom_aux.setPol(result_intermediar.getPol());
			//System.out.println("Polinomul Monom aux este" + monom_aux.toMyString());
			this.inmultire(monom_aux,p2);
			//System.out.println("Inmultirea se face intre" + monom_aux.toMyString() + " si " + p2.toMyString());
			Polinom rez_imp = this.result;
			//System.out.println("Polinomul rez_imp este" + rez_imp.toMyString());
			//System.out.print(p1.toMyString() + "- (" + result.toMyString() + ")=");
			this.scadere(p1, rez_imp);
			scadere = this.result.getPol();
			//System.out.println(result.toMyString());
			scadere_grad = this.getMaxGrad(scadere);
			//System.out.print("Polinomul scadere este:");
			//for(Monom temp : scadere)
			//	System.out.println(scadere.toString());
			//System.out.println("Gradul maxim al polinomului scadere este"+scadere_grad);
			//System.out.println();
		}
		result = result_intermediar;
	}
	
	public Monom getMaxGrad(ArrayList<Monom> P)
	{
		for(Monom m: P)
			if(m.getCoeficient() != 0)
				return m;
		return P.get(0);
	}
	
	public Polinom getResult()
	{
		return result;
	}
	
	// + restul operatiilor
	
}
