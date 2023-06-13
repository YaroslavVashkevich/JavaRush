package com.javarush.task.task20.task2015.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] newAdress = new byte[ip.length];
        for (int i = 0; i < ip.length ; i++) {
            newAdress[i] = (byte)(ip[i] & mask[i]);
        }
        return newAdress;
    }

    public static void print(byte[] bytes) {
        String str = "";
        for ( byte b : bytes) {
            StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(b));
           if (stringBuilder.length() == 32){
              stringBuilder.delete(0, 24);
              str = str + stringBuilder + " ";
           } else{
               while (stringBuilder.length() < 8){
                   stringBuilder.insert(0, 0);
               }
               str = str + stringBuilder + " ";
           }

        }
        str = str.trim();
        System.out.println(str);
    }
}
