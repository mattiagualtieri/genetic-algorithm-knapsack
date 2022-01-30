import java.util.ArrayList;
import java.util.List;

public class Population {

    private int psize;
    private int gsize;
    private List<Genome> genomes;

    public Population(int psize, int gsize) {
        this.psize = psize;
        this.gsize = gsize;
    }

    public void generatePopulation(){
        genomes = new ArrayList<Genome>(gsize);
        for(int i = 0; i < psize; i++) {
            Genome genome = new Genome(gsize);
            genome.initialize();
            genomes.add(genome);
        }
    }

    public Genome get(int i){
        return genomes.get(i);
    }

    public Genome selectBest(ArrayList<KnapsackItem> items, int capacity){
        int best = 0;
        int maxfit = -1;
        for(int i = 0; i < psize; i++){
            int value = GeneticAlgorithmFunction.fitnessFunction(this.get(i), items, capacity);
            if(value >= maxfit){
                best = i;
                maxfit = value;
            }
        }
        Genome genome = genomes.remove(best);
        psize--;
        return genome;
    }

    public void add(Genome genome){
        genomes.add(genome);
        psize++;
    }

    @Override
    public String toString() {
        String str = "";
        for(Genome g: genomes) {
            str += g.toString() + "\n";
        }
        return str;
    }
}
