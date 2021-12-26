package connect4.views.console;

import connect4.types.Color;
import utils.views.Console;

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
