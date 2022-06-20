package Design.Singleton;

// Singleton thread safe, Double check locking method
public class SingletonTS2 {
    private static volatile SingletonTS2 singletonTS2;

    private SingletonTS2(){}

    public static SingletonTS2 getInstance(){
        if(null == singletonTS2){
            synchronized (SingletonTS2.class){
                if(null == singletonTS2){
                    singletonTS2 = new SingletonTS2();
                }
            }
        }

        return singletonTS2;
    }
}
