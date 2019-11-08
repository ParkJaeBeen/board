package com.board.bdi.test;

import java.util.ArrayList;
import java.util.List;

class TestClass extends AbsClass
{
	@Override
	public void test() 
	{
		
	}
}

public abstract class AbsClass 
{
	public abstract void test();
	
	public static void main(String[] args)
	{
		AbsClass ac = new TestClass();
		List<AbsClass> acList = new ArrayList<>();
		acList.add(new TestClass());
	}
}
