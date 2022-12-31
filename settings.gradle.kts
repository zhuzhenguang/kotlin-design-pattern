@file:Suppress("UnstableApiUsage")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("junit", "org.junit.jupiter:junit-jupiter-params:5.9.1")
            library("logback", "ch.qos.logback:logback-classic:1.4.5")
            library("assertj", "org.assertj:assertj-core:3.23.1")
            library("mockito", "org.mockito:mockito-core:4.10.0")
            bundle("test", listOf("junit", "assertj", "mockito"))
        }
    }
}

rootProject.name = "kotlin-design-patterns"

include("abstract-document")
include("abstract-factory")
include("active-object")
include("acyclic-visitor")
include("visitor")
