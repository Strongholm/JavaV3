class Car implements Runnable {

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(int carNum, Race race, int speed) {
        this.race = race;
        this.speed = speed;
        this.name = "Участник #" + carNum;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.START.countDown();
            MainClass.START.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        synchronized (MainClass.END) {
            if(MainClass.END.getCount() == MainClass.CARS_COUNT)
                System.out.println(this.name + " - Победитель!");
            MainClass.END.countDown();
        }
    }
}
