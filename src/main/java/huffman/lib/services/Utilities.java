package huffman.lib.services;

import java.util.List;

public class Utilities {
    public static byte[] toByteArray(List<Byte> input) {
        byte[] output = new byte[input.size()];
        for (int i = 0; i < input.size(); i++) {
            output[i] = input.get(i);
        }
        return output;
    }
}
