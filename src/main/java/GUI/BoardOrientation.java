package GUI;

import game.Game;

import java.awt.*;

public class BoardOrientation {

    static boolean flipX = true;
    static boolean flipY = true;
    static Icons icons = Icons.getInstance();

    public BoardOrientation() {
    }

    public static int dependingOnOrientation(int index) {
        if (index != 0 && index != 25) {
            if (flipY) {
                index = 25 - index;
            }
            if (flipX) {
                if (index <= 12) {
                    index = 13 - index;
                } else {
                    index = 37 - index;
                }
            }
        }
        return index;
    }

    public static void drawTokensUpperLeft(Graphics g) {
        if (flipX) {
            if (flipY) {

            } else {

            }
        } else {
            if (flipY) {

            } else {

            }
        }
    }

}
