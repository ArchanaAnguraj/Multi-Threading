package ONLINEVDOS;
import java.util.Scanner;

//Program-->It is a collection of instruction which are present in hardDisk drive.
//Process-->It is a collection of instruction which are in present RAM.
//Thread-->its is independent instructions which will executes independently.
//Multi-Thredaing-->creating multiple threads called multi-thread.
//Where therad?--its present in process/task..



public class MultiThreading {

	public static void main(String[] args) {
	  System.out.println("adding started");
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the number1:");
	  int a=sc.nextInt();                               //normal program 
	  System.out.println("Enter the number1:");
	  int b=sc.nextInt();
	  int c=a+b;
	  System.out.println(c);
	  System.out.println("adding completed");
	  
	  
	  System.out.println("character start");
	  for(int i=65;i<=72;i++)
	  {
		  System.out.println((char)i);
		  try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	  System.out.println("character complete");
	  
	  
	  System.out.println("number start");
	  for(int i=0;i<=10;i++)
	  {
		  System.out.println(i);
		  try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	  System.out.println("number complete");
	  
	  
	 }
}

//how to we acheive the multi-threading 2 ways are there..  1.Extends Thread  2.implements Runnable
//use 1.Extends Thread

class Demo1 extends Thread
{
	@Override
	public void run()
	{
		 System.out.println("adding started");
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the number1:");
		  int a=sc.nextInt();
		  System.out.println("Enter the number2:");
		  int b=sc.nextInt();
		  int c=a+b;
		  System.out.println(c);
		  System.out.println("adding completed");
	}
}
class Demo2 extends Thread
{
	@Override
	public void run()
	{
		 System.out.println("character start");
		  for(int i=65;i<=72;i++)
		  {
			  System.out.println((char)i);
			  try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  }
		  System.out.println("character complete");
		  
	}
}

class Demo3 extends Thread
{
	@Override
	public void run()
	{
		 System.out.println("number start");
		  for(int i=0;i<=10;i++)
		  {
			  System.out.println(i);
			  try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		  System.out.println("number complete");
		  
	}
}
public class MultiThreading {

	public static void main(String[] args) { //-->main is the default thread
		Demo1 d1=new Demo1();
		Demo2 d2=new Demo2();
		Demo3 d3=new Demo3();
		
		d1.start();// we can access run indirectly by using start().,we cant access directly why?stack created in the main method instead of new stack 
		d2.start();
		d3.start();
	}
}
//----------------------------------------------//

//2.implements Runnable

class Demo1 implements Runnable
{
	@Override
	public void run()
	{
		 System.out.println("adding started");
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the number1:");
		  int a=sc.nextInt();
		  System.out.println("Enter the number2:");
		  int b=sc.nextInt();
		  int c=a+b;
		  System.out.println(c);
		  System.out.println("adding completed");
	}
}
class Demo2 implements Runnable
{
	@Override
	public void run()
	{
		 System.out.println("character start");
		  for(int i=65;i<=72;i++)
		  {
			  System.out.println((char)i);
			  try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  }
		  System.out.println("character complete");
		  
	}
}

class Demo3 implements Runnable
{
	@Override
	public void run()
	{
		 System.out.println("number start");
		  for(int i=0;i<=10;i++)
		  {
			  System.out.println(i);
			  try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		  System.out.println("number complete");
		  
	}
}
public class MultiThreading {

	public static void main(String[] args) { 
		Demo1 d1=new Demo1();
		Demo2 d2=new Demo2();
		Demo3 d3=new Demo3();
		
		Thread t1=new Thread(d1);
		Thread t2=new Thread(d2);
		Thread t3=new Thread(d3);
		
		t1.start();
		t2.start();
		t3.start();		
	
	}
}
//------------------------------------------------------------------//
//setName,setPrioritY()methods
class demo1 extends Thread
{
  @Override
public void run() {
	   Thread t=Thread.currentThread();
		System.out.println(t); //we can  get all the informations of the currentthread
       System.out.println(t.getName());
       System.out.println(t.getPriority());
       System.out.println(t.getThreadGroup());
  }
}
public class MultiThreading {

	public static void main(String[] args) { 
		demo1 d=new demo1();
		d.setName("baba"); //we can change the thread name
		d.setPriority(3);//we can change the priority 
		d.start();
		
		
	}
	}


//---------------------------------------------------------------//

//join method()
class demo1 extends Thread
{
	@Override
	public void run() {
		Thread t=Thread.currentThread();
		System.out.println(t.getName()+" "+"started to executed");
		System.out.println(t.getName()+" "+"is executing");	
		System.out.println(t.getName()+" "+"is executed");
	}
}
public class MultiThreading {
	public static void main(String[] args) {
		Thread t=Thread.currentThread();
		System.out.println(t.getName()+" "+"started to executed");
		System.out.println(t.getName()+" "+"is executing");
		System.out.println(t.getName()+" "+"is executing");
		System.out.println(t.getName()+" "+"is executing");
		demo1 d=new demo1();
		d.start();
		try {
			d.join();                    //join method is used to hold the execution,..until previous one was completed...
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(d.isAlive()); //its give the method is alive or not..
		System.out.println(t.getName()+" "+"is executing");
		System.out.println(t.getName()+" "+"is executed");
	}
}
//---------------------------------------------------------------------------//
//we can implement multi-threading by using "single run() method"

class SingleRun extends Thread
{
	@Override
	public void run() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		
		if(name.equals("Thread-0"))
		{
			add();
		}
		else if(name.equals("Thread-1"))
		{
			PrintChar();
		}
		else
		{
			PrintNumber();
		}
	}
	public void add()
	{
		System.out.println("adding started");
		  Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the number1:");
		  int a=sc.nextInt();                              
		  System.out.println("Enter the number1:");
		  int b=sc.nextInt();
		  int c=a+b;
		  System.out.println(c);
		  System.out.println("adding completed");	
	}
	public void PrintChar()
	{
		System.out.println("character start");
		  for(int i=65;i<=72;i++)
		  {
			  System.out.println((char)i);
			  try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  }
		  System.out.println("character complete");
	}
	public void PrintNumber()
	{
		 
		  System.out.println("number start");
		  for(int i=0;i<=10;i++)
		  {
			  System.out.println(i);
			  try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		  System.out.println("number end");
	}
}
public class MultiThreading {
	public static void main(String[] args) {
		SingleRun s1=new SingleRun();
		SingleRun s2=new SingleRun();
		SingleRun s3=new SingleRun();
		
		s1.start();
		s2.start();
		s3.start();
		
		
		
	}
}
//------------------------------------------------------------------------------------------//

//Daemon threads --//"helper threads" or "Secondery threads" which helps to primary thread to acheive something..
class Captain extends Thread{                                          //captain is the primary thread
	@Override
	public void run() {
		System.out.println("Captain enter the ground");
		try {
			BattingCoach b1=new BattingCoach();              //these are secondery key..-->it will follows the primary thread..
			b1.setName("BAC");                         //ex:we give infinte for loop but execution is completed why? if primary execution completed
			                                                     //automatically secondery execution completed whatever...it is.
			BowlingCoach  b2=new BowlingCoach ();
			b2.setName("BOC");
			b1.start();
			b2.start();
			
			b1.setDaemon(true);
			b2.setDaemon(true);
			
			
			Thread.sleep(3000);
			System.out.println("Captain will do warm-up");
			Thread.sleep(3000);
			System.out.println("Captain will do catching");
			Thread.sleep(3000);
			System.out.println("Captain will do catching");
			Thread.sleep(3000);
			System.out.println("Captain will do bating");
			Thread.sleep(3000);
			System.out.println("Captain will do bowling");
			Thread.sleep(3000);
			System.out.println("Captain will go to hotel");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
class BattingCoach extends Thread
{
	@Override
	public void run() {
		for(;;)
		{
			System.out.println("BattingCoach inside the ground");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class BowlingCoach extends Thread
{
	@Override
	public void run() {
		for(;;)
		{
			System.out.println("BowlingCoach  inside the ground");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class MultiThreading {
	public static void main(String[] args) {
		Captain c=new Captain();
		c.setName("captain");
		BattingCoach b1=new BattingCoach();
		b1.setName("BAC");
		BowlingCoach  b2=new BowlingCoach ();
		b2.setName("BOC");
		
		c.start();
		b1.start();                  //"garbage collector is default deaman thread in java"
		b2.start();
		
		
	}
}
//--------------------------------------------------------------------------------------------------------------//
//LIFE CYCLE OF THREAD..OR "STATE OF THERAD"--> NEW state, RUN state, BLOCK state , DEAD state..

class Warrier extends Thread
{
	String res1="BRAHMASTRA";
	String res2="PASUPATASTRA";
	String res3="SARPASTRA";
	@Override
	public void run() {
		String t=Thread.currentThread().getName();
		if(t.equals("Arjuna"))
			Arjuna();
		else
			 Karna();
	}
	public void Arjuna()
	{
		try
		{
			Thread.sleep(3000);
			synchronized(res1)
			{
				System.out.println("Arujuna get "+res1);
				Thread.sleep(3000);
				synchronized(res2)
				{
					System.out.println("Arujuna get "+res2);
					Thread.sleep(3000);
					synchronized(res2)
					{
						System.out.println("Arujuna get "+res3);
				   }
				
			   }
		   }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
	public void Karna()
	{
		try
		{
			Thread.sleep(3000);
			synchronized(res1)
			{
				System.out.println("Karna get "+res1);
				Thread.sleep(3000);
				synchronized(res2)
				{
					System.out.println("Karna get "+res2);
					Thread.sleep(3000);
					synchronized(res2)
					{
						System.out.println("Karna get "+res3);
				   }
				
			   }
		   }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

public class MultiThreading {
	public static void main(String[] args) {
		Warrier w1=new Warrier();
		Warrier w2=new Warrier();
		
		w1.setName("Arjuna");
		w2.setName("Karna");
		
		w1.start();
		w2.start();
		
		
		
}
}
//---------------------------------------------------------------------------------------------------------------//

//producer and consumer problem...." whatever producer  is producing consumer does not produce this is called producer and consumer problem"
                                      //to overcome this we use therad communication by using 2 methods,,.notify(),wait()..

class Queue
{
	private int data;
	 boolean dataPresent=false;
	public synchronized void setData(int data)
	{
		if(dataPresent==false) 
		{
		this.data=data;
		System.out.println("producer produced"+data);
		dataPresent=true;
		notify();
		}
		else{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}}
	public synchronized void  getData(){
		if(dataPresent==true) 
		{
		System.out.println("consumer consumed"+data);
		dataPresent=false;
		notify();                                        //we can use notify()and wait()method by giving the syscronized..!
		}
		else
		{
		 try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();}	
		}}}
class Producer extends Thread
{
     Queue q;

	public Producer(Queue q) {
		this.q=q;
	}

	@Override
	public void run() {
		int i=1;
	   for(;;)
	   {
		   q.setData(i++);
	   }
	}
	
}
class Consumer extends Thread
{
    Queue q;

	public Consumer(Queue q) {
		this.q=q;
	}

	@Override
	public void run() {
		for(;;)
		{
			q.getData();
		}
	}
}

public class MultiThreading1
{
	public static void main(String[] args) {
		Queue q=new Queue();
		Producer p=new Producer(q);
		Consumer c=new Consumer(q);
		p.setName("PRODUCER");
		c.setName("CONSUMER");
		p.start();
		c.start();
	}
}

//----------------------------------------------------------------------------------------------------------//



























