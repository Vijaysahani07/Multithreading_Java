//Create two threads that print numbers from 1 to 10 concurrently

class FirstThread implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i <= 10; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);

      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}

public class TwoThread {
  public static void main(String[] args) {

    // creating two thread to call the start() method

    Thread firsThread = new Thread(new FirstThread(), "Thread-1");
    Thread secondThread = new Thread(new FirstThread(), "Thread-2");

    firsThread.start();
    secondThread.start();
  }
}