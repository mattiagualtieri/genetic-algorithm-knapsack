import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Genome {

    private int size;
    private int[] choices;

    public Genome(int size) {
        this.size = size;
        choices = new int[this.size];
    }

    public void initialize() {
        for(int i = 0; i < size; i++){
            choices[i] = ThreadLocalRandom.current().nextInt(0, 2);
        }
    }

    public int getSize() {
        return size;
    }

    public int get(int i){
        return choices[i];
    }

    public void setChoice(int i, int choice){
        choices[i] = choice;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < size; i++){
            str += choices[i];
        }
        return str;
    }
}
