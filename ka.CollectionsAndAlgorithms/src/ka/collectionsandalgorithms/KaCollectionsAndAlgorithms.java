/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ka.collectionsandalgorithms;

/**
 *
 * @author RolfMoikjær
 */
public class KaCollectionsAndAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Problem2 calculator = new Problem2();
        calculator.frec(new int[]{2, 5, 2, 9, 7, 1, 100, 2, 3, 5, 77, 9, 1, 2, 6, 5});
        
        BinarySearchTree tree = new BinarySearchTree();
        
        tree.addElement("a");
        tree.addElement("b");
        tree.addElement("c");
        tree.addElement("d");
        tree.addElement("e");
        tree.addElement("f");
        tree.addElement("g");
        tree.addElement("h");
        
        String sum = tree.concatonate();
        System.out.println("res: " + sum);
        
//        int sum = tree.sum();
//        System.out.println("res: " +sum);

    }

}
