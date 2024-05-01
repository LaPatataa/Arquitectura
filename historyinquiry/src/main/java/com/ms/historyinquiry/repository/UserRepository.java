package com.ms.historyinquiry.repository;

import com.ms.historyinquiry.Model.User;
import com.ms.historyinquiry.Model.Vaccine;
import com.ms.historyinquiry.Model.VaccineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp; // Importa la clase Timestamp
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByVaccineType(String vaccineType);

    @Query("SELECT v FROM Vaccine v WHERE v.id = :userId AND v.id = :vaccineId")
    List<Vaccine> findVaccinationHistoryByUserIdAndVaccineId(@Param("userId") Long userId, @Param("vaccineId") Long vaccineId);

    @Query("SELECT v FROM Vaccine v WHERE v.user.id = :userId")
    List<Vaccine> findVaccinationHistoryByUserId(@Param("userId") Long userId);
    List<User> findByVaccinationDate(Date vaccinationDate);
    @Query("SELECT new com.ms.historyinquiry.Model.VaccineDetails(v.name, v.manufacturer, v.dosesAdministered) " +
            "FROM Vaccine v WHERE v.user.id = :userId AND v.id = :vaccineId")
    VaccineDetails findVaccineDetails(@Param("userId") Long userId, @Param("vaccineId") Long vaccineId);

    List<User> findByVaccineTypeAndVaccinationDate(String vaccineType, Date vaccinationDate);

}
