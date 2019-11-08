package com.board.bdi.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Human
{
	private int age;
	private int height;
	
	public Human(int age, int height) {
		super();
		this.age = age;
		this.height = height;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Human [age=" + age + ", height=" + height + "]";
	}


}

class Compare<T> implements Comparator<T>		//<T> = type 이 들어갈 것을 미리 정해놓음(type 이 정해진건 아니다)
{
	@Override
	public int compare(T o1, T o2)
	{
		Human h1 = (Human)o1;
		Human h2 = (Human)o2;
		if(h1.getAge()<h2.getAge())
		{
			return 1;							//return 받는 결과에 따라 오름차순,내림차순이 결정
		}
		if(h1.getAge()>h2.getAge())
		{
			return -1;							//return type 이 int , int 에 -1 은 나올 수 없다
		}
		return 0;
	}	
}

public class Test 
{
	public static void main(String[] args)
	{
		List<Human> hList = new ArrayList<>();
		hList.add(new Human(18,180));
		hList.add(new Human(20,170));
		hList.add(new Human(33,165));
		hList.add(new Human(13,145));
		hList.add(new Human(40,187));
		
//		for(int i=0;i<hList.size();i++)
//		{
//			for(int j=i+1;j<hList.size();j++)
//			{
//				if(hList.get(i).getHeight() > hList.get(j).getHeight())
//				{
//					Human temp = hList.get(i);
//					hList.set(i, hList.get(j));
//					hList.set(j, temp);
//				}
//			}
//		}
//		
//		for(Human hl: hList)
//		{
//			System.out.println(hl);
//		}
		Collections.sort(hList,new Compare<Human>());
		
		Collections.sort(hList,new Comparator<Human>() {

			@Override
			public int compare(Human o1, Human o2) {
				Human h1 = (Human)o1;
				Human h2 = (Human)o2;
				if(h1.getAge()<h2.getAge())
				{
					return 1;							//return 받는 결과에 따라 오름차순,내림차순이 결정
				}
				if(h1.getAge()>h2.getAge())
				{
					return -1;							//return type 이 int , int 에 -1 은 나올 수 없다
				}
				return 0;
			}
			
		});
		
		System.out.println(hList);
	}
}
