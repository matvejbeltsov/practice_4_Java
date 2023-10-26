package MFC;

public class ServiceWindow {

    String nameOfCategory;
    boolean available;

    double leftResident;

    public ServiceWindow(String nameOfCategory) {
        this.available = false;
        this.nameOfCategory = nameOfCategory;

    }

    public void serve(Resident resident){
        if (!available) {
            available = true;
            try {
                Thread.sleep(50);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            available = false;
            System.out.println(nameOfCategory + " гражданин получил обслуживание");
        }
        else {
            leftResident++;
            System.out.println(nameOfCategory + " гражданин ушел злым");
        }
    }

    public double countPercentAngryResindent(){
        return (leftResident / 100) * 100;
    }

}
