# Rest-Assured Dummy API Testing

## Description
Program ini digunakan untuk menguji API yang disediakan oleh DummyAPI menggunakan Rest-Assured. Program ini memungkinkan pengguna untuk melakukan pengujian terhadap beberapa endpoint API seperti Get User by ID, Create User, Update User, dan Delete User.

## Technologies & Tools 
* **Repository Management** : Git
* **IDE** : Visual Studio Code
* **CLI** : Command Prompt (CMD) / Powershell (Windows)
* **Build Tools** : [![Maven](https://img.shields.io/badge/Maven-3.8.3-blue)](https://maven.apache.org/)
  Kami menggunakan Apache Maven untuk mengelola proyek Java kami secara lebih efisien. 
  Versi Maven yang kami gunakan adalah 3.8.3. 
  Untuk informasi lebih lanjut -> [Kunjungi situs Maven](https://maven.apache.org/).
* **Programming Language** : [![Java](https://img.shields.io/badge/Java-17.0.10%202024--01--16%20LTS-red)](https://www.java.com/)
  Dalam pengembangan aplikasi ini, kami menggunakan bahasa pemrograman Java. 
  Kami memilih bahasa pemrograman ini karena memudahkan dari segi pengembangan dan fungsionalitas yang diharapkan. Banyaknya referensi yang dapat kami gunakan juga menjadi faktor untuk penentuan penggunaan bahasa pemrograman ini.
  Versi java yang kami gunakan adalah Java 17.0.10 2024-01-16 LTS. 
  Untuk informasi lebih lanjut -> [Kunjungi situs Java](https://www.java.com/) untuk informasi lebih lanjut.

## Instalasi
1. Lakukan instalasi Java JDK dengan versi minimal 17 atau versi terbaru (disarankan menggunakan versi 17 atau 21) dari [halaman resmi Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. Pastikan instalasi JDK berhasil dengan menjalankan perintah `java --version` di terminal atau command prompt Anda.
3. Lakukan instalasi Maven (versi 3.8.3) dari [situs web Maven](https://maven.apache.org/download.cgi).
4. Setelah mengunduh dan menginstal Maven, pastikan Anda menambahkan Maven ke dalam variabel lingkungan PATH Anda. Instruksi untuk melakukan hal ini dapat ditemukan di [situs web Maven](https://maven.apache.org/install.html).
5. Pastikan instalasi Maven berhasil dengan menjalankan perintah `mvn --version` di terminal atau command prompt Anda.
6. Jika sudah berhasil, clone repositori ini ke perangkat Anda dengan menjalankan perintah berikut di terminal atau command prompt:
```
git clone https://github.com/frddyy/b11-rest-assured-dummy-api.git
```
7. Buka proyek yang telah di-clone menggunakan IDE favorit Anda. Kami merekomendasikan Visual Studio Code untuk kemudahan penggunaan.
8. Anda sekarang siap untuk mulai mengembangkan dan menjalankan pengujian pada proyek ini.

## Dependency Configuration
* **API Testing** : [![Rest-Assured](https://img.shields.io/badge/Rest--Assured-5.1.1-blue)](https://rest-assured.io/)
  Rest-Assured digunakan untuk melakukan pengujian otomatis terhadap API. 
  Versi Rest-Assured yang kami gunakan adalah 5.1.1.
  Untuk informasi lebih lanjut -> [Kunjungi situs Rest-Assured](https://rest-assured.io/) untuk informasi lebih lanjut.

* **Test Runner** : [![TestNG](https://img.shields.io/badge/TestNG-7.5-green)](https://testng.org/)
  TestNG digunakan sebagai test runner dan framework pengujian dalam proyek ini. 
  Versi TestNG yang digunakan adalah 7.5. 
  Untuk informasi lebih lanjut -> [Kunjungi situs TestNG](https://testng.org/) untuk informasi lebih lanjut.

* **Logging** : [![SLF4J API](https://img.shields.io/badge/SLF4J%20API-1.7.5-orange)](http://www.slf4j.org/)
  SLF4J API digunakan untuk logging dalam proyek ini, dengan implementasi Logback.
  Versi SLF4J API yang digunakan adalah 1.7.5. 
  Untuk informasi lebih lanjut -> [Kunjungi situs SLF4J](http://www.slf4j.org/) untuk informasi lebih lanjut.

## Project Structure
```
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── restassured/
│   │   │           └── dummyapi/
│   │   │               └── App.java
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── restassured/
│   │               └── dummyapi/
│   │                   ├── CreateUserTests.java
│   │                   ├── DeleteUserApiTests.java
│   │                   ├── GetUserByIdApiTests.java
│   │                   └── UpdateUserTests.java
│   ├── resources/
│   │   └── logback.xml
│   │   └── testng.xml
├── target/
│   └── classes/
│   └── generated-sources/
│   └── maven-status/
│   └── surefire-reports/
│   └── test-classes/
├── pom.xml
├── README.md
└── .gitignore
```

- **src/test/java/com/restassured/dummyapi**: Berisi script pengujian.
- **src/test/resources**: Berisi konfigurasi Logback dan TestNG.
- **target/surefire-reports/index.html**: Berisi laporan pengujian dalam format HTML.

## How to Run / Test Runner
1. Buka terminal atau command prompt dan arahkan ke direktori proyek.
```
cd b11-rest-assured-dummy-api
```
2. Untuk menginstal proyek, jalankan perintah `mvn install`.
3. Jalankan perintah `mvn test` untuk menjalankan pengujian.
4. Setelah pengujian selesai, laporan pengujian akan di-generate. Untuk mengakses laporan pengujian dalam format HTML, buka file berikut menggunakan browser web (Jika menggunakan VSCode bisa memanfaatkan fitur "Open with Live Server"): `target/surefire-reports/index.html`

## Fitur Software Under Test

Proyek ini menguji API DummyAPI dengan menggunakan beberapa fitur utama, diantaranya:

| Fitur            | Deskripsi                                 | Cara Request                                   |
|------------------|-------------------------------------------|------------------------------------------------|
| Get User by ID   | Mendapatkan informasi pengguna berdasarkan ID pengguna. | `GET /user/:id`                           |
| Create User      | Membuat pengguna baru.                    | `POST /user/create` dengan body data pengguna baru.    |
| Update User      | Memperbarui informasi pengguna yang ada.  | `PUT /user/:id` dengan body data yang diperbarui. |
| Delete User      | Menghapus pengguna dari sistem.           | `DELETE /user/:id`                        |

Dokumentasi lengkap untuk API DummyAPI dapat ditemukan di [sini](https://dummyapi.io/docs/user).


# Test Cases

| No. | Fitur Pengujian            | Test Case                                  | Tujuan Pengujian                               |
|-----|----------------------------|--------------------------------------------|------------------------------------------------|
| 1   | CreateUserTests.java      | - TC4 Create user dengan semua field terisi dengan tipe data yang valid (PASS)       | Memastikan bahwa pengguna dapat membuat pengguna baru dengan semua informasi yang valid. |
|     |                            | - TC12 Create user dengan semua field terisi kecuali field email (PASS)             | Memastikan bahwa pengguna tidak dapat membuat pengguna baru tanpa mengisi email. |
|    |                            | - TC13 Create user dengan semua field diisi kosong (PASS)                            | Memastikan bahwa pengguna tidak dap at membuat pengguna baru dengan mengosongkan semua field. |
|     |                            | - TC29 Create user dengan field picture diisi selain format URL (FAILED)             | Memastikan bahwa pengguna tidak dapat membuat pengguna baru dengan URL gambar yang tidak valid. |
|     |                            | - TC54 Create user dengan field title diisi selain "mr,ms,mrs,miss,dr" dan kosong (PASS) | Memastikan bahwa pengguna tidak dapat membuat pengguna baru dengan judul yang tidak valid. |
| 2   | DeleteUserApiTests.java   | - TC1 DeleteUser - App Id Unregistered       | Memastikan bahwa pengguna tidak dapat menghapus pengguna dengan app-id yang tidak terdaftar. |
|     |                            | - TC2 DeleteUser - App Id Invalid Format     | Memastikan bahwa pengguna tidak dapat menghapus pengguna dengan app-id yang memiliki format yang tidak valid. |
|     |                            | - TC3 DeleteUser - App Id Not Filled         | Memastikan bahwa pengguna tidak dapat menghapus pengguna tanpa app-id. |
|     |                            | - TC4 DeleteUser - User and App Id Valid Registered (PASS) | Memastikan bahwa pengguna dapat menghapus pengguna dengan id pengguna dan app-id yang valid. |
|     |                            | - TC5 DeleteUser - User Id Valid but Unregistered | Memastikan bahwa pengguna tidak dapat menghapus pengguna dengan id pengguna yang valid tetapi tidak terdaftar. |
| 3   | GetUserByIdApiTests.java | - TC2 GetUserById - App Id Invalid Format    | Memastikan bahwa pengguna tidak dapat mendapatkan pengguna berdasarkan id dengan app-id yang memiliki format yang tidak valid. |
|     |                            | - TC3 GetUserById - App Id Not Filled        | Memastikan bahwa pengguna tidak dapat mendapatkan pengguna berdasarkan id tanpa app-id. |
|     |                            | - TC4 GetUserById - User Id & AppId Valid    | Memastikan bahwa pengguna dapat mendapatkan pengguna berdasarkan id dengan id pengguna dan app-id yang valid. |
|     |                            | - TC5 GetUserById - User Id Valid but Unregistered | Memastikan bahwa pengguna tidak dapat mendapatkan pengguna dengan id pengguna yang valid tetapi tidak terdaftar. |
|     |                            | - TC6 GetUserById - User Id Invalid          | Memastikan bahwa pengguna tidak dapat mendapatkan pengguna dengan id pengguna yang tidak valid. |
| 4   | UpdateUserTests.java      | - TC01 Update user by Id dengan header app-id diisi dan tidak terdaftar di sistem        | Memastikan bahwa pengguna tidak dapat memperbarui pengguna dengan app-id yang tidak valid. |
|     |                            | - TC04 Update user by Id dengan semua field terisi dengan data yang valid     | Memastikan bahwa pengguna dapat memperbarui pengguna dengan semua informasi yang valid. |
|     |                            | - TC33 Update user by Id dengan field firstName diisi dengan > 2 dan < 50 huruf| Memastikan bahwa pengguna dapat memperbarui nama depan pengguna dengan rentang yang valid. |
|     |                            | - TC40 Update user by Id dengan field gender diisi selain string     | Memastikan bahwa pengguna tidak dapat memperbarui jenis kelamin pengguna dengan tipe data yang tidak valid. |
|     |                            | - TC64 Update user by Id dengan field email diubah           | Memastikan bahwa pengguna tidak dapat memperbarui email pengguna dengan email yang valid. |


## Author 
* Aini Diah Rahmawati [211524033]
* Ghessa Theniana - [211524042]
* Mochamad Ferdy Fauzan - [211524049]










