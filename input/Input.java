package input;

import java.util.Scanner;

public final class Input {
    private static Scanner inputSc = new Scanner(System.in);

    public static String getNextLine(){
        return inputSc.nextLine();
    }


}
