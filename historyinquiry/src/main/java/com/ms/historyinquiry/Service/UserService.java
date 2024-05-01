package com.ms.historyinquiry.Service;

import com.ms.historyinquiry.Exporter.PdfExporter;
import com.ms.historyinquiry.Exporter.CsvExporter;
import com.ms.historyinquiry.Model.User;
import com.ms.historyinquiry.Model.Vaccine;
import com.ms.historyinquiry.Model.VaccineDetails;
import com.ms.historyinquiry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CsvExporter csvExporter;
    private final PdfExporter pdfExporter;

    @Autowired
    public UserService(UserRepository userRepository, CsvExporter csvExporter, PdfExporter pdfExporter) {
        this.userRepository = userRepository;
        this.csvExporter = csvExporter;
        this.pdfExporter = pdfExporter;
    }

    public byte[] exportVaccinationHistory(Long userId, String format) {
        List<Vaccine> vaccinationHistory = userRepository.findVaccinationHistoryByUserId(userId);
        if (vaccinationHistory != null) {
            if ("pdf".equalsIgnoreCase(format)) {
                return pdfExporter.exportToPdf(vaccinationHistory);
            } else if ("csv".equalsIgnoreCase(format)) {
                return csvExporter.exportToCsv(vaccinationHistory);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    public List<User> filterHistory(String vaccineType, Date vaccinationDate) {
        if (vaccineType != null && vaccinationDate != null) {
            return userRepository.findByVaccineTypeAndVaccinationDate(vaccineType, vaccinationDate);
        } else if (vaccineType != null) {
            return userRepository.findByVaccineType(vaccineType);
        } else if (vaccinationDate != null) {
            return userRepository.findByVaccinationDate(vaccinationDate);
        } else {
            return userRepository.findAll();
        }
    }

    public VaccineDetails getVaccineDetails(Long userId, Long vaccineId) {
        return userRepository.findVaccineDetails(userId, vaccineId);
    }

    public User getUserVaccinationHistory(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }


    public List<Vaccine> getVaccinationHistory(Long userId) {
        return userRepository.findVaccinationHistoryByUserId(userId);
    }
}
