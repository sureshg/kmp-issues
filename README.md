KMP Issues Repo
----------
[![OpenJDK Version][java_img]][java_url]
[![Kotlin release][kt_img]][kt_url]

## Run on MacOS (`15.4`)

  ```bash
  # Use Java 21
  $ sdk i java 21.0.6-zulu
  $ git clone https://github.com/sureshg/kmp-issues
  $ cd kmp-issues
  $ ./gradlew build
  
  # Run the binary on Mac (M1)
  $ native/build/bin/macosArm64/releaseExecutable/native.kexe
      Making a https request...
      {
        "args": {},
        "headers": {
          "Accept": "*/*",
          "Accept-Charset": "UTF-8",
          "Accept-Encoding": "deflate, gzip",
          "Content-Length": "0",
          "Host": "httpbin.org",
          "User-Agent": "ktor-client",
          "X-Amzn-Trace-Id": "Root=1-67fd9924-55a092a9286f55ae015c82d5"
        },
        "origin": "184.185.65.20",
        "url": "https://httpbin.org/get"
      }
  
  # Run on linux container (Using Rancher/Docker Desktop)
  $  docker run  \
           -it \
           --rm \
           --publish 8080:80 \
           --mount type=bind,source=$(pwd),destination=/app,readonly \
           debian:stable-slim
     root@3a3b75ff27cb:/# /app/native/build/bin/linuxArm64/releaseExecutable/native.kexe
     Uncaught Kotlin exception: kotlin.IllegalStateException: TLS verification failed for request: CurlRequestData(url='https://httpbin.org/get', method='GET', content: 0 bytes). Reason: SSL peer certificate or SSH remote key was not OK
      at 0   native.kexe                         0x6270db           kfun:io.ktor.client.engine.curl.internal.CurlMultiApiHandler#perform(){} + 9147
      at 1   native.kexe                         0x6222ff           kfun:io.ktor.client.engine.curl.CurlProcessor.CurlProcessor$runEventLoop$1.$invokeCOROUTINE$0.invokeSuspend#internal + 591
      at 2   native.kexe                         0x4aa6c3           kfun:kotlin.coroutines.native.internal.BaseContinuationImpl#resumeWith(kotlin.Result<kotlin.Any?>){} + 147
      at 3   native.kexe                         0x53a253          
  ```

## Issues

- [KTOR-8393](https://youtrack.jetbrains.com/issue/KTOR-8393/Ktor-client-curl-client-engine-TLS-cert-error)

<!-- Badges -->

[java_url]: https://www.azul.com/downloads/?version=java-21-lts&package=jdk#zulu

[java_img]: https://img.shields.io/badge/OpenJDK-21-e76f00?logo=openjdk&logoColor=e76f00

[kt_url]: https://github.com/JetBrains/kotlin/releases/latest

[kt_img]: https://img.shields.io/github/v/release/Jetbrains/kotlin?include_prereleases&color=7f53ff&label=Kotlin&logo=kotlin&logoColor=7f53ff

