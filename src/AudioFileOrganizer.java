import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFileIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioFileOrganizer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java AudioFileOrganizer <directory>");
            return;
        }

        File directory = new File(args[0]);
        if (!directory.isDirectory()) {
            System.out.println("Error: " + args[0] + " is not a directory");
            return;
        }

        // Create folders for noise levels
        File highNoiseFolder = new File(directory, "high");
        File lowNoiseFolder = new File(directory, "low");
        File moderateNoiseFolder = new File(directory, "moderate");

        // Create a list of audio files in the directory
        File[] audioFiles = directory.listFiles((dir, name) -> name.endsWith(".wav") || name.endsWith(".mp3"));

        // Analyze each audio file
        for (File audioFile : audioFiles) {
            try {
                AudioInputStream audioInputStream = AudioFileIO.openInputStream(audioFile);
                AudioFileFormat fileFormat = audioInputStream.getFormat();

                // Use FFmpeg to analyze the audio file and get its noise level
                Process process = new ProcessBuilder("ffmpeg", "-i", audioFile.getAbsolutePath(), "-nostats", "-n", "-f", "null", "/dev/null").start();
                int exitCode = process.waitFor();

                if (exitCode != 0) {
                    System.out.println("Error analyzing " + audioFile.getName());
                    continue;
                }

                // Parse the FFmpeg output to get the noise level
                String output = new String(process.getInputStream().readAllBytes());
                String noiseLevel = parseNoiseLevel(output);

                // Move the audio file to the appropriate folder based on its noise level
                File destinationFolder = getDestinationFolder(noiseLevel);
                audioFile.renameTo(new File(destinationFolder, audioFile.getName()));

            } catch (UnsupportedAudioFileException | IOException | InterruptedException ex) {
                Logger.getLogger(AudioFileOrganizer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static String parseNoiseLevel(String ffmpegOutput) {
        // TO DO: Implement a method to parse the FFmpeg output and extract the noise level
        // You can use a regular expression to extract the noise level from the output
        return ""; // Return a default value for now
    }

    private static File getDestinationFolder(String noiseLevel) {
        if (noiseLevel.equalsIgnoreCase("high")) {
            return new File(directory, "high");
        } else if (noiseLevel.equalsIgnoreCase("low")) {
            return new File(directory, "low");
        } else {
            return new File(directory, "moderate");
        }
    }
}