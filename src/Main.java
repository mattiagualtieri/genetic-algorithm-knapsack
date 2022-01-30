import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static int n = 10;
    private static int psize = 6;
    private static int capacity = 100;

    public static void main(String[] args){
        System.out.println("Starting genetic algorithm for the knapsack problem...");

        // create items
        ArrayList<KnapsackItem> items = new ArrayList<KnapsackItem>();
        for(int i = 0; i < n; i++){
            int value = ThreadLocalRandom.current().nextInt(1, 10);
            int weight = ThreadLocalRandom.current().nextInt(1, 10);
            items.add(new KnapsackItem(value, weight));
        }

        // generate population
        Population population = new Population(psize, n);
        population.generatePopulation();

        for(int i = 0; i < 10; i++){
            Genome[] best = new Genome[2];
            best[0] = population.selectBest(items, capacity);
            best[1] = population.selectBest(items, capacity);
            Genome[] child = new Genome[2];
            child = GeneticAlgorithmFunction.singlePointCrossover(best[0], best[1]);
            child[0] = GeneticAlgorithmFunction.muteGenome(child[0]);
            child[1] = GeneticAlgorithmFunction.muteGenome(child[1]);
            child[0] = GeneticAlgorithmFunction.muteGenome(child[0]);
            child[1] = GeneticAlgorithmFunction.muteGenome(child[1]);
        }

    }

}
