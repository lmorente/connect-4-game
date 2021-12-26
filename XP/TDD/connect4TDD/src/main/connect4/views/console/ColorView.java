package main.connect4.views.console;

import main.connect4.types.Color;
import main.utils.views.Console;

class ColorView {

    void write(Color color) {
        String string = color.name();
        if (color.isNull()) {
            string = " ";
        } else {
            string = ""+string.charAt(0);
        }
        Console.getInstance().write(string);
    }
    
}
