package Design.Singleton;

//Lazy initialization
public class SingletonClassLI {
    private static SingletonClassLI singletonClassLI;

    private SingletonClassLI(){}

    public static SingletonClassLI getInstance(){
        if(null == singletonClassLI){
            singletonClassLI = new SingletonClassLI();
        }
        return singletonClassLI;
    }
}
