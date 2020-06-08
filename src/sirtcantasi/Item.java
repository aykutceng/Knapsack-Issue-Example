package sirtcantasi;
import java.util.*;
import sirtcantasi.Knapsack;

public class Item implements Comparable<Item> {

	public double IValue;
	public double IWeight;
	public String IName;
	
	public Item(String name,double value, double weight) {
		setWeight(weight);
		setValue(value);
		setName(name);
	}
	
	public void setName(String name) {
		this.IName = name;
	}
	
	public String getName() {
		return IName;
	}

	
	public void setWeight(double weight) {
		this.IWeight = weight;
	}
	
	public void setValue(double value) {
		this.IValue = value;
	}
	
	public double getWeight() {
		return IWeight;
	}

	public double getValue() {
		return IValue;
	}	
	
	@Override
	public int compareTo(Item o) {
		if(this.IValue != o.IValue) {
			double cmpV = this.IValue - o.IValue;
			if(cmpV>0) {return 1;}
			else if(cmpV<0) {return -1;}
			else{return 0;}
			
		}
		
		else {
			double cmpW = this.IWeight - o.IWeight;
			if(cmpW>0){return 1;}
			else if(cmpW<0) {return -1;}
			else{return 0;}
		}
	}
	
	public static ArrayList<Item> sort(ArrayList<Item> itemL){
		/*
		 * double tmpV; double tmpW; for(int i = 0;i<itemL.size();i++) { for(int
		 * j=itemL.size()-1;j>i;j--) {
		 * if(itemL.get(j-1).getValue()>itemL.get(j).getValue()) {
		 * 
		 * tmpV = itemL.get(j-1).getValue();
		 * itemL.get(j-1).setValue(itemL.get(j).getValue());
		 * itemL.get(j).setValue(tmpV); } else if(itemL.get(j-1).getValue()==
		 * itemL.get(j).getValue()) {
		 * if(itemL.get(j-1).getWeight()>itemL.get(j).getWeight()) {
		 * 
		 * } } } }
		 */
		Collections.sort(itemL);
		return itemL;
	}


}
