/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise1;

/**
 *
 * @author RolfMoikjær
 */
public class Exercise1bTester {

    private static Exercise1a.Thread1 E1aThread1;
    private static Exercise1a.Thread1 E1aThread2;
    private static Exercise1a.Thread1 E1aThread3;

    public static void main(String[] args) {
        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());
        E1aThread1 = new Exercise1a.Thread1("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png", 0);
        E1aThread2 = new Exercise1a.Thread1("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png", 0);
        E1aThread3 = new Exercise1a.Thread1("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png", 0);

        int res = 0;

        long start = System.nanoTime();
//                E1aThread1.start();
//                E1aThread2.start();
//                E1aThread3.start();

        E1aThread1.run();
        E1aThread2.run();
        E1aThread3.run();

        try {
            E1aThread1.join();
            E1aThread2.join();
            E1aThread3.join();
        } catch (Exception e) {
        }
        res += E1aThread1.getRes1();
        res += E1aThread2.getRes1();
        res += E1aThread3.getRes1();

        long end = System.nanoTime();
        System.out.println("Time Sequental: " + (end - start));

        System.out.println(res);
        //It takes a bit longer time, but you will get the right result!:)
    }

}
