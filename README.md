# api-geteway
 
Tools tambahan menggunakan docker yang berfungsi untuk tempat membuat container dari database
agar dapat dengan mudah jika di mau menjalankan di device yang berbeda dengan konfigurasi yang sama.

Untuk proses menjalankan aplikasi :
1. Open terminal dan masuk ke file yang memiliki docker-compose.yml
2. Jalankan printah **docker compose up --build**
3. Jika pada PC/laptop yang di gunakan tidak memiliki docker bisa menjalakan data local dan membuat
   data base dengan nama **db_product_management** dan **db_user_management** dan jangan lupa memperhatikan
   port data base local yang digunakan
5. Selanjutnya dapat melakukan clean intall maven terlebih dahulu untuk mendownload dependency yang tersedia.
6. Selanjutnya dapat melakukan konfigurasi untuk connect ke data base.
7. Setelah data base connect selanjutnya dapat menajalakan aplikasi dan secara automatis tabel akan terbentuk.
8. Aplikasi dapat di gunakan seperti biasa.

note :
untuk detail penggunakan dan proses menjalankan aplikasi dapat dilihat pada Demo Documentation API-gateway.pdf 
