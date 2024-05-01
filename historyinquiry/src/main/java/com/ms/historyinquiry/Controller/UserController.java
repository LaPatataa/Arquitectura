package com.ms.historyinquiry.Controller;

import com.ms.historyinquiry.Exporter.CsvExporter;
import com.ms.historyinquiry.Exporter.PdfExporter;
import com.ms.historyinquiry.Model.User;
import com.ms.historyinquiry.Model.Vaccine;
import com.ms.historyinquiry.Model.VaccineDetails;
import com.ms.historyinquiry.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final CsvExporter csvExporter;
    private final PdfExporter pdfExporter;

    @Autowired
    public UserController(UserService userService, CsvExporter csvExporter, PdfExporter pdfExporter) {
        this.userService = userService;
        this.csvExporter = csvExporter;
        this.pdfExporter = pdfExporter;
    }

    @GetMapping("/filter")
    public ResponseEntity<List<User>> filterHistory(@RequestParam(required = false) String vaccineType,
                                                    @RequestParam(required = false) Date vaccinationDate) {
        List<User> filteredHistory = userService.filterHistory(vaccineType, vaccinationDate);
        return ResponseEntity.ok(filteredHistory);
    }

    @GetMapping("/{userId}/vaccination-history")
    public ResponseEntity<User> getUserVaccinationHistory(@PathVariable Long userId) {
        User user = userService.getUserVaccinationHistory(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{userId}/vaccination-history/export")
        public ResponseEntity<byte[]> exportVaccinationHistory(@PathVariable Long userId, @RequestParam String format) {
        byte[] fileContent = userService.exportVaccinationHistory(userId, format);
        if (fileContent != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("filename", "vaccination_history." + format);
            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}/vaccination-history/{vaccineId}")
    public ResponseEntity<VaccineDetails> getVaccineDetails(@PathVariable Long userId, @PathVariable Long vaccineId) {
        VaccineDetails vaccineDetails = userService.getVaccineDetails(userId, vaccineId);
        if (vaccineDetails != null) {
            return ResponseEntity.ok(vaccineDetails);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
