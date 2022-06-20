package Design.Singleton;


//Eager initialization
public class SingletonClassEI {
    private static volatile SingletonClassEI singletonClassEI = new SingletonClassEI();

    private SingletonClassEI(){}

    public static SingletonClassEI getInstance(){
        return singletonClassEI;
    }
}
