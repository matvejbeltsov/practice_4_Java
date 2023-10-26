package MFC;

public class Resident implements Runnable{

    int ResidentCategory;

    ServiceWindow usedWindow;

    public Resident(int num, ServiceWindow usedWindow){
        this.ResidentCategory = num;
        this.usedWindow = usedWindow;
    }

    public void run(){
        usedWindow.serve(this);
    }

}