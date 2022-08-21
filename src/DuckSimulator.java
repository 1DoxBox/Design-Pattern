import adapters.GooseAdapter;
import adapters.PigeonAdapter;
import animals.*;

import animals.composites.LeaderFlock;
import animals.decorated.QuackCounter;
import animals.decorated.QuackEcho;
import factories.AbstractDuckFactory;
import factories.CountAndEchoDuckFactory;
import factories.CountingDuckFactory;
import factories.DuckFactory;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulateDecoratorPattern1();

    }
    private void simulate(Quackable duck) {
        duck.quack();
    }

    private void simulateDecoratorPattern1() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redHeadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseAdapter = new GooseAdapter(new Goose());
        Quackable pigeonAdapter = new PigeonAdapter(new Pigeon());

        Quackable mallardDecorator = new QuackCounter(new QuackEcho(new MallardDuck()));

        System.out.println("\nDuck Simulator: With Decorator");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseAdapter);
        simulate(pigeonAdapter);
        simulate(mallardDecorator);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
    }

    private void simulateDecoratorPattern2() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redHeadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseAdapter = new GooseAdapter(new Goose());
        Quackable pigeonAdapter = new PigeonAdapter(new Pigeon());

        Quackable redHeadDecorator = new QuackEcho(new QuackCounter(new RedheadDuck()));

        System.out.println("\nDuck Simulator: With Decorator");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseAdapter);
        simulate(pigeonAdapter);
        simulate(redHeadDecorator);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
    }

    private void simulateAbstractFactoryPattern() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();
        AbstractDuckFactory countAndEchoDuckFactory = new CountAndEchoDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = countingDuckFactory.createRedheadDuck();
        Quackable duckCall = countAndEchoDuckFactory.createDuckCall();
        Quackable rubberDuck = countAndEchoDuckFactory.createRubberDuck();

        System.out.println("\nDuck Simulator: With Abstract Factory");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
    }

    private void simulateCompositePattern2() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        LeaderFlock flock = new LeaderFlock();
        flock.add(mallardDuck);
        flock.add(redHeadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);
        flock.quack();
    }

}