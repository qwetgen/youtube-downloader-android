plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.youtubedownloader"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.youtubedownloader"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    composeOptions {  // ✅ Перенесено внутрь `android {}`
        kotlinCompilerExtensionVersion = "1.6.2"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")

    // Используем одинаковую версию для всех компонентов Compose
    val composeVersion = "1.6.2" // Или последняя стабильная

    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.compose.runtime:runtime:$composeVersion")
}

