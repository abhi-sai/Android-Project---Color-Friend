package org.opencv.samples.colorblobdetect;

//import java.awt.Color;

import java.util.ArrayList;

/**
 * Get color name from rgb/hex value/awt color
 * */

public class ColorUtils {

    /**
     * Initialize the color list that we have.
     */
    private ArrayList<ColorName> initColorList() {
        ArrayList<ColorName> colorList = new ArrayList<ColorName>();
        colorList.add(new ColorName("White",255,255,255));
        //colorList.add(new ColorName("Ivory",255,255,240));
        colorList.add(new ColorName("Light Yellow",255,255,224));
        //colorList.add(new ColorName("Snow",255,250,250));
        //colorList.add(new ColorName("Floral White",255,250,240));
        colorList.add(new ColorName("Lemon Yellow",255,250,205));
        //colorList.add(new ColorName("Corn Silk",255,248,220));
        //colorList.add(new ColorName("Sea Shell",255,245,238));
        colorList.add(new ColorName("Light Pink",255,240,245));
        colorList.add(new ColorName("Light Yellow",255,239,213));
        //colorList.add(new ColorName("Blanched Almond",255,235,205));
        colorList.add(new ColorName("Light Peach",255,228,225));
        //colorList.add(new ColorName("Bisque",255,228,196));
        colorList.add(new ColorName("Moccasin",255,228,181));
        //colorList.add(new ColorName("Navajo White",255,222,173));
        colorList.add(new ColorName("Peach Puff",255,218,185));
        colorList.add(new ColorName("Pink",255,192,203));
        colorList.add(new ColorName("Light Pink",255,182,193));
        colorList.add(new ColorName("Light Salmon",255,160,122));
        colorList.add(new ColorName("Hot Pink",255,105,180));
        //colorList.add(new ColorName("Old Lace",253,245,230));
        colorList.add(new ColorName("Light Yellow",250,250,210));
        //colorList.add(new ColorName("Linen",250,240,230));
        //colorList.add(new ColorName("Antique White",250,235,215));
        colorList.add(new ColorName("Salmon",250,128,114));
        colorList.add(new ColorName("White",248,248,255));
        colorList.add(new ColorName("Mint",245,255,250));
        //colorList.add(new ColorName("White Smoke",245,245,245));
        colorList.add(new ColorName("Beige",245,245,220));
        colorList.add(new ColorName("Wheat",245,222,179));
        colorList.add(new ColorName("Azure",240,255,255));
        //colorList.add(new ColorName("Honeydew",240,255,240));
        //colorList.add(new ColorName("Alice Blue",240,248,255));
        colorList.add(new ColorName("Yellow",240,230,140));
        colorList.add(new ColorName("Light Coral",240,128,128));
        //colorList.add(new ColorName("Pale Golden Rod",238,232,170));
        colorList.add(new ColorName("Violet",238,130,238));
        colorList.add(new ColorName("Dark Salmon",233,150,122));
        colorList.add(new ColorName("Lavender",230,230,250));
        colorList.add(new ColorName("Light Cyan",224,255,255));
        colorList.add(new ColorName("Biscuit Brown",222,184,135));
        colorList.add(new ColorName("Plum",221,160,221));
        colorList.add(new ColorName("Cement Grey",220,220,220));
        colorList.add(new ColorName("Coral",219,112,147));
        colorList.add(new ColorName("Orchid",218,112,214));
        //colorList.add(new ColorName("Thistle",216,191,216));
        colorList.add(new ColorName("Light Grey",211,211,211));
        colorList.add(new ColorName("Tan",210,180,140));
        colorList.add(new ColorName("Silver",192,192,192));
        colorList.add(new ColorName("Dark Khaki",189,183,107));
        colorList.add(new ColorName("Rosy Brown",188,143,143));
        colorList.add(new ColorName("Light Blue",176,224,230));
        colorList.add(new ColorName("Light Steel Blue",176,196,222));
        colorList.add(new ColorName("Pale Turquoise",175,238,238));
        colorList.add(new ColorName("Light Blue",173,216,230));
        //colorList.add(new ColorName("Dark Gray / Dark Grey",169,169,169));
        colorList.add(new ColorName("Pale Green",152,251,152));
        colorList.add(new ColorName("Purple",147,112,219));
        colorList.add(new ColorName("Light Green",144,238,144));
        colorList.add(new ColorName("Dark Sea Green",143,188,143));
        //colorList.add(new ColorName("Light Sky Blue",135,206,250));
        colorList.add(new ColorName("Sky Blue",135,206,235));
        //colorList.add(new ColorName("Gray / Grey",128,128,128));
        colorList.add(new ColorName("Aqua Marine",127,255,212));
        colorList.add(new ColorName("Purple",123,104,238));
        //colorList.add(new ColorName("Light Slate Gray",119,136,153));
        colorList.add(new ColorName("Slate Gray",112,128,144));
        //colorList.add(new ColorName("Dim Gray / Dim Grey",105,105,105));
        colorList.add(new ColorName("Medium Aqua Marine",102,205,170));
        colorList.add(new ColorName("Blue",100,149,237));
        colorList.add(new ColorName("Black",0,0,0));
        colorList.add(new ColorName("Navy",0,0,128));
        colorList.add(new ColorName("Dark Blue",0,0,139));
        colorList.add(new ColorName("Medium Blue",0,0,205));
        colorList.add(new ColorName("Blue",0,0,255));
        colorList.add(new ColorName("Dark Green",0,100,0));
        colorList.add(new ColorName("Green",0,128,0));
        colorList.add(new ColorName("Teal",0,128,128));
        colorList.add(new ColorName("Dark Cyan",0,139,139));
        colorList.add(new ColorName("Deep Sky Blue",0,191,255));
        colorList.add(new ColorName("Dark Turquoise",0,206,209));
        colorList.add(new ColorName("Bright Green",0,250,154));
        colorList.add(new ColorName("Lime Green",0,255,0));
        colorList.add(new ColorName("Bright Green",0,255,127));
        //colorList.add(new ColorName("Aqua",0,255,255));
        colorList.add(new ColorName("Cyan",0,255,255));
        colorList.add(new ColorName("Purple",106,90,205));
        colorList.add(new ColorName("Olive Green",107,142,35));
        colorList.add(new ColorName("Lawn Green",124,252,0));
        colorList.add(new ColorName("Lawn Green",127,255,0));
        colorList.add(new ColorName("Maroon",128,0,0));
        colorList.add(new ColorName("Purple",128,0,128));
        colorList.add(new ColorName("Olive Green",128,128,0));
        colorList.add(new ColorName("Blue-Violet",138,43,226));
        colorList.add(new ColorName("Maroon",139,0,0));
        colorList.add(new ColorName("Purple",139,0,139));
        colorList.add(new ColorName("Saddle Brown",139,69,19));
        colorList.add(new ColorName("Dark Violet",148,0,211));
        colorList.add(new ColorName("Dark Violet",153,50,204));
        colorList.add(new ColorName("Lime Green",154,205,50));
        colorList.add(new ColorName("Brown",160,82,45));
        colorList.add(new ColorName("Dark Red",165,42,42));
        colorList.add(new ColorName("Bright Green",173,255,47));
        colorList.add(new ColorName("Brick Red",178,34,34));
        colorList.add(new ColorName("Ocher Yellow",184,134,11));
        colorList.add(new ColorName("Medium Orchid",186,85,211));
        colorList.add(new ColorName("Magenta",199,21,133));
        colorList.add(new ColorName("Light Brown",205,133,63));
        colorList.add(new ColorName("Dark Coral",205,92,92));
        colorList.add(new ColorName("Dark Orange",210,105,30));
        colorList.add(new ColorName("Golden",218,165,32));
        colorList.add(new ColorName("Crimson",220,20,60));
        colorList.add(new ColorName("Sandy Brown",244,164,96));
        colorList.add(new ColorName("Midnight Blue",25,25,112));
        colorList.add(new ColorName("Red",255,0,0));
        colorList.add(new ColorName("Fuchsia",255,0,255));
        colorList.add(new ColorName("Carrot Orange",255,127,80));
        colorList.add(new ColorName("Orange",255,140,0));
        colorList.add(new ColorName("Light Orange",255,165,0));
        colorList.add(new ColorName("Deep Pink",255,20,147));
        colorList.add(new ColorName("Medium Yellow",255,215,0));
        colorList.add(new ColorName("Yellow",255,255,0));
        colorList.add(new ColorName("Orange Red",255,69,0));
        colorList.add(new ColorName("Tomato",255,99,71));
        colorList.add(new ColorName("Forest Green",34,139,34));
        colorList.add(new ColorName("Sea Green",46,139,87));
        //colorList.add(new ColorName("Dark Slate Gray",47,79,79));
        colorList.add(new ColorName("Green",50,205,50));
        colorList.add(new ColorName("Indigo",72,61,139));
        colorList.add(new ColorName("Indigo",75,0,130));
        colorList.add(new ColorName("Dark Olive Green",85,107,47));
        colorList.add(new ColorName("Cadet Blue",95,158,160));
        colorList.add(new ColorName("Medium Turquoise",72,209,204));
        colorList.add(new ColorName("Steel Blue",70,130,180));
        colorList.add(new ColorName("Royal Blue",65,105,225));
        colorList.add(new ColorName("Turquoise",64,224,208));
        colorList.add(new ColorName("Medium Sea Green",60,179,113));
        colorList.add(new ColorName("Light Sea Green",32,178,170));
        colorList.add(new ColorName("Blue",30,144,255));
        return colorList;
    }

    //Get the closest color name from color list

    public String getColorNameFromRgb(double r, double g, double b) {
        ArrayList<ColorName> colorList = initColorList();
        ColorName closestMatch = null;
        int minMSE = Integer.MAX_VALUE;
        int mse;
        for (ColorName c : colorList) {
            mse = c.computeMSE(r, g, b);
            if (mse < minMSE) {
                minMSE = mse;
                closestMatch = c;
            }
        }

        if (closestMatch != null) {
            return closestMatch.getName();
        } else {
            return "No matched color name.";
        }
    }

    public class ColorName {
        public int r, g, b;
        public String name;

        public ColorName(String name, int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.name = name;
        }

        public int computeMSE(double pixR, double pixG, double pixB) {
            return (int) (((pixR - r) * (pixR - r) + (pixG - g) * (pixG - g) + (pixB - b)
                    * (pixB - b)) / 3);
        }

        public int getR() {
            return r;
        }

        public int getG() {
            return g;
        }

        public int getB() {
            return b;
        }

        public String getName() {
            return name;
        }
    }
}