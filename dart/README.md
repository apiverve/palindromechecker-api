# Palindrome Checker API - Dart/Flutter Client

Palindrome Checker tests whether a string reads the same forwards and backwards, with options to ignore casing, spacing, and punctuation. It returns the boolean verdict, the normalized text, the reversed comparison string, and the length of the longest palindromic sequence.

[![pub package](https://img.shields.io/pub/v/apiverve_palindromechecker.svg)](https://pub.dev/packages/apiverve_palindromechecker)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Palindrome Checker API](https://apiverve.com/marketplace/palindromechecker?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_palindromechecker: ^1.2.5
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_palindromechecker/apiverve_palindromechecker.dart';

void main() async {
  final client = PalindromecheckerClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'text': 'A man a plan a canal Panama',
      'ignorecase': true,
      'ignorespaces': true,
      'ignorepunctuation': true
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "text": "A man a plan a canal Panama",
    "is_palindrome": true,
    "cleaned_text": "amanaplanacanalpanama",
    "reversed_text": "amanaplanacanalpanama",
    "length": 21,
    "options": {
      "ignore_case": true,
      "ignore_spaces": true,
      "ignore_punctuation": true
    },
    "longest_palindrome_substring": "amanaplanacanalpanama",
    "longest_palindrome_length": 21
  }
}
```

## API Reference

- **API Home:** [Palindrome Checker API](https://apiverve.com/marketplace/palindromechecker?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/palindromechecker](https://docs.apiverve.com/ref/palindromechecker?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
