package com.ys.audio.util;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AudioWavSampleRate {

    public static int getSampleRate(String audioFilePath) throws FileNotFoundException {
        File audioFile = new File(audioFilePath);
        if (!audioFile.exists()) {
            throw new FileNotFoundException("""
                    Path %s does not exist""".formatted(audioFilePath));
        }

        try {
            AudioFileFormat audioFileFormat = AudioSystem.getAudioFileFormat(audioFile);
            int sampleRate = (int) audioFileFormat.getFormat().getSampleRate();
            if (sampleRate == AudioSystem.NOT_SPECIFIED) {
                throw new RuntimeException("Sample rate not specified in the audio file.");
            }
            return sampleRate;
        } catch (UnsupportedAudioFileException|IOException e) {
            throw new RuntimeException(e);
        }
    }
}
