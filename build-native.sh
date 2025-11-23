#!/bin/bash
set -e

# Build native executable using GraalVM native-image
# Requires GraalVM with native-image component installed

echo "Compiling Clojure code..."
clj -M -e "(compile 'script)"

echo "Building native image..."
native-image \
  --initialize-at-build-time \
  --report-unsupported-elements-at-runtime \
  -Dclojure.compiler.direct-linking=true \
  --gc=G1 \
  -H:+ReportExceptionStackTraces \
  -H:Name=script \
  -cp "$(clj -Spath -M:test)" \
  script

echo "Native executable built: ./script"

