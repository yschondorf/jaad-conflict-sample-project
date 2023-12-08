package com.ys.audio.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AacSampleRateExtractorTest {

    @Test
    public void givenAacFile_whenCallingGetSampleRate_thenSampleRateReturned() throws IOException {
        String pathString = "src/test/resources/com/ys/audio/util/27 בנוב׳, 9.44_piano c sound.aac";
        int sampleRate = AacSampleRateExtractor.getSampleRate(pathString);
        System.out.println("sampleRate = " + sampleRate);
    }
}