package not_project_tesr;

public class Singleton {
    private static Singleton instance;

    private Singleton(){

    }

    private static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }



    public static void main(String[] args) {
        Singleton singleton = new Singleton();

    }
}

