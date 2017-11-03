package painengine.launch;

abstract class Launcher{

    private static Game host;

    public static void main(String... args){
        System.out.println("Launch");
        host = new Game();
    }
}