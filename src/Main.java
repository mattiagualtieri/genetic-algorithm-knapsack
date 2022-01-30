import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static int n = 8;
    private static int psize = 6;
    private static int capacity = 104;

    public static void main(String[] args){
        System.out.println("Starting genetic algorithm for the knapsack problem...");

        // create items
        ArrayList<KnapsackItem> items = new ArrayList<KnapsackItem>();

        items.add(new KnapsackItem(350,25));
        items.add(new KnapsackItem(400,35));
        items.add(new KnapsackItem(450,45));
        items.add(new KnapsackItem(20, 5));
        items.add(new KnapsackItem(70,25));
        items.add(new KnapsackItem(8, 3));
        items.add(new KnapsackItem(5, 2));
        items.add(new KnapsackItem(5, 2));


        // generate population
        Population population = new Population(psize, n);
        population.generatePopulation();

        for(int i = 0; i < 10; i++){
            System.out.println("-- Generation " + i);
            Genome[] best = new Genome[2];
            best[0] = population.selectBest(items, capacity);
            best[1] = population.selectBest(items, capacity);
            System.out.println("Best: " + best[0] + ", value: " + GeneticAlgorithmFunction.fitnessFunction(best[0], items, capacity));
            Genome[] child = new Genome[2];
            child = GeneticAlgorithmFunction.singlePointCrossover(best[0], best[1]);
            child[0] = GeneticAlgorithmFunction.muteGenome(child[0]);
            child[1] = GeneticAlgorithmFunction.muteGenome(child[1]);
            Population newpopulation = new Population(psize - 4, n);
            newpopulation.generatePopulation();
            newpopulation.add(best[0]);
            newpopulation.add(best[1]);
            newpopulation.add(child[0]);
            newpopulation.add(child[1]);
            population = newpopulation;
            population.setSize(psize);
        }



    }

    private void bigInit(ArrayList<KnapsackItem> items){
        // n = 24
        // capacity = 6404180
        // optimal profit = 13549094
        items.add(new KnapsackItem(825594, 382745));
        items.add(new KnapsackItem(1677009, 799601));
        items.add(new KnapsackItem(1676628, 909247));
        items.add(new KnapsackItem(1523970, 729069));
        items.add(new KnapsackItem(943972, 467902));
        items.add(new KnapsackItem(97426,  44328));
        items.add(new KnapsackItem(69666,  34610));
        items.add(new KnapsackItem(1296457, 698150));
        items.add(new KnapsackItem(1679693, 823460));
        items.add(new KnapsackItem(1902996, 903959));
        items.add(new KnapsackItem(1844992, 853665));
        items.add(new KnapsackItem(1049289, 551830));
        items.add(new KnapsackItem(1252836, 610856));
        items.add(new KnapsackItem(1319836, 670702));
        items.add(new KnapsackItem(953277, 488960));
        items.add(new KnapsackItem(2067538, 951111));
        items.add(new KnapsackItem(675367, 323046));
        items.add(new KnapsackItem(853655, 446298));
        items.add(new KnapsackItem(1826027, 931161));
        items.add(new KnapsackItem(65731,  31385));
        items.add(new KnapsackItem(901489, 496951));
        items.add(new KnapsackItem(577243, 264724));
        items.add(new KnapsackItem(466257, 224916));
        items.add(new KnapsackItem(369261, 169684));
    }

    private void randomInit(ArrayList<KnapsackItem> items){
        for(int i = 0; i < n; i++){
            int value = ThreadLocalRandom.current().nextInt(1, 10);
            int weight = ThreadLocalRandom.current().nextInt(1, 10);
            items.add(new KnapsackItem(value, weight));
        }
    }

}
