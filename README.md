# LeboncoinApp - Android Application

This is an Android application built using Kotlin and Jetpack Compose, following a clean architecture approach.

## Table of Contents

-   [Project Overview](#project-overview)
-   [Architecture](#architecture)
-   [Modules](#modules)
-   [Libraries and Technologies](#libraries-and-technologies)
    -   [Jetpack Compose](#jetpack-compose)
    -   [Dependency Injection](#dependency-injection)
    -   [Networking](#networking)
    -   [Serialization](#serialization)
    -   [Asynchronous Programming](#asynchronous-programming)
    -   [Data Persistence](#data-persistence)
    -   [Testing](#testing)
    -   [Other Libraries](#other-libraries)
-   [Getting Started](#getting-started)

## Project Overview

LeboncoinApp is an Android application that allows users to browse albums. The application is designed with a focus on clean architecture, modularity, and testability.

## Architecture

This project follows a **Clean Architecture** pattern, which promotes separation of concerns and makes the application more maintainable and testable. The architecture is divided into the following layers:

-   **Presentation Layer (`leboncoin_ui` module):**
    -   Contains the UI components (built with Jetpack Compose), ViewModels, and UI-related logic.
    -   Responsible for displaying data to the user and handling user interactions.
    -   Communicates with the Domain Layer through Use Cases.
-   **Domain Layer (`leboncoin_domain` module):**
    -   Contains the core business logic of the application.
    -   Defines Use Cases, Entities, and Interfaces for Repositories.
    -   Independent of any specific framework or technology.
-   **Data Layer (`leboncoin_data` module):**
    -   Responsible for data retrieval and persistence.
    -   Implements the Repository interfaces defined in the Domain Layer.
    -   Handles data from various sources (network and database).

## Modules

The project is divided into the following modules:

-   **`app`:** The main application module. It assembles the other modules and contains the application entry point.
-   **`leboncoin_ui`:** The presentation layer module. Contains all UI-related code (Jetpack Compose).
-   **`leboncoin_domain`:** The domain layer module. Contains the core business logic.
-   **`leboncoin_data`:** The data layer module. Handles data retrieval and persistence.

## Libraries and Technologies

### Jetpack Compose

-   **`androidx.compose.ui:ui`**: Core UI components.
-   **`androidx.compose.material3:material3`**: Material Design 3 components.
-   **`androidx.compose.ui:ui-tooling-preview`**: For previewing composables.
-   **`androidx.compose.ui:ui-test-junit4`**: For UI testing.
-   **`androidx.activity:activity-compose`**: Integration with Activity.
-   **`androidx.lifecycle:lifecycle-viewmodel-compose`**: ViewModel integration.
-   **`androidx.lifecycle:lifecycle-runtime-compose`**: Lifecycle integration.
-   **`androidx.hilt:hilt-navigation-compose`**: Hilt integration.

### Dependency Injection

-   **`com.google.dagger:hilt-android`**: For dependency injection.
-   **`com.google.dagger:hilt-android-compiler`**: For Hilt code generation.
-   **`com.google.dagger:hilt-android-gradle-plugin`**: Hilt gradle plugin.

### Networking

-   **`io.ktor:ktor-client-core`**: Core HTTP client.
-   **`io.ktor:ktor-client-content-negotiation`**: For content negotiation.
-   **`io.ktor:ktor-serialization-kotlinx-json`**: For JSON serialization.

### Serialization

-   **`org.jetbrains.kotlinx:kotlinx-serialization-json`**: For JSON serialization/deserialization.
-   **`org.jetbrains.kotlin:kotlin-serialization`**: Kotlin serialization plugin.

### Asynchronous Programming

-   **`kotlinx.coroutines`**: For coroutines and asynchronous programming.
-   **`androidx.lifecycle:lifecycle-runtime-ktx`**: For coroutines integration with lifecycle.

### Data Persistence

-   **`androidx.room:room-ktx`**: For Room database.
-   **`androidx.room:room-compiler`**: For Room code generation.

### Testing

-   **`junit:junit`**: For unit testing.
-   **`androidx.test.ext:junit`**: For Android instrumentation testing.
-   **`androidx.test.espresso:espresso-core`**: For UI testing.

### Other Libraries

-   **`androidx.core:core-ktx`**: Kotlin extensions for Android.
-   **`androidx.appcompat:appcompat`**: For backward compatibility.
-   **`com.google.android.material:material`**: Material Design components.
- **`io.coil-kt:coil-compose`**: For image loading.

## Getting Started

1.  Clone the repository: `git clone <repository-url>`
2.  Open the project in Android Studio.
3.  Build and run the project.
