# Importable Gradle Packages Demo

## Setup

1. Set up importing and dependent packages in same directory.
2. Update importing package's package.json to include the dependent package as a dependency. Include both local path and namespace:version but use only one while leaving the other commented out. Also set up GitHub Gradle registry and update gradle.properties to include `gpr.user` and `gpr.key`.
3. Publish imported package to GitHub Gradle registry by running `./gradlew publish`. This pushes the built JAR to e.g. `https://maven.pkg.github.com/rinkaaan/ImportablePackage/com/nguylinc/importablepackage/0.1.0/importablepackage-0.1.0.jar`.
4. Run `./gradlew build` in the importing package.

## Usage - npm install

1. Download importing and dependent packages in same directory. Download importing package only if you just want to use version from git repo url.
2. Make sure the namespace:version dependency is commented out and the local path dependency is uncommented in `build.gradle.kts`.
3. Run `./gradlew build` in the importing package.


## Usage - adding new versions

1. On commit you want to use as a new version, run `./gradlew release -Prelease.versionIncrementer=[incrementPatch|incrementMinor|incrementMajor]`
2. Push the new tag to the remote repo.