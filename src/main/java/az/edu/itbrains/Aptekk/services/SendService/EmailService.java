package az.edu.itbrains.Aptekk.services.SendService;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    // Yuxarıdakı kodu təmizləmək üçün statik fieldlar yaratdım
    private static final String FROM_EMAIL = "sevxanli77@gmail.com";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");


    // Əvvəlki tapşırıqlardan qalma OTP mail metodu
    public void sendOtpEmail(String toEmail, String otpCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM_EMAIL);
        message.setTo(toEmail);
        message.setSubject("Hesabınızı Təsdiqləyin: Təsdiqləmə Kodu");
        message.setText("Salam,\n\nHesabınızı aktivləşdirmək üçün təsdiqləmə kodunuz: " + otpCode +
                "\n\nBu kod 5 dəqiqə ərzində etibarlıdır. Hörmətlə,\nMelisa Aptek Komandası");
        mailSender.send(message);
    }
}
