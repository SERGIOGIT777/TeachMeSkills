package DZ6.ZD1;

import DZ6.ZD1.hands.SamsungHands;
import DZ6.ZD1.hands.SonyHands;
import DZ6.ZD1.hands.ToshibaHands;
import DZ6.ZD1.heads.SamsungHead;
import DZ6.ZD1.heads.SonyHead;
import DZ6.ZD1.heads.ToshibaHead;
import DZ6.ZD1.legs.SamsungLegs;
import DZ6.ZD1.legs.SonyLegs;
import DZ6.ZD1.legs.ToshibaLegs;

public class Run {
    public static void main(String[] args) {
        /*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */

        var r = new Robot(new SonyHead(14), new ToshibaHands(15), new SamsungLegs(16));
        var r1 = new Robot(new SamsungHead(23), new SonyHands(16), new ToshibaLegs(13));
        var r2 = new Robot(new ToshibaHead(15), new SamsungHands(32), new SonyLegs(14));
        System.out.println("Первый робот\n----------------------");
        r.action();
        System.out.println("----------------------");
        System.out.println("Второй робот\n----------------------");
        r1.action();
        System.out.println("----------------------");
        System.out.println("Третий робот\n----------------------");
        r2.action();
        System.out.println("----------------------");
        if (r.getPrice() > r1.getPrice() && r.getPrice() > r2.getPrice()) {
            System.out.println("Первый робот самый дорогой");
        } else if (r1.getPrice() > r.getPrice() && r1.getPrice() > r2.getPrice()) {
            System.out.println("Второй робот самый дорогой");
        } else {
            System.out.println("Третий робот самый дорогой");
        }
    }
}
