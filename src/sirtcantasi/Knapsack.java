package sirtcantasi;
import java.util.*;
import sirtcantasi.Item;

public class Knapsack {


	public static double KCapacity; // Tam kapasite
	public static double RCapacity = 0.0; // Kalan kapasite
	
	public static ArrayList<Item> objs=new ArrayList<Item>();
	public static ArrayList<Item> recArr = new ArrayList<Item>();
	public static ArrayList<Item> MIS = new ArrayList<Item>(); //kullanýlmadý
	
	public Knapsack(double capacity) {
		setCapacity(capacity);
	}
	

	
	public void setCapacity(double capacity) {
		Knapsack.KCapacity = capacity;
	}
	
	public static double getCapacity() {
		return KCapacity;
	}
	
	
	public static ArrayList<Item> getItems(){
		setItems(objs);
		return recArr;
		
	}
	
	public static void setItems(ArrayList<Item> I) {
		recArr.clear();
		if(0 < objs.size()) {	
			for(int i=0;i<objs.size();i++) {
				recArr.add(objs.get(i));
		}}
	}
	
	public static boolean pushItem(Item item) {
		RCapacity = 0;
		for(int i = 0;i<objs.size();i++) {
			RCapacity += objs.get(i).getWeight();
		}
		
		if((getCapacity() - (RCapacity+item.getWeight()))<0) {
			return false;
		}
		else {
			objs.add(item);
			return true;
		}
		
	}
	
	public static double getMaximumValue(ArrayList<Item> newItems) {
		int i=newItems.size();
		int c=0;
		double maxV=0;
		while(0<i) {
			int j=0;
			while(Item.sort(newItems).get(j).getValue()!=Item.sort(newItems).get(i-1).getValue()) {
				j += 1;
			}
			while((getCapacity()-RCapacity)>Item.sort(newItems).get(j).getWeight()) {
				pushItem(Item.sort(newItems).get(j));
				RCapacity += Item.sort(newItems).get(j).getWeight();
			}
			
			i = i-1;
		}
		
		while(c<objs.size()) {
			maxV += objs.get(c).getValue();
			c = c+1;
		}
		
		return maxV;
	}
	
	public static ArrayList<Item> getMaximumItemSet(ArrayList<Item> newItems) {
		int i=newItems.size();
		while(0<i) {
			int j=0;
			while(Item.sort(newItems).get(j).getValue()!=Item.sort(newItems).get(i-1).getValue()) {
				j += 1;
			}
			while((getCapacity()-RCapacity)>Item.sort(newItems).get(j).getWeight()) {
				pushItem(Item.sort(newItems).get(j));
				RCapacity += Item.sort(newItems).get(j).getWeight();
			}
			
			i = i-1;
		}
		
		return objs;
	}

	public static void main(String[] args) {
		Knapsack ks = new Knapsack(5.0);
		Item kitap = new Item("Kitap",10.5,0.8);
		Item defter = new Item("Defter",7.5,0.6);
		Item kalem = new Item("Kalem",15.0,0.2);
		Item silgi = new Item("Silgi",5.0,0.5);
		Item cetvel = new Item("Cetvel",3.5,0.3);
		

		
		pushItem(kitap);
		pushItem(defter);
		pushItem(kalem);
		pushItem(silgi);
		pushItem(cetvel);
		pushItem(kitap);
		pushItem(kalem);
		System.out.println(objs.get(2).getValue()+" "+objs.get(2).getWeight()+" "+objs.get(2).getName());
		
		System.out.println(getItems().get(2));
		
		System.out.println(objs.get(1).getName());
		
		
		System.out.println(getMaximumValue(objs));
		//System.out.println(objs);
		int xx = 0;
		while(xx<getMaximumItemSet(objs).size()) {
			double v=0;
			double w=0;
			int count=0;
			int j=xx;
			//System.out.println(Item.sort(getMaximumItemSet(objs)).get(xx).getName());
			while(Item.sort(getMaximumItemSet(objs)).get(xx).getName()==Item.sort(getMaximumItemSet(objs)).get(j).getName()) {
				v += Item.sort(getMaximumItemSet(objs)).get(j).getValue();
				w += Item.sort(getMaximumItemSet(objs)).get(j).getWeight();
				count += 1;
				j += 1;
				if(j>=getMaximumItemSet(objs).size()) {break;}
			}
			
			System.out.println("Number of "+Item.sort(getMaximumItemSet(objs)).get(xx).getName()+" is "+count+", its total value is "+v+" and its total weight is "+w);
			xx=j;
		}	
	}

}
