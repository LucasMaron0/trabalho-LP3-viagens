package br.edu.unijui.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileUtils {
    
    public static void saveXmlFile(String xml, String filePath) {
        try {
            File file = new File(filePath);
            File parentDirectory = file.getParentFile();
            if (!parentDirectory.exists()) {
                parentDirectory.mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(xml);
            }
            System.out.println("XML salvo com sucesso em " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao salvar o XML em " + filePath);
        }
    }
    
    public static File selectFile() {
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos XML", "xml");
        fileChooser.setFileFilter(filter);

        JFrame frame = new JFrame("Selecione um arquivo XML");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();                           
            return selectedFile;   
        }
        
        frame.dispose();
        return null;
    }
            
}
