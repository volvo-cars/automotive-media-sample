# Media Sample
[![license](https://img.shields.io/github/license/DAVFoundation/captain-n3m0.svg?style=flat-square)](https://github.com/volvo-cars/automotive-media-sample/blob/main/LICENSE.md)
A media application designed for Android Automotive.

The app is structured to follow Android's Media playback architecture. For an Android automotive app, this means that the app **doesn't have an activity** of its own. The UI is drawn by the system, and the app is responsible for providing the data to display and play in a structured manner. For more information, and resources on how to build media apps, please read the [official Android documentation](https://developer.android.com/guide/topics/media-apps/media-apps-overview).

The project is structured as follows:

#### Media Playback layer
This consists of the media plyback client components and the media service.

#### Domain Layer

Here you will find all the domain models and entities for the application

#### Data access layer
This layer is responsible for sourcing the media to play

#### Common
shared utilities and helpers live here. 

## Running the app
### Prerequisties
* Android studio 4.2+
* Android Automotive emulator
* The computer you're testing the app with should have speakers so you can hear the track playing (obvious, but overlooked sometimes).

Checkout the [Volvo Cars developer portal](https://developer.android.com/guide/topics/media-apps/media-apps-overview) for more information on creating apps for cars.

Once everything is setup, simple clone this repository, build and run the app on the target emulator.
