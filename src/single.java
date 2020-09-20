public class single {

    private single() {}

    private static single instance = new single();


    private static single getInstance() {
        return instance;
    }

}
