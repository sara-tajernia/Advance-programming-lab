public class Test {

    public static void main(String[] args) {

        ClockDisplay ObjClock = new ClockDisplay();
        ObjClock.setTime(16, 53, 59);           //last second
        ObjClock.timeTickSec();
        System.out.println(ObjClock.getTime());

        ObjClock.setTime(16, 59, 50);           //last minute
        ObjClock.timeTick();
        System.out.println(ObjClock.getTime());

        ObjClock.setTime(23, 59, 59);           //last hour
        ObjClock.timeTick();
        ObjClock.timeTickSec();
        System.out.println(ObjClock.getTime());

        ObjClock.setTime(0, 0, 0);               //end of the day
        ObjClock.timeTickSec();
        System.out.println(ObjClock.getTime());

    }
}
