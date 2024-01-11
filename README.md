# Architecture

Clean Architecture with MVVM pattern in the presentation layer

# Tech Stack

- 100% [Kotlin](https://kotlinlang.org/)
  based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)
  for asynchronous.
- [Hilt](https://dagger.dev/hilt/): for dependency injection.
- MVVM with management state
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs.
- Android Architecture Components
- [Material-Components](https://github.com/material-components/material-components-android) -
  Material design components.
- [ViewBinding](https://developer.android.com/topic/libraries/view-binding) reduces the amount of
  repetitive code you need to get Reference from views and Binds Data to UI.
- [Gson](https://github.com/google/gson) - makes it easy to parse JSON into Kotlin objects.
- [Glide](https://github.com/bumptech/glide) - Loading images from network.
- Facebook Shimmer to handle skeleton logic.
- MediaPlayer API for handling play audio.
- [chucker](https://github.com/ChuckerTeam/chucker) - 🔎 An HTTP inspector for Android & OkHTTP (like
  Charles but on device)

# Testing Libraries

- Junit4
- Mockito
