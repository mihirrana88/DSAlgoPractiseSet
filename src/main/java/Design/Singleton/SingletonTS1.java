package Design.Singleton;

//Singleton thread safe
public class SingletonTS1 {
    private static SingletonTS1 singletonTS1;

    private SingletonTS1(){}

    public synchronized static SingletonTS1 getInstance(){
        if(null == singletonTS1){
            singletonTS1 = new SingletonTS1();
        }
        return singletonTS1;
    }
}
