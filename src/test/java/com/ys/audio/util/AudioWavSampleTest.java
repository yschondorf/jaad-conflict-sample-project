package com.ys.audio.util;

import com.ys.audio.AudioFileType;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class AudioWavSampleTest {

    @Test
    public void givenHighSampleRateWavFile_whenCallingGetSampleRate_thenProperSampleRateReturned() throws IOException {
        String path = "src/test/resources/com/ys/audio/util/file_example_WAV_1MG.wav";
        assertThat(new File(path)).exists();
        int sampleRate = AudioWavSampleRate.getSampleRate(path);
        assertThat(sampleRate).isEqualTo(44100);
    }
}