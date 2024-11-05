package v5.helper;

import java.util.Scanner;

public class KioskConsoleIOHandler implements KioskIOHandler{

    Scanner sc = new Scanner(System.in);

    @Override
    public String readInput() {
        return sc.nextLine();
    }

    @Override
    public void writeOutput(String output) {
        System.out.println(output);
    }
}
