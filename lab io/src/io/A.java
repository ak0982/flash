package io;

import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.ObjectOutputStream;
public class A {
        public static void main (String[] args) throws Exception
        {
               
                Student.experiment1();
                Student.experiment2();
                Student.experiment3();
                Student.experiment4();



        }
}
class Student implements java.io.Serializable
{

        public String username = null;
        private transient String password = null;
        public String name = null;
        public int roll = 0;
        public int marks = 0;
        public transient static int totalMarks = 100;
        public transient double gradePoints = 0.0;
        public transient final String institute;

        public Student (String username,String password,String name,int roll,int marks,String institute)
        {
                this.username = username;
                this.password = password;
                this.name = name;
                this.roll = roll;
                this.marks = marks;
                this.institute = institute;

                gradePoints = (10.0 * marks) / totalMarks;
        }

        public String toString()
        {

                return username +"\n"+password+"\n"+name+"\n"+roll+"\n"+marks+"\n"+institute+"\n";
        }


        public static void  experiment1()
        {
                Student stu1 = new Student("ak47","kumar","amar kumar",1801016,96,"IIITG");
                Student stu2 = new Student("ak4747","kumar s","ankit kumar s",1801017,90,"IIITG");
                Student stu3 = new Student("ak474747","raj","adarsh raj",1801018,85,"IIITG");
                Student stu4 = new Student("ak47474747","chini","aman chini",1801019,80,"IIITG");
                System.out.println(stu1);
                System.out.println(stu2);
                System.out.println(stu3);
                System.out.println(stu4);
               

                File f = new File("records.txt");

                FileWriter fw = null;

                try{
                       fw = new FileWriter(f);
                        fw.write(stu1.toString()+"\n");
                         fw.write(stu2.toString()+"\n");
                          fw.write(stu3.toString()+"\n");
                           fw.write(stu4.toString()+"\n");
                
                }
                catch(Exception e)
                {
                        System.out.println("file is not avaliable");
                }
                finally
                {
                        try{
                                fw.close();
                                fw.flush();
                        }
                        catch(Exception ex)
                        {
                                System.out.println("not close ");
                        }

                }




        }
        public static void  experiment2() throws IOException
        {
        	try {
        		File f1 = new File("records.txt");
        		Scanner sc1 = new Scanner(f1);
        	Student st[] =new Student[4]; 
        	System.out.println("in experiment 2"+st.length);
        	for(int i=0;i<st.length;i++)
        	{ 
        		
        		String ud = sc1.nextLine();
        		
        	String name1 = sc1.nextLine();
        	
        	String pass = sc1.nextLine();
        	
        	int r1 = sc1.nextInt();
        	
        	int m1 = sc1.nextInt();
        	
        	String inst = sc1.nextLine();
        	sc1.nextLine();
        	
        	st[i]= new Student(ud,name1,pass,r1,m1,inst);
        	System.out.println("this is after object "+i);
        	System.out.println(st[i]);
        	
        	} 
        	sc1.close(); 
        	
        	
        	} 
        	catch (Exception  e)
        	{ 
        		System.out.println(e);
        	}
        	finally
        	{
        		OutputStreamWriter sc1;
        		
        		
        	}
        	 
        	
          
        	
        	
        	
        }
      
        public static void  experiment3() throws FileNotFoundException, IOException
        {
        	Student stu5 = new Student("Ak47","kumar","amar kumar",1801016,96,"IIITG");
            Student stu6 = new Student("Ak4747","kumar s","ankit kumar s",1801017,90,"IIITG");
            Student stu7 = new Student("Ak474747","raj","adarsh raj",1801018,85,"IIITG");
            Student stu8 = new Student("Ak47474747","chini","aman chini",1801019,80,"IIITG");
        	
            System.out.println("this is  experiment 3");
        	
            System.out.println(stu5);
            System.out.println(stu6);
            System.out.println(stu7);
            System.out.println(stu8);
            try {
            	String filename = "records.object";
            	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)); 
            	oos.writeObject(stu5); 
            	oos.writeObject(stu6);
            	oos.writeObject(stu7);
            	oos.writeObject(stu8);
            	
            	 oos.close();
                 oos.flush();
        
            }
            catch (Exception  e)
        	{ 
        		System.out.println(e);
        	}
            finally
            {
               
                           
             
            }
        	
        	
        }
        public static void  experiment4()throws FileNotFoundException, IOException
        {
        	try {
        	String filename2 = "records.object"; 
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename2));
            Student st2[] =new Student[4]; 
            
             st2[0] = (Student) ois.readObject();
             st2[1] = (Student) ois.readObject();
             st2[2] = (Student) ois.readObject();
             st2[3] = (Student) ois.readObject();
            
            System.out.println("this is experiment 4");
            System.out.println(st2[0]);
            System.out.println(st2[1]);
            System.out.println(st2[2]);
            System.out.println(st2[3]);
            ois.close();
        	}
        	catch (Exception  e)
        	{ 
        		System.out.println(e);
        	}
            finally
            {
               
                           
             
            }
        	
        }
        





}
