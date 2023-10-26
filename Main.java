package Hospital;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int mrtWork = 200;
        int therapistWork = 200;
        int patiantCount = 50;

        Thread[] humans = new Thread[patiantCount];
        MRT mrt = new MRT("fsdfsdfsf",mrtWork);
        Therapist therapist = new Therapist("Василий", therapistWork,mrt);

        for (int i = 0; i < patiantCount; i++){
            humans[i] = new Thread(new Patient(therapist, i));
        }

        int iter = 0;
        for (Thread thread: humans) {
            System.out.println("Человек " + iter +" Поступил в очередь");
            therapist.updateList(thread);
            thread.start();
            try{
                Thread.sleep(100);

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            iter++;
        }
        for (Thread thread:
                humans) {
            try{thread.join();} catch (InterruptedException e){e.printStackTrace();}
        }


        therapist.maxQueqe();

    }
}

