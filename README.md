# 📱 Account Manager Pro

## 🚀 Overview
This dynamic Android application showcases seamless API integration, robust data storage with Room Database, and efficient image handling — all wrapped in a sleek and modern UI.

## 🔥 Features at a Glance
### 🌐 API Integration
✅ **Fetch Accounts:** Pulls data from:
`https://fssservices.bookxpert.co/api/Fillaccounts/nadc/2024-2025`
✅ **Display Accounts:** Presents the data in a user-friendly RecyclerView.

### 📄 PDF Viewer
📂 Effortlessly view PDF reports with Android's built-in PDF viewer or a powerful third-party tool.
- Report Link: [Balance Sheet PDF](https://fssservices.bookxpert.co/GeneratedPDF/Companies/nadc/2024-2025/BalanceSheet.pdf)

### 📸 Image Handling
🖼️ **Capture Images** directly from the camera.
🖼️ **Select Images** from your gallery.
🖼️ **Display Images** with style in an ImageView.

### 🗃️ Room Database Magic
💾 **Save Accounts:** Securely stores account details for offline access.
📝 **Alternate Names:** Add alternate names (e.g., "Rammohan" ➔ "Mohan").
🎙️ **Speech-to-Text:** Easily input alternate names using voice commands.
🛠️ **Update & Delete:** Modify or remove accounts directly from the UI.

## 🛠️ Tech Stack
- **Kotlin** for robust coding
- **MVVM Architecture** for clean code
- **Retrofit** for efficient API calls
- **Room Database** for data persistence
- **Glide/Coil** for effortless image loading
- **SpeechRecognizer** for voice input support

## 🔒 Permissions Required
```xml
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.CAMERA"/>
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```

## 📲 Installation Guide
1. Clone the repository:
   ```sh
   git clone https://github.com/Anureddykv/AccountMangeemtPro.git
   ```
2. Open the project in Android Studio.
3. Sync Gradle to fetch dependencies.
4. Run the app on your preferred device or emulator.

## 🎯 How to Use
✅ Tap **"Fetch Accounts"** to retrieve account data.
✅ Click **"View Report"** for a PDF view.
✅ Use the **"Mic"** icon to add alternate names via voice.
✅ Hit **"Add Image"** to capture or select an image.
✅ Swipe left/right to **edit** or **delete** accounts.

## 📦 Deliverables
✅ **Demo APK:** [Download APK](https://github.com/Anureddykv/AccountMangeemtPro/releases/latest)

✅ **Source Code:** Available on GitHub
✅ **APK File:** Included for easy installation

## 🤝 Need Help?
Have questions? Reach out via email or drop an issue on GitHub. Let's build something amazing together! 🚀

