package com.ms.historyinquiry.Exporter;

import com.ms.historyinquiry.Model.Vaccine;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

@Component
public class CsvExporter {

    public static byte[] exportToCsv(List<Vaccine> vaccinationHistory) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             OutputStreamWriter writer = new OutputStreamWriter(outputStream)) {
            for (Vaccine vaccine : vaccinationHistory) {
                writer.write(vaccine.toString()); // Customize this according to your Vaccine model
                writer.write("\n");
            }
            writer.flush();
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
