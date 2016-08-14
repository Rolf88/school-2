/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RolfMoikjær
 */
public class ServerProtocol {

    String output;

    public String processInput(String input) {
        if (input.contains("#")) {
            String[] commandInput = input.split("#");
            String command = commandInput[0].toUpperCase();
            input = commandInput[1];

            switch (command) {
                case "UPPER":
                    output = input.toUpperCase();
                    break;
                case "LOWER":
                    output = input.toLowerCase();
                    break;
                case "REVERSE":
                    output = new StringBuilder(input).reverse().toString();
                    break;
                case "TRANSLATE":
                    if (input.equalsIgnoreCase("dog")) {
                        output = "hund";
                    } else if (input.equalsIgnoreCase("cat")) {
                        output = "kat";
                    } else if (input.equalsIgnoreCase("horse")) {
                        output = "hest";
                    } else {
                        output = "#NOT_FOUND";
                    }
                    break;
                    
                default:
                    output = "Your input isn't compatible."
                            +"/n Please try again";
            }
        }else{
            output = "ERROR: #Command wasn't found";
        }
        return output;
    }
}
