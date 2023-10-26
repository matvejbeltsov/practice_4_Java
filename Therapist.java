package Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Therapist {
    String nameTherapist;

    int workTime;
    MRT mrt;
    int maxQueqe = -1;
    private final Object lock = new Object();
    List<Thread> peopleInQueqe = new ArrayList<>();
    public Therapist(String name, int workTime, MRT mrt){
        this.nameTherapist = name;
        this.workTime = workTime;
        this.mrt = mrt;

    }

    public void work(Patient patient){
        synchronized (lock) {
            if (peopleInQueqe.size() > maxQueqe) {
                maxQueqe = peopleInQueqe.size();
            }
            peopleInQueqe.remove(0);

            System.out.println("Человек " + patient.placeInTheQueue + " На приёме у терапевта");

            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Человек " + patient.placeInTheQueue + " ожидает МРТ");
        }
        mrt.work(patient);
    }

    public void updateList(Thread thread){

        peopleInQueqe.add(thread);
    }
    public synchronized void maxQueqe(){

        System.out.println("Максимальная очередь - " + maxQueqe);
    }
}
