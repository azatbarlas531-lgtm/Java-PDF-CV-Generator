

public class Main {
    public static void main(String[] args) {
        try {
            String photoPath = "profile.jpg";
            String pdfOutputPath = "Ozgecmis.pdf";

            ResumeBuilder builder = new ResumeBuilder(
                    "Azat Barlas",
                    "Yazilim Muhendisi",
                    "azatbarlas531@gmail.com",
                    "+90 541 550 9202",
                    photoPath
            );

            builder.generatePdf(pdfOutputPath);

        } catch (Exception e) {
            System.err.println("PDF oluşturulurken bir hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }
}