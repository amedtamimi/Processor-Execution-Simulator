public abstract class Status {
    public static void currentCycle(int clock){
        System.out.println("Cycle "+clock+ " -----------------------------------------------------------");
    }

    public static void taskCreation(int id) {
        System.out.println("T"+id+" is Created");
    }

    public static void finishedTask(int id,int taskId){
        System.out.println("P"+id+" has completed T"+taskId);
    }

}
