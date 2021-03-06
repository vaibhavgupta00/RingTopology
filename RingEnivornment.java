class LinuxEnviroment{

volatile int TOKEN=1; // It is the TOKEN

final int n1=1,n2=2,n3=3,n4=4; // These are ID of everyNode

int a=1,b=1,c=1,d=1; // These variables help to count 10 times each Nodes Run(Print)


public void checknode1()throws InterruptedException{

synchronized(this){

if(TOKEN==n1){

System.out.println("My turn! My Id="+n1);

TOKEN++;

a++;

}

reset();

wait();

checknode1();

}

}


public void checknode2()throws InterruptedException{

synchronized(this){

if(TOKEN==n2){

System.out.println("My turn! My Id="+n2);

TOKEN++;

b++;

}

reset();

wait();

checknode2();

}

}


public void checknode3()throws InterruptedException{

synchronized(this){

if(TOKEN==n3){

System.out.println("My turn! My Id="+n3);

TOKEN++;

c++;

}

reset();

wait();

checknode3();

}

}


public void checknode4()throws InterruptedException{

synchronized(this){

if(TOKEN==n4){

System.out.println("My turn! My Id="+n4);

TOKEN++;

d++;

}

reset();

wait();

checknode4();

}

}


public void reset()throws InterruptedException{

synchronized(this){

if(a!=10 || b!=10 || c!=10 || d!=10){

notifyAll();

if(TOKEN==5){

TOKEN=1;

System.out.println();

}

}else if(a==10 && b==10 c==10 && d==10){

System.out.println("Not my Turn!");

System.exit(0);

}

}

}


public static void main(String agrs[])throws InterruptedException{

final LinuxEnviroment a=new LinuxEnviroment();

Thread node1= new Thread(new Runnable(){

public void run(){

try{

a.checknode1();

}catch(Exception e){

System.out.println(e);

}

}

});

Thread node2= new Thread(new Runnable(){

public void run(){

try{

a.checknode2();

}catch(Exception e){

System.out.println(e);

}

}

});

Thread node3= new Thread(new Runnable(){

public void run(){

try{

a.checknode3();

}catch(Exception e){

System.out.println(e);

}

}

});

Thread node4= new Thread(new Runnable(){

public void run(){

try{

a.checknode4();

}catch(Exception e){

System.out.println(e);

}

}

});

node1.start();

node2.start();

node3.start();

node4.start();

/* Volatile keyword is most important role in this program it's work as a static nut, it not a static because it;s store in RAM

not in cahce memory in every single Thread */

/* node1 , node2 , node3, node4 --- These are main 4 thread of this program */  

}

/* Four Thread are using for NODE and One More are use for RESET the value of TOKEN*/

}

/* checkNode1(); checkNode2(); checkNode3(); checkNode4(); these function are help to increase the value of TOKEN */

/* reset(); Function are use to reset the value of TOKEN if it is 5 so, it can change to 1 */

/* EACH THREAD INCREASE OUR TOKEN VALUE 10 TIMES */

/* Each thread share the reset() function in this program */

/* WAIT() Function are use to block the thread untill it will not NOTIFY() ---- Here i was using wait() but, in this program is necessary to use notifyAll() function because, all thread are unblocked at one time */

/* END*/
