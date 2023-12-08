package com.ys.audio.util;

import net.sourceforge.jaad.aac.Decoder;
import net.sourceforge.jaad.aac.SampleFrequency;
import net.sourceforge.jaad.aac.SampleRate;
import net.sourceforge.jaad.adts.ADTSDemultiplexer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class AacSampleRateExtractor {

    public static void main(String[] args) {
        String filePath = "path/to/your/audiofile.aac"; // Replace with your file path

        try {
            getSampleRate(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getSampleRate(String filePath) throws IOException {
        ADTSDemultiplexer adts = new ADTSDemultiplexer(Files.newInputStream(
                new File(filePath).toPath(), StandardOpenOption.READ));
        final Decoder decoder = Decoder.create(adts.getDecoderInfo());
        SampleRate sampleFrequency = decoder.getConfig().getSampleFrequency();
        return sampleFrequency.getFrequency();
    }
}

