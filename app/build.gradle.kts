plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.youtubedownloader"  // Это можно оставить
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.youtubedownloader"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.core:core-ktx:1.12.0")  // Обновляем с 1.8.0
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.compose.ui:ui:1.5.1")  // Обновляем с 1.5.0
    implementation("androidx.compose.material:material:1.5.1")  // Обновляем с 1.5.0
    implementation("androidx.activity:activity-compose:1.8.1")  // Обновляем с 1.8.0
}

