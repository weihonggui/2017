package com.hong;

public class Singleton {
	
	//饿汉模式
	/*private static Singleton instance = new Singleton();
	private Singleton(){};
	public static Singleton getInstance(){
		return instance;
	}*/
	
	//懒汉模式
	/*private static Singleton instance = null;
	private  Singleton(){};
	public static Singleton getInstance(){
		if(instance == null){
			return new Singleton();
		}
		return instance;
	}*/
	//双重校验锁：双重校验锁模式其实就是懒汉模式的升级，让懒汉模式变得线程安全。(推荐使用)
	//注意：双重校验锁存在内存问题，可能让双重校验锁失效。
	/*private static Singleton instance = null;
	private Singleton(){};
	public static Singleton getInstance(){
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					return new Singleton();
				}
			}
		}
		return instance;
	}*/
	
	//静态内部类模式：静态内部类兼具了懒汉模式和恶汉模式的有点：线程安全，延迟加载。
	
	private static class SingletonFactory{
		private static Singleton INSTANCE = new Singleton();
	}
	private Singleton(){};
	public static Singleton getInstance(){
		return SingletonFactory.INSTANCE;
	}
	
	//枚举类模式：应该是最完美的单利模式，不仅线程安全，而且还能防止反序列和反射问题。
	enum EnumFactory{
		singletonFactory;
		private Singleton instance;
		private EnumFactory(){
			instance = new Singleton();
		}
		public Singleton getInstance(){
			return instance;
		}
	}

}

