# **Crick_Bustor**

**Crick_Bustor** is a **Kotlin Multiplatform (KMP)** cricket dashboard application that fetches **match details, location, and weather**. This app supports both **Android and iOS**, leveraging **Compose Multiplatform (CMP)** for UI and **Ktor** for network requests.

## 📌 Features

- 🏏 **Live Match Updates** – Fetch real-time match details.
- 📍 **Match Location** – Retrieve match venue details.
- 🌦 **Weather Information** – Display live weather updates for match locations.
- 🔄 **Cross-Platform Support** – Runs seamlessly on **Android and iOS** using **KMP**.
- 🚀 **Modern UI with Compose Multiplatform**.
- 🔌 **API Integration via Ktor**.

## ScreenShot
![screenshot](https://github.com/AmulPandey/Crick_Bustor/blob/temp/screenshot.jpeg)

## 🏗️ Project Structure

```
Crick_Bustor/
│── composeApp/   # Shared Compose Multiplatform Code
│   ├── commonMain/  # Common logic across platforms
│   ├── androidMain/ # Android-specific implementations
│   ├── iosMain/     # iOS-specific implementations
│── iosApp/        # iOS-specific entry point (SwiftUI code)
│── androidApp/    # Android-specific entry point
```

## 🛠️ Tech Stack

- **Language**: Kotlin (Multiplatform)
- **UI Framework**: Compose Multiplatform
- **Networking**: Ktor Client
- **Dependency Injection**: Koin (optional)
- **State Management**: ViewModel, Flow

## 🔧 Setup & Installation

### Prerequisites
- Install **Android Studio** with Kotlin Multiplatform plugin.
- Install **Xcode** (for iOS development).

### Running on Android
```sh
./gradlew androidApp:installDebug
```

### Running on iOS
```sh
cd iosApp
pod install  # Ensure CocoaPods is installed
open iosApp.xcworkspace  # Open in Xcode and run
```

## 🤝 Contributing

Contributions are welcome! Feel free to **open issues or submit PRs**.

## 📩 Contact

For any queries, reach out to **[amulpandey007@gmail.com](mailto:amulpandey007@gmail.com)**.

---

Learn more about **[Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)**.

