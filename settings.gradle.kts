pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "EchoJournal"
include(":app")
include(":mood-entries-list")
include(":mood-record-audio")
include(":create-mood-entry")
include(":mood-settings")
include(":core:ui")
include(":core:designsystem")
include(":core:domain")
include(":core:data")
