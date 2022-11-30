# Description
Multi-module demo app that gets data from a RSS Url's.

# Technologies
- Compose
- Clean Architechure + Modularization + MVI
- Room 
- Retrofit
- Kotlin Coroutines
- JetPack (Material 3, ViewModel and etc.)

# Module Design

| Module name        | Type                 | Description                                                      |
| -------------      | -------------        | -------------                                                    |
| [app](/app/)                | Android Application  | MainActivity, BaseApplication, Hilt.                |
| [core](/core/)               | Android Library  | Core business models and classes.                                |
| [rssData](/rss/data/)    | Android Library  | Data-sources (network and cache), repositories and Hilt for the RSS Module.            |
| [rssDomain  ](/rss/Domain/)        | Android Library  | Use-cases, Domain models and classes for the RSS Module.                   |
| [rss-ui-feeds](/rss/ui-feeds/)        | Android Library      | UI components for the HeroList screen.                           |
| [rss-ui-stories](/rss/ui-stories/)      | Android Library      | UI components for the HeroDetail screen.                         |
| [constants](/constants/)          | Java/Kotlin Library  | Random constants.                                                |
| [android-components](/android-components/)         | Android Library      | Common Composables,Theme, and Android Classes.      
