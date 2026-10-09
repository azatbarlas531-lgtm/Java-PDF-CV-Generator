

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

/**
 • PDFBox kütüphanesi kullanılarak özgeçmiş üreten sınıf.
 • Nesne yönelimli programlama (OOP) ilkelerine uygun tasarlanmıştır.
 */
public class ResumeBuilder {

    private String fullName;
    private String title;
    private String email;
    private String phone;
    private String imagePath;

    public ResumeBuilder(String fullName, String title, String email, String phone, String imagePath) {
        this.fullName = fullName;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.imagePath = imagePath;
    }

    public void generatePdf(String destPath) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

// Başlık (İsim)
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
        contentStream.newLineAtOffset(50, 750);
        contentStream.showText(fullName);
        contentStream.endText();

// Unvan
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.newLineAtOffset(50, 730);
        contentStream.showText(title);
        contentStream.endText();

// İletişim Bilgileri
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 10);
        contentStream.newLineAtOffset(50, 715);
        contentStream.showText("E-posta: " + email + " | Tel: " + phone);
        contentStream.endText();

// Profil Fotoğrafı (Var ise ekle)
        File imgFile = new File(imagePath);
        if (imgFile.exists()) {
            try {
                PDImageXObject image = PDImageXObject.createFromFile(imagePath, document);
                contentStream.drawImage(image, 450, 700, 80, 80);
            } catch (Exception e) {
                System.out.println("Fotoğraf yüklenemedi, fotoğrafsız devam ediliyor.");
            }
        }

// Çizgi
        contentStream.moveTo(50, 685);
        contentStream.lineTo(550, 685);
        contentStream.stroke();

// İş Deneyimleri Başlığı
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
        contentStream.newLineAtOffset(50, 650);
        contentStream.showText("IS DENEYIMLERI");
        contentStream.endText();

// Deneyim 1
        addExperience(contentStream, "1. Kidemli Yazilim Gelistirici - Teknoloji A.S. (2023 - Halen)", 620);
        addExperienceDetail(contentStream, " Java, Spring Boot ve veritabani optimizasyonlari uzerine calismalar.", 605);

// Deneyim 2
        addExperience(contentStream, "2. Yazilim Gelistirme Uzmani - Bilisim Ltd. (2021 - 2023)", 570);
        addExperienceDetail(contentStream, " RESTful API tasarimi ve birim testlerinin (JUnit) yazilmasi.", 555);

// Deneyim 3
        addExperience(contentStream, "3. Junior Java Gelistirici - StartUp A.S. (2020 - 2021)", 520);
        addExperienceDetail(contentStream, " Yazilim bakimi, hata duzeltmeleri ve dokumantasyon hazirligi.", 505);

        contentStream.close();
        document.save(destPath);
        document.close();

        System.out.println("Özgeçmiş PDF'i başarıyla oluşturuldu: " + destPath);
    }

    private void addExperience(PDPageContentStream stream, String titleText, float y) throws IOException {
        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA_BOLD, 11);
        stream.newLineAtOffset(50, y);
        stream.showText(titleText);
        stream.endText();
    }

    private void addExperienceDetail(PDPageContentStream stream, String detailText, float y) throws IOException {
        stream.beginText();
        stream.setFont(PDType1Font.HELVETICA, 10);
        stream.newLineAtOffset(50, y);
        stream.showText(detailText);
        stream.endText();
    }
}