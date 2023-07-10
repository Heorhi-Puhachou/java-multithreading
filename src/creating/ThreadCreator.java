package creating;

public class ThreadCreator {

    public static void main(String args[])
    {
        RunnableDemo obj=new RunnableDemo();
        Thread tobj =new Thread(obj);
        tobj.start();

        ThreadDemo tDemoObj = new ThreadDemo();
        tDemoObj.start();
    }
}
