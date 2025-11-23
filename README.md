# clj.native-cli

This is a native CLI tool built with Clojure and GraalVM.

This project uses Clojure 1.11.3 and clojure.tools.cli 1.0.219 for argument parsing. Native executables are built directly with GraalVM's native-image tool.

## Features

- Native executable compilation with GraalVM
- Proper error handling and exit codes
- Comprehensive help text and usage information
- Test infrastructure with clojure.test
- Optimized GraalVM build configuration

## Development

Run the program directly:
```bash
$ clojure -m script --help
Usage: script [options]

Options:
  -h, --help  Show this help message

Examples:
  script --help    Show this help message
```

Run tests:
```bash
$ clojure -M:test -e "(require 'script-test) (clojure.test/run-tests 'script-test)"
```

## Building

Compile a native executable:
```bash
$ ./build-native.sh
$ ./script --help
```

The native executable can be distributed without requiring Clojure or the JVM to be installed. The build uses G1 garbage collector and optimized settings for better performance.

The build script uses GraalVM's native-image tool directly, with no external dependencies.

## Project Structure

```
clj.native-cli/
├── src/
│   └── script.clj      # Main CLI application
├── test/
│   └── script_test.clj  # Test suite
├── build-native.sh      # Native build script
├── deps.edn             # Dependencies and build configuration
└── README.md            # This file
```

## Requirements

- Clojure CLI tools (clj)
- GraalVM with native-image component
