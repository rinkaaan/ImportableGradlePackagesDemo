# Importable Gradle Packages Demo

## Setup

1. Configure gradle to use AWS CodeArtifact repository using `aws codeartifact get-authorization-token --domain nguylinc`. Relevant documentation [here](https://docs.aws.amazon.com/codeartifact/latest/ug/maven-gradle.html).
2. Set up importing and dependent packages in same directory.
3. Update gradle.properties to include `codeartifact.auth_token`.
4. Publish imported package to CodeArtifact repository by running `./gradlew publish`.
5. Update importing package's package.json to include the dependent package as a dependency. Include both local path and CodeArtifact dependency but use only one while leaving the other commented out.
6. Run `./gradlew build` in the importing package.

## Usage - npm install

1. Download importing and dependent packages in same directory. Download importing package only if you just want to use version from CodeArtifact.
2. Make sure the namespace:version dependency is commented out and the local path dependency is uncommented in `build.gradle.kts`.
3. Run `./gradlew build` in the importing package.


## Usage - adding new versions

1. On commit you want to use as a new version, run `./gradlew release -Prelease.versionIncrementer=[incrementPatch|incrementMinor|incrementMajor]`
2. Push the new tag to the remote repo.