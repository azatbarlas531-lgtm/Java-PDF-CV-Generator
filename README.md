
Java ile PDF Özgeçmiş (CV) Oluşturucu

Bu proje, Java dili ve Apache PDFBox kütüphanesi kullanılarak dinamik şekilde PDF formatında özgeçmiş (CV) üreten bir konsol uygulamasıdır. Ödev isterlerine uygun olarak Nesne Yönelimli Programlama (OOP) prensipleriyle geliştirilmiştir.

Kullanılan Bileşenler ve Nesneler

Projede tercih edilen temel nesneler ve kullanım amaçları şunlardır:

• ResumeBuilder Sınıfı: PDF oluşturma iş mantığını main metodundan ayırmak ve kapsülleme (Encapsulation) sağlamak amacıyla oluşturulmuştur.
• PDDocument: PDF belgesinin bellekteki temsilcisidir, yeni sayfalar eklemek ve belgeyi diske kaydetmek için kullanılır.
• PDPage: PDF belgesinin tekil sayfalarını temsil eder.
• PDPageContentStream: Sayfa üzerine metin, çizgi ve görsel eklemek için kullanılan grafik/akış nesnesidir.
• PDType1Font: Metinlerin font (Helvetica, Helvetica-Bold vb.) ve boyut ayarlarını yönetmek için tercih edilmiştir.
• PDImageXObject: Profil fotoğrafını disk üzerinden okuyup PDF sayfasına çizdirmek için kullanılmıştır.
