package huffman.lib;

import huffman.lib.models.CompressionResult;
import huffman.lib.models.Node;
import huffman.lib.services.Utilities;

import java.util.ArrayList;
import java.util.List;

public class Decompressor {

    public static byte[] decompress(CompressionResult compressedData) {
        if (compressedData == null) {
            throw new IllegalArgumentException("compressed data cannot be null");
        }

        List<Byte> outputBytes = new ArrayList<>();
        int readIndex = 0;
        while (readIndex < compressedData.getValidBitCount()) {
            Node current = compressedData.getTrieRoot();
            while (!current.isLeaf()) {
                boolean bit = compressedData.getCompressedBit(readIndex);
                if (bit) {
                    current = current.getRight();
                } else {
                    current = current.getLeft();
                }
                readIndex++;
            }
            outputBytes.add(current.getByteData());
        }
        return Utilities.toByteArray(outputBytes);
    }
}
