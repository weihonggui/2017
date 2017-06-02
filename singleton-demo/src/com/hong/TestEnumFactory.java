package com.hong;

public class TestEnumFactory extends Thread{
	//据说违反了“职责单一原则”，
	@Override
	public void run(){
		//System.out.println(EnumFactory.singletonFactory.getInstance().hashCode());
		System.out.println(EnumFactoryChange.getInstance().hashCode());
	}
	public static void main(String[] args) {
		
		TestEnumFactory[] mts = new TestEnumFactory[10];
		for(int i=0;i<mts.length;i++){
			mts[i] = new TestEnumFactory();
		}
		for(int j = 0;j<mts.length;j++){
			mts[j].start();
		}
	}

}
