package az.edu.itbrains.Aptekk.repository;

import az.edu.itbrains.Aptekk.models.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, Long> {

    // 🏆 OTP TƏSDİQLƏNMƏSİ ÜÇÜN: Həm email, həm də kodu tələb edən JPQL metodu.
    // Spring Data-nın avtomatik metod adlandırma mexanizminin yaratdığı çaşqınlığı ləğv edir.
    @Query("SELECT o FROM Otp o WHERE o.userEmail = :email AND o.otpCode = :code")
    Optional<Otp> findByEmailAndCodeForValidation(@Param("email") String userEmail, @Param("code") String otpCode);

    // Yalnız email vasitəsilə axtarış: Kod göndərməzdən əvvəl köhnə qeydi silmək üçün lazımdır.
    Optional<Otp> findByUserEmail(String userEmail);
}