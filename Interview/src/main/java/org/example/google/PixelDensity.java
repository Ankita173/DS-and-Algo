package org.example.google;

public class PixelDensity {
}




//Input:
//        R R R B B R
//        G G R R B R
//        G G R R R R
//        R G R R B R
//        R G G B B B
//
//        output:
//        14
//
//        Do we need only these 3 colors?
//        Prefer 24bit color space, with RGB colors, but ok to start with 3 colors.
//
//
//
//        See right and below, and UP.
//        If we see a matching color, increment by one.
//        Do backtracking of that element.
//
//        Some storage, what elements already processed. Not backtracking agains for that element.
//
//        Start at (0,0)
//
//        Count = 14
//
//        Map way
//        R, 14
//        B, 4
//        G, 7
//
//
//
//        findMaxPixelDensity(String[][] pixelMap) {
//        Int max = 0
//        Set<String> traversedPixel = new HashSet<>();
//        For (int i = 0; i < pixelMap.length; i++) {
//        for(int j = 0; j < pixelMap[0].length; j++) {
//        Int count = findPixels(i, j, pixelMap, pixelMap[I][J], 0, traversedPixel);
//        If (count > max ) max = count;
//        }
//
//        }
//
//
//        }
////backtracking
//        Int findPixels(int i, int j, String[][] pixelMap, String color, traversedPixel) {
//        If (i < 0 && i > pixelMap.length)
//        Return 0;
//        If (J < 0 && J > pixelMap[I].length)
//        Return 0;
//        If (traversedPixel.contains(StringFormat(“%s%s”, i, j))
//        Return 0;
//        traversedPixel.add(StringFormat(“%s%s”, i, j));
//        IF(color.equals(pixelMap[i][j]))
//        Return 1 + findPixels(i+1, j, pixelMap[i][j], pixelMap, traversedPixel) //right
//        + findPixels(i, j+1,pixelMap[i][j], pixelMap, traversedPixel) //below
//        + findPixels(i-1, j,pixelMap[i][j], pixelMap, traversedPixel) //up
//        + findPixels(i-1, j-1,pixelMap[i][j], pixelMap, traversedPixel); //back
//
//        Return 0;
//        }
//
//
//
//        Test cases:
//        R
//        Output: 1
//        OK
//
//        R R
//        Output: 2
//        OK
//
//
//        Test:
//        R R R R
//        R
//        R   R R
//        R     R
//        R R R R
//
//        Output:
//        13 -> 14

