package util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mailer {
    private static final String FROM_EMAIL = "tanhdttn00014@gmail.com"; // Thay bằng email của bạn

    //    Hướng dẫn tạo App Password cho Gmail:
//    1. Bật Xác minh 2 bước (2-Step Verification) cho tài khoản Gmail của bạn.
//    2. Vào phần Security -> App Passwords (https://myaccount.google.com/apppasswords).
//    3. Tạo một mật khẩu mới (ví dụ đặt tên là "JavaWeb") và copy mã 16 ký tự đó dán vào biến PASSWORD trong file Mailer.java.
    private static final String PASSWORD = "ekyp cund aqjc vrei";      // Thay bằng App Password của bạn

    public static void send(String to, String subject, String body) throws MessagingException {
        // 1. Cấu hình Properties cho Gmail SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // 2. Tạo Session với Authenticator
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
            }
        });

        // 3. Tạo Message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(FROM_EMAIL));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setContent(body, "text/html; charset=utf-8");

        // 4. Gửi mail
        Transport.send(message);
    }
}
