# Overview

I'm using Kotlin. Everything should be configured properly in the manifest and app gradle. I'm using a minimum SDK of 26 with a target of 29 and the app requires internet permissions. Nothing fancy here for the UI elements.
You'll just be plopped directly into the fragment that contains the recycler view. I only added one custom gray color to use as the fragment background for better visual separation between cards. Otherwise,
I'm going for MVVM for the architecture.

# Libraries

I'm using RxJava 3, Retrofit, Gson, View Model, Live Data, and Card View for this project. I'm also making use of Kotlin synthetics to reduce the amount of boilerplate code.

# Notes

I left a fair amount of Log messages around points of interest (for me). I can obviously delete these types of things in a larger scale, more professional setting if it's not part of style guidelines/preferences. I conducted my testing
on the Android Studio Emulator with a Pixel 3 running API 29.