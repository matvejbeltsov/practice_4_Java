package MFC;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MFCService {


    public static void main(String[] args) {
        ServiceWindow window1 = new ServiceWindow("Молодой");
        ServiceWindow window2 = new ServiceWindow("Пожилой");
        ServiceWindow window3 = new ServiceWindow("Бизнесмен");


        Random random = new Random();
        Thread[] futures = new Thread[100];
        for (int i = 0; i < 100; i++){

            int n = random.nextInt(3);
            if(n == 0){
                futures[i] = new Thread(new Resident(1,window1));

            } else if (n == 1) {
                futures[i] = new Thread(new Resident(2,window2));
            }else {
                futures[i] = new Thread(new Resident(3,window3));
            }
        }


        for (Thread a: futures) {
            a.start();
            try{
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }


        System.out.println("Процент молодых граждан, ушедших без обслуживания: " + window1.countPercentAngryResindent() + "%");
        System.out.println("Процент пожилых граждан, ушедших без обслуживания: " +window2.countPercentAngryResindent() + "%");
        System.out.println("Процент бизнесменов, ушедших без обслуживания: " +window3.countPercentAngryResindent() + "%");




    }


    }
