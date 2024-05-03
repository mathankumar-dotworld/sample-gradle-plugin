plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.publish)
    signing
}

group = "dev.dotworld.blescanner.plugin"
version = libs.versions.sampleplugin.get()

gradlePlugin {
    website.set("https://github.com/example/example")
    vcsUrl.set("https://github.com/example/example")
    plugins {
        create("plugin") {
            id = "dev.dotworld.blescanner.plugin"
            displayName = "BLE Scanner Plugin"
            description = "BLE Scanner Plugin"
            tags.set(listOf("example"))
            implementationClass = "dev.dotworld.GreetingPlugin"
        }
    }
}

kotlin {
    jvmToolchain(11)
}

java {
    withSourcesJar()
    withJavadocJar()
}

signing {
    useInMemoryPgpKeys(
        providers.gradleProperty("signingKey").orNull,
        providers.gradleProperty("signingPassword").orNull
    )
}

/*
// For GItHub Actions CI signing
if (providers.environmentVariable("CI").isPresent) {
    apply(plugin = "signing")
    extensions.configure<SigningExtension> {
        useInMemoryPgpKeys(
            providers.environmentVariable("SIGNING_PGP_KEY").orNull,
            providers.environmentVariable("SIGNING_PGP_PASSWORD").orNull
        )
    }
}
 */
