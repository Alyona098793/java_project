package not_project_tesr;

public abstract class MyThreads {
    volatile static int i;

    public static void main(String[] args) throws InterruptedException {

       new CreateThreadsRead().start();
       new CreateThreadsWrite().start();

         // myThread.start(); //запуск потоку
         // myThread.join(); //ждать завершения потока
         // Thread.yield(); // уступить другому потоку


    }

    static class CreateThreadsWrite extends Thread{

        @Override
        public void run(){
            while (i < 5){
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class CreateThreadsRead extends Thread{

        @Override
        public void run(){
            int localVar = i;
            while (localVar < 5){
                if (localVar != i) {
                    System.out.println("now value of i is " + i);
                    localVar = i;
                }
            }
        }
    }
}





