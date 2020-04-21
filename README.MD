Projeyi Selenium ve TesNG kullanarak tamamladım. Ama güvenlik nedeni ile karşılaştığım sorunlar yüzünden tamamlanamadı.Yazdığım kadarı ile iletmek istedim.

Proje testng.xml dosyasından Run edilmeli.Bu dosyada browserı parametrik olarak gönderiyoruz. Value değerine firefox yazarsak firefox,chrome yazarsak chrme browserı çalıştırıyor.
BaseTestClass'da TakeScreenShot methodu hata alan adımlarda screenshot alır  ve bunları proje dosyalarında yer alan Screenshot dosyasına atar.
Chrome ve firefox driverlar proje dosyası altında yer alan Drivers dosyasında bulunur ayrıca kurulum gerektirmeden direk çalışır.