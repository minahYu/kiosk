package kiosk;

public class WaitingThread extends Thread {
    @Override
    public void run() {
        //super.run();
        int time = 3000;

        try {
            Thread.sleep(time);
        } catch(InterruptedException e) {
            System.out.println("WaitingThread : " + e.getMessage());
        }
    }
}
