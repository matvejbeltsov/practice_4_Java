package Hospital;

public class Patient implements Runnable{
    Therapist therapist;

    int placeInTheQueue;

    public Patient(Therapist therapist, int placeInTheQueue) {
        this.therapist = therapist;
        this.placeInTheQueue = placeInTheQueue;
    }

    @Override
    public void run(){
        System.out.println("Человек " + placeInTheQueue + " ожидает терапевта");
        therapist.work(this);
    }
}
