import org.gradle.api.initialization.resolve.RepositoriesMode  // Добавляем импорт

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "youtube-downloader-android"
include(":app")

