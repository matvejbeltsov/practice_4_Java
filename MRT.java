package Hospital;

public class MRT {
    String nameMRT;
    int workTime;

    public MRT(String nameMRT, int workTime){
        this.nameMRT = nameMRT;
        this.workTime = workTime;
    }

    public synchronized void work(Patient patient){
        System.out.println("Человек "+ patient.placeInTheQueue + " попал на приём МРТ");
        try{
            Thread.sleep(workTime);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("Человек "+ patient.placeInTheQueue + " покидает больницу");
    }
}
