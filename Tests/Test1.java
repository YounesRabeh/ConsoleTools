package Tests;

import colors.Colors;

import java.util.LinkedList;

import static src.Tools.*;
import static styles.Styles.*;
import static input.Input.*;

public class Test1 {
    public static void main(String[] args) {
        new Test1();
    }
    public Test1(){
        print(Colors.CYAN_BRIGHT, "Demetrio ::");
        print(Colors.CYAN_BRIGHT, "un uomo ");
        setText_color(Colors.BLUE_BOLD);
        println("Demetrio -_-");
        println(Colors.RED_BACKGROUND_BRIGHT, "Ekavkavdfhad aiyfa");
        print(getNextLine());
        print(Colors.RED, "wwwww ");
        println("io sono blu ");
        println(Colors.GREEN_BOLD, "sssss");
        resetText_color();
        println("io sono normale"); println(Colors.GREEN_BACKGROUND, "io");

        LinkedList a = new LinkedList();
        a.add(null);
        System.out.println(a.size());

    }

}
