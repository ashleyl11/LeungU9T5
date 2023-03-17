import java.util.ArrayList;

public class Cabaret {
    public String name;
    public ArrayList<Performer> performers;

    public Cabaret (String name){
        this.name = name;
        performers = new ArrayList<Performer>();
    }

    public String getName(){
        return name;
    }

    public ArrayList<Performer> getPerformers(){
        return performers;
    }

    public boolean addPerformer(Performer perf){
        if (!performers.contains(perf)){
            performers.add(perf);
            return true;
        } else {
            return false;
        }
    }

    public boolean removePerformer(Performer perf){
        if (performers.contains(perf)){
            performers.remove(perf);
            return true;
        } else {
            return false;
        }
    }

    public double averagePerformerAge(){
        int sum = 0;
        for (Performer perf: performers){
            sum += perf.getAge();
        }
        return (double)sum/performers.size();
    }

    public ArrayList<Performer> performersOverAge(int ageLim){
        ArrayList<Performer> temp = new ArrayList<Performer>();
        for (Performer perf : performers){
            if (perf.getAge() >= ageLim){
                temp.add(perf);
            }
        }
        return temp;
    }

    public void groupRehearsal(){
        for (Performer perf : performers){
            System.out.println("REHEARSAL CALL! " + perf.getName());
            if (perf instanceof Comedian){
                Comedian temp = (Comedian) perf;
                temp.rehearse(false);
            } else {
                perf.rehearse();
            }
        }
    }

    public void cabaretShow(){
        for (Performer perf : performers){
            System.out.println("Welcome to the cabaret! Next act up... " + perf.getName());
            if (perf instanceof Dancer){
                Dancer temp = (Dancer)perf;
                temp.pirouette(2);
                temp.perform();
            } else {
                perf.perform();
            }
        }
    }
}
