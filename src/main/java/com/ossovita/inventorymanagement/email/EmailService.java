package com.ossovita.inventorymanagement.email;

import com.ossovita.inventorymanagement.entity.Product;
import com.ossovita.inventorymanagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
@Slf4j
public class EmailService implements EmailSender {

    private final JavaMailSender mailSender;

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Stock Alert");
            helper.setFrom("stock@storagellc.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }

    public void sendAlertMail(Product product) {
        //dummy user
        User user = User.builder().username("Yasin").userEmail("management@storagellc.com").build();
        send(
                user.getUserEmail(),
                buildEmail(user, product));
    }

    public String buildEmail(User user, Product product) {
        String emailContent = """
                <!DOCTYPE html>
                <html>
                <head>
                \t<title>Mail Title</title>
                </head>
                <body>
                \t<div style="background-color: #f2f2f2; padding: 20px;">
                \t\t<h1>Stock Alert!</h1>
                \t\t<p>Hello %s,</p>
                \t\t<p>This is an notification about your warehouse </p>
                \t\t<p>We send you this email due to your stock count has changed</p>
                \t\t<ul>
                \t\t\t<li>%s product is below the critical stock count: %d</li>
                \t\t</ul>
                \t\t<p>We highly recommend that you check your inventory so that you do not have problems with the stock.</p>
                \t\t<p>Best Regards.</p>
                \t</div>
                </body>
                </html>""";

        return String.format(emailContent, user.getUsername(), product.getProductName(), product.getProductCount());
    }


}
