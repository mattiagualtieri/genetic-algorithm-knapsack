import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public final class GeneticAlgorithmFunction {

    public static int fitnessFunction(Genome genome, ArrayList<KnapsackItem> items, int capacity){
        int value = 0;
        int weight = 0;
        for(int i = 0; i < genome.getSize(); i++){
            weight += items.get(i).getWeight() * genome.get(i);
            if(weight > capacity)
                return 0;
            value += items.get(i).getValue() * genome.get(i);
        }
        return value;
    }

    public static Genome[] singlePointCrossover(Genome a, Genome b){
        Genome[] child = new Genome[2];
        child[0] = new Genome(a.getSize());
        child[1] = new Genome(a.getSize());
        int point = ThreadLocalRandom.current().nextInt(1, a.getSize());
        int i = 0;
        for(; i < point; i++){
            child[0].setChoice(i, a.get(i));
            child[1].setChoice(i, b.get(i));
        }
        for(; i < a.getSize(); i++){
            child[0].setChoice(i, b.get(i));
            child[1].setChoice(i, a.get(i));
        }
        return child;
    }

    public static Genome muteGenome(Genome genome){
        int mute = ThreadLocalRandom.current().nextInt(0, 2);
        if(mute == 0)
            return genome;
        int index = ThreadLocalRandom.current().nextInt(0, genome.getSize());
        if(genome.get(index) == 0)
            genome.setChoice(index, 1);
        else
            genome.setChoice(index, 0);
        return genome;
    }

}
