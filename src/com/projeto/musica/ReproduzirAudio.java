package com.projeto.musica;

import javax.sound.sampled.*;
import java.io.File;

public class ReproduzirAudio {

    public static void tocarAudio(String caminhoAudio) {
        try {
            File audioFile = new File(caminhoAudio);

            if (!audioFile.exists()) {
                System.out.println("Arquivo não encontrado: " + caminhoAudio);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.println("Reproduzindo áudio... Pressione Enter para parar.");
            System.in.read();
            clip.stop();

        } catch (Exception e) {
            System.out.println("Erro ao reproduzir o áudio: " + e.getMessage());
        }
    }
    
    public static void tocarAudioMetade1(String CaminhoAudio) {
    	try {
			File audioFile = new File(CaminhoAudio);
			
			if (!audioFile.exists()) {
				System.out.println("Arquivo não encontrado: " + CaminhoAudio);
				return;
			}
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.setFramePosition((int) (clip.getFormat().getFrameRate() * 22)); // aqui faz a musica comecar no segundo 22 referente ao minuto 00:22
			clip.start();
			Thread.sleep(118000); // na conversao estou aguardando 118 segundos para acabar de 00:22 ate 2:20 pois é primeira metade da musica
			clip.stop();
		} catch (Exception e) {
			System.out.println("Erro ao reproduzir o áudio: " + e.getMessage());
		}
    }
    
    public static void tocarAudioMetade2(String CaminhoAudio) {
    	try {
			File audioFile = new File(CaminhoAudio);
			
			if (!audioFile.exists()) {
				System.out.println("Arquivo não encontrado: " + CaminhoAudio);
				return;
			}
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.setFramePosition((int) (clip.getFormat().getFrameRate() * 140)); // aqui faz a musica comecar no segundo 140 referente ao minuto 2:20
			clip.start();
			Thread.sleep(132000); // na conversao estou aguardando 132 segundos para acabar de 2:20 ate 4:32 pois é segunda metade da musica
			clip.stop();
		} catch (Exception e) {
			System.out.println("Erro ao reproduzir o áudio: " + e.getMessage());
		}
    }
}
