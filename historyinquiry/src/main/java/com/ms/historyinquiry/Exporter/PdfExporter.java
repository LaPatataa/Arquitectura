package com.ms.historyinquiry.Exporter;

import com.ms.historyinquiry.Model.Vaccine;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class PdfExporter {

    public static byte @Nullable [] exportToPdf(List<Vaccine> vaccinationHistory) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);
            document.open();
            for (Vaccine vaccine : vaccinationHistory) {
                document.add(new Paragraph(vaccine.toString()));
            }
            document.close();
            return outputStream.toByteArray();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
