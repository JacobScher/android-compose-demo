# Android Compose Demo

A clean, modern Android starter project built with the latest recommended stack (as of mid-2026):

- **Kotlin 2.3.21**
- **Jetpack Compose** + **Material 3** (Compose BOM `2026.06.00`)
- **Android Gradle Plugin 9.3.0** + Gradle 9.5+
- **compileSdk / targetSdk 37**
- **minSdk 26**
- Unidirectional data flow with `ViewModel` + `StateFlow`
- Unit tests (JUnit + coroutines-test)
- Compose UI tests (with `testTag`s)

## Project structure

```
app/
├── src/main/java/com/jacobscher/androidcomposedemo/
│   ├── MainActivity.kt
│   ├── CounterViewModel.kt
│   └── ui/
│       ├── CounterScreen.kt
│       └── theme/          # Material 3 theme (dynamic color on Android 12+)
├── src/test/...            # Unit tests for ViewModel
└── src/androidTest/...     # Instrumented Compose UI tests
```

## Getting started

1. Open the project in **Android Studio** (Otter / 2026.x or newer recommended).
2. Let Gradle sync (it will download the required dependencies).
3. Run on an emulator or device (API 26+).

> **Note:** The launcher icon uses a system drawable for simplicity. In Android Studio you can right-click `res` → New → Image Asset to generate proper adaptive icons.

## Running tests

### Unit tests (JVM)
```bash
./gradlew test
```
or in Android Studio: right-click the `test` source set → Run tests.

### Instrumented / Compose UI tests
```bash
./gradlew connectedAndroidTest
```
Requires a connected device or running emulator.

## What this demonstrates

- Modern project setup with **Gradle Version Catalogs** (`gradle/libs.versions.toml`)
- Compose Compiler Gradle plugin (no longer using the old `composeOptions`)
- Edge-to-edge + Material 3 with dynamic color support
- Clean separation: UI (Composable) ↔ ViewModel (state + intents)
- Proper testing of StateFlow and Compose nodes via `testTag`

## Next steps you might want

- Add Navigation Compose
- Introduce Hilt or manual DI
- Room / DataStore for persistence
- More complex screens or a real feature (todo list, settings, etc.)

Feel free to open issues or request enhancements!

---
Created for JacobScher via Grok.
